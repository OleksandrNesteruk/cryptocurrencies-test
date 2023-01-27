# Cryptocurrencies-tests

Rest Endpoints:
-  GET ```/cryptocurrencies/minprice?name=[currency_name]``` -  return record with the lowest price of selected cryptocurrency.
-  GET ```/cryptocurrencies/maxprice?name=[currency_name]``` -  return record with the highest price of selected cryptocurrency
[currency_name] possible values: BTC, ETH or XRP. 
-  GET ```/cryptocurrencies?name=[currency_name]&page=[page_number]&size=[page_size]``` -  return a selected page with selected number of elements and default sorting should be by price from lowest to highest. For example, if page=0&size=10, then you should return first 10 elements from database, sorted by price from lowest to highest.
```[page_number]``` and ```[page_size]``` request parameters  optional, so if they are missing then default values ```page=0, size=10```.
* Generate a CSV report.
    - GET ```/cryptocurrencies/csv```
      Report contain the following fields: Cryptocurrency Name, Min Price, Max Price. So there  only three records in that report, because we have three different cryptocurrencies.

## Used technologies
* Java (17);
* Spring Boot, Spring Data;
* Mockito, JUnit, SpringBoot Test;
* MySQL, SQL;
* Hibernate, JPA;

## How to Launch
1. Clone or download repository;
2. Create schema named `crypto` in MySQL;
3. Add your database URL, username, password and JDBC driver into corresponding fields in `src/main/resources/application.properties`.
4. Run the application.
5. You can inject custom data by sending POST request to `/cryptocurrencies/inject`.
6. After that Test must work.