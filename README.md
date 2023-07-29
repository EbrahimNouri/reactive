
```
# Spring Boot Reactive Project

This is a sample Spring Boot project that demonstrates the use of Reactive programming with Spring WebFlux and R2DBC to interact with a PostgreSQL database. The project provides an API to manage and retrieve data related to people and courses.

## Technologies Used

- Spring Boot 2.x
- Spring WebFlux
- R2DBC (Reactive Relational Database Connectivity)
- PostgreSQL (as the database)
- Lombok (for boilerplate code reduction)

## Prerequisites

- Java 11 or higher
- PostgreSQL database setup with a "person" and "course" table (see database schema in `schema.sql`)

## How to Run

1. Clone this repository to your local machine.
2. Configure your PostgreSQL database connection in `application.properties`.
3. Run the application using Maven:

```shell
mvn spring-boot:run
```

The application will start on port 8080 by default.

## Endpoints

### Get All People

Get a list of all people in the database.

```
GET /api/person
```

### Get Person by ID

Retrieve a person by their ID.

```
GET /api/person/{id}
```

### Create New Person

Create a new person.

```
POST /api/person

Request Body:
{
  "name": "John Doe"
}
```

### Update Person

Update an existing person by their ID.

```
PUT /api/person/{id}

Request Body:
{
  "name": "Updated Name"
}
```

### Delete Person

Delete a person by their ID.

```
DELETE /api/person/{id}
```

### Get All Courses

Get a list of all courses in the database.

```
GET /api/course
```

### Get Course by ID

Retrieve a course by its ID.

```
GET /api/course/{id}
```

### Create New Course

Create a new course.

```
POST /api/course

Request Body:
{
  "name": "Mathematics"
}
```

### Update Course

Update an existing course by its ID.

```
PUT /api/course/{id}

Request Body:
{
  "name": "Updated Course Name"
}
```

### Delete Course

Delete a course by its ID.

```
DELETE /api/course/{id}
```

## Contributing

Contributions to this project are welcome. Feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```

Please make sure to update the sections like "Technologies Used," "Prerequisites," and "Contributing" with the relevant information for your project. Also, update the API endpoints, if needed, based on the actual endpoints provided by your application. The `LICENSE` section should be replaced with the license you choose for your project.
