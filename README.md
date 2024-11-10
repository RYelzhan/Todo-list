# Todo Management Application

## Description
The Todo Management Application is a Spring Boot-based application designed to help users manage their daily tasks. It provides a RESTful API to create, retrieve, update, and delete todo items. The application is secured with Spring Security using basic authentication and uses MySQL for data persistence.

## Features
- **Create Todo**: Add new todo items to the list.
- **Update Todo**: Modify existing todo items.
- **Delete Todo**: Remove todo items from the list.
- **List Todos**: View all user's todo items.

## Prerequisites
Before you begin, ensure you have met the following requirements:
- **Java 17** or higher installed.
- **Maven** installed (if running locally with Maven).
- **MySQL** server running and accessible.

## Configuration
Update the `src/main/resources/application.properties` file to match your MySQL database settings:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```
Ensure you have created a database named `todo_db` in your MySQL instance.

## Running the Application

### Using Maven
To run the application using Maven, navigate to the root directory of the project in your terminal and run the following command:
```bash
mvn spring-boot:run
```

### Using Executable JAR
To build an executable JAR and run it, use the following commands:
```bash
mvn clean package
java -jar target/todoapp-0.0.1-SNAPSHOT.jar
```
## API Documentation
Swagger API documentation is available at:
```
http://localhost:8080/swagger-ui.html
```
This documentation provides a detailed view of all API endpoints, including the ability to try out the API directly from the browser.
## Security
The application is secured with HTTP Basic Authentication. Use the following default credentials to access the API:
```
Username: user
Password: password
```
## Contributing
Contributions to the Todo Management Application are welcome. Please ensure you create a pull request for review before any contributions are merged.

## License
This project is licensed under the MIT License - see the LICENSE file for details.

## Short Feedback
### Was it easy to complete the task using AI?
Partially. As AI is not up to date with ALL the technologies, and lacks expertise in some parts of development, I had to manually search and add them.
### How long did task take you to complete?
6 hours
### Was the code ready to run after generation? What did you have to change to make it usable?
No, code was not ready. The standards for coding changed, and some methods AI used became deprecated, requiring manual change.
### Which challenges did you face during completion of the task?
No real challenge. Everything was easy, according to level of module where task is from.
### Which specific prompts you learned as a good practice to complete the task?
Prompts of specifying the context, the task, and the code snippet for understanding. All of them were helpful to finish the task.
