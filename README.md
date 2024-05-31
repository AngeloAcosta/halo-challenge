# Automation Halo Challenge with Selenium WebDriver

## Project Overview
This automation project is crafted to showcase proficiency in web application testing automation using Selenium WebDriver. The project employs the Page Object Model (POM) design pattern and is built with Maven for dependency management and TestNG as the testing framework. The programming language used is Java.

## Prerequisites
Ensure you have the following prerequisites installed before running this project:

- [Java Development Kit (JDK) 8 or higher](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven 3.6.0 or higher](https://maven.apache.org/download.cgi)
- [IntelliJ IDEA or your preferred IDE](https://www.jetbrains.com/idea/download/)
- A compatible web browser (Chrome)


## Project Setup
1. Clone the repository to your local machine:
    ```sh
    git clone https://github.com/AngeloAcosta/halo-challenge.git
    ```
2. Navigate to the project directory:
    ```sh
    cd halo-project
    ```
3. Execute the following command to download the project dependencies:
    ```sh
    mvn clean install
    ```

## Running the Tests
To execute the tests, use the following Maven command:
```sh
mvn test
 ```

## Technologies Used
* Java: Programming language for project development.
* Selenium WebDriver: Tool for automating web browser interactions.
* Page Object Model (POM): Design pattern for organizing test code.
* Maven: Dependency management and project build tool.
* TestNG: Testing framework for test execution and reporting.

## Context of Automated Web
This automation shows 3 possible cases that an unregistered/logged user can perform without the need to have an account, such as searching for products, entering sections and changing their location.
These scenarios are covered in these tests.
### TC001 : 
Validation of the Product Purchase flow with an Anonymous User (Without logging in). Covering the search by user criteria, expecting a list of products as a result, entering to the desired item, viewing the product detail and clicking on the 'Buy now' button available, and redirecting to the previous validation to 'Buy now' .
### TC002:
Validation of safe navigation of Categories. Covering access to 'Categories' from the navBar, accessing the 'Technology' section and filtering by 'Consoles and Video Games'.
### TC003:
Validation of zone location change from the Home Page. Covering the selection of valid Department and City, viewing said change in the Home
