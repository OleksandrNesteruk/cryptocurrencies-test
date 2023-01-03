# Cryptocurrencies-test-task
## Used technologies
* Java (17);
* Spring Boot, Spring Data;
* Mockito, JUnit;
* MySQL;
* Hibernate;

## How to Launch
1. Clone or download repository;
2. Create schema named `crypto` in MySQL;
3. Add your database URL, username, password and JDBC driver into corresponding fields in `src/main/resources/application.properties`.
4. Run the application.
5. You can inject custom data by sending POST request to `/cryptocurrencies/inject`.
6. After that Test must work.