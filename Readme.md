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

Once the Spring Boot application is up and running, it takes arguments of file and date and directs to findMostActiveCookies method in the CookieService Class.

Inside the method, it first reads the file and then filters the file with respect to the given date and maps the count of each cookie and finally return the cookies with maximum count.

## Code Coverage information

Code coverage information can be found at location -> `build/reports/jacoco/test/html/index.html` file.
