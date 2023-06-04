drop table if exists event cascade;

create table event(
    event_id SERIAL PRIMARY KEY,
    event_date date,
    name varchar(255),
    employee_id bigint references employee(employee_id)
);

create or replace function onEmployeeDelete()
    returns trigger as $$
begin
    insert into event(name, event_date, employee_id) VALUES ('delete', now(), old.employee_id);
end; $$
    language plpgsql;


create trigger beforeEmployeeDelete
    before delete on public.employee
    for each row execute function onEmployeeDelete();

create or replace function onEmployeeCreate()
    returns trigger as $$
begin
    insert into event(name, event_date, employee_id) VALUES ('create', now(), old.employee_id)
end; $$
    language plpgsql;

create trigger beforeEmployeeCreate
    before insert on public.employee
    for each row execute function onEmployeeCreate();