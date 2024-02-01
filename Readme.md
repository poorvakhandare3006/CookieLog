# CookieLog

CookieLog is a project developed in SPRING BOOT which when given File with Cookie logs and a Date will return the most active cookie for that specific day.

## Pre-requisites

Open JDK 17

## Usage

Run the program using `./gradlew bootRun -Pargs="-f file_path -d yyyy-mm-dd"` command.

Here -Pargs has the arguments of file and date. `file_path` is the actual path of file with Cookie logs and date format is `YYYY-MM-DD`.

Run `./gradlew test` for running Unit Tests.

Run `./gradlew clean test jacocoTestReport` for Code coverage Reports.

## Program control flow.

Once the Spring Boot application is up and running, it takes arguments of file and date.
It sets the filename and stores all the cookies in the files (in Singleton class)

It then directs to findMostActiveCookies method in the CookieLogController Class which then gets the most active cookie from the service Layer logic and returns List.


## 
##


Cookie Model has Cookie_ID and timestamp as Parameters.

JUnit Tests are written.

Records are used in Models.

Interfaces can be used in future scope when complex logic, more Abstraction or Inheritance is required.

For future Scope, we can also set a flag that the filename can also be set only once.



CookieLogRepository as Singleton Class as it will only have one instance. It has setDataFromFile method which will take filename and set cookies data. getCookies method whenever called will return list of cookies for given instance.

OffsetDateTime format is used. We can use LocalDateTime,etc too as we are only comparing the date, so the time precision is not required.




## Code Coverage information

Code coverage information can be found at location -> `build/reports/jacoco/test/html/index.html` file.
