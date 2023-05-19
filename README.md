# Employee System 
Backend for VSTU Employee System course project

## Build

### Step 1 - Clone the repository
```bat
git clone https://github.com/NeDonil/EmployeeSystemBackend
cd EmployeeSystemBackend
```

### Step 2 - Build project

‼️Make sure ```src/main/resources/application.properties``` contains correct credentials(database name, user, pswd)
#### Maven
```bat
./mvnw spring-boot:run
```

#### Docker
```bat
./mvnw package dockerfile:build -DskipTests
docker-compose up
```
## API

### Users CRUD

- Create new user 

`POST /users/`
```json
{"name" : "username"}
``` 

 - Get all tasks
`GET /users/`

- Edit exising task by id
`PUT /users/{id}` 
```json
{"name" : "newUsername"}
```

- Delete existing task by id
`DELETE /users/{id}`


### Tasks CRUD

- Create new task 

`POST /tasks/`
```json
{"name" : "taskName", "text" : "taskText"}
``` 

 - Get all tasks
`GET /tasks/`

- Edit existing task by id
`PUT /tasks/{id}` 
```json
{"name" : "taskName", "text" : "taskText"}
```

- Delete exising task by id
`DELETE /tasks/{id}`

### Role CRUD

- Create new role 

`POST /roles/`
```json
{"name" : "rolename"}
``` 

 - Get all tasks
`GET /roles/`

- Edit exising task by id
`PUT /roles/{id}` 
```json
{"name" : "newRolename"}
```

- Delete exising task by id
`DELETE /roles/{id}`

  


