# Java Todo API

A simple RESTful Todo API built with Spring Boot. This project allows you to manage a list of todo items with basic CRUD operations.

## Features
- Create, read, update, and delete todo items
- RESTful API endpoints
- PostgreSQL database (default)
- Easily switchable to other databases via configuration

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- PostgreSQL database (running and accessible)

### Running the Application

1. **Clone the repository:**
   ```bash
   git clone https://github.com/shathwik44/java-todo-api.git
   cd java-todo-api
   ```
2. **Configure PostgreSQL connection:**
   - Make sure PostgreSQL is running.
   - Create a database for the app (e.g., `todo_db`).
   - Update `src/main/resources/application-local.properties` with your PostgreSQL credentials:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/todo_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```
3. **Build and run using Maven:**
   ```bash
   ./mvnw spring-boot:run
   ```
   Or, to build a jar:
   ```bash
   ./mvnw clean package
   java -jar target/java-todo-api-0.0.1-SNAPSHOT.jar
   ```

### API Endpoints

| Method | Endpoint         | Description           |
|--------|------------------|-----------------------|
| GET    | /todos           | List all todos        |
| GET    | /todos/{id}      | Get todo by ID        |
| POST   | /todos           | Create a new todo     |
| PUT    | /todos/{id}      | Update a todo         |
| DELETE | /todos/{id}      | Delete a todo         |

#### Example Todo JSON
```json
{
  "title": "Buy groceries",
  "description": "Milk, Bread, Eggs",
  "completed": false
}
```

### Configuration
- Default properties are in `src/main/resources/application-local.properties`.
- To use a different profile, set the `spring.profiles.active` environment variable.

### Testing
Run tests with:
```bash
./mvnw test
```

## Project Structure
- `controller/` - REST controllers
- `model/` - Entity classes
- `repository/` - Spring Data JPA repositories

## License
This project is licensed under the MIT License.
