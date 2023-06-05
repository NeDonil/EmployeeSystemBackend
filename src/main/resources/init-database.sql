drop table if exists event cascade;

create table event(
    event_id SERIAL PRIMARY KEY,
    event_date date,
    name varchar(255),
    employee_id bigint
);

CREATE OR REPLACE FUNCTION on_employee_delete()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO event (event_date, name, employee_id)
    VALUES (CURRENT_DATE, 'delete', OLD.employee_id);
    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER employee_delete_trigger
AFTER DELETE ON employee
FOR EACH ROW
EXECUTE FUNCTION on_employee_delete();

CREATE OR REPLACE FUNCTION on_employee_insert()
RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO event (event_date, name, employee_id)
    VALUES (CURRENT_DATE, 'insert', NEW.employee_id);
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER employee_insert_trigger
AFTER INSERT ON employee
FOR EACH ROW
EXECUTE FUNCTION on_employee_insert();
