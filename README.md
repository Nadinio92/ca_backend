# Financial Application Backend Service README
Welcome to the repository for the backend development of our Financial Application! 
This project focuses on building a robust backend service that empowers Research Directors to efficiently assign analysts to companies and manage the assoc datiateda.
The backend service is developed from scratch using Spring Boot, encompassing various layers such as REST Controllers, Services, DAO/Repositories, and Entity/Persistence. 
The application leverages Spring Data JPA (Hibernate Framework) for seamless Object-Relational Mapping (ORM) and integrates an H2 database for data storage. 
To ensure reliability, the project also employs testing using Mockito.
## Features
* #### Efficient Assignment Management: 
This backend service streamlines the process of assigning analysts to specific companies, enabling Research Directors to manage data and assignments seamlessly.

* #### Layered Architecture:
The application follows a structured architecture to ensure maintainability and separation of concerns:

###### REST Controllers: 
Expose API endpoints for handling incoming requests and managing data flow.
###### Service Layer: 
Houses business logic and orchestrates operations based on incoming requests.
###### DAO/Repository Layer: 
Manages data access and storage through interactions with the H2 database.
###### Entity/Persistence Layer: 
Represents data models and their relationships, facilitating ORM.
* #### Spring Data JPA and Hibernate: The app
 The application harnesses the power of Spring Data JPA, powered by Hibernate, for effective Object-Relational Mapping. This abstraction eliminates the need for manual SQL queries and simplifies database interactions.

* #### H2 Database:
The project integrates an H2 database, providing an in-memory, lightweight, and user-friendly database solution. It's particularly suitable for development and testing.

* #### Testing with Mockito:
The project is built with a focus on quality and reliability. The application's functionality is tested using the Mockito framework to ensure accurate results and robustness.
Getting Started
To get the project up and running on your local machine, follow these steps:

