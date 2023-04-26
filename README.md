# Mixam Java Challenge

Goal was to create a small contact form with some front-end and back-end validation.

The form itself does nothing besides that, not saving or sending user input. 
Back-end validation happens after POST submit.

Included JUnit tests for Controller actions and form DTO validation. 

## Installation

Pull the repo locally and import it in your favourite IDE. I use [STS](https://spring.io/tools).

Usually when starting Spring boot would install all the required dependancies for you but if that doesn't happen right click on the `project -> run as -> maven install`

Alternatively you can do it through the console
```bash
mvn install
```

if maven is not installed on the machine execute this instead at the root of the repository
```bash
mvnw install
```

Boot the server right clicking `project -> run as -> spring boot app`.

## Going further
When app is booted visit `localhost:8080/contact` to see all the magic happen.

## Testing
Executing tests can be done via IDE or Console again:
`project -> run as -> JUnit test`  or alternatively can be run in console:
```bash
mvn clean test
```

or if maven is not installed. 
```bash
mvnw clean test
```


## Versions
Spring Boot: 3.0.6

Java: 20

## Technologies used
Spring Boot

Thymeleaf

Bootstrap

### Notes
In order to execute commands in CMD, java will need to be added to home path. Applies to windows, mac and linux machines. Please see [here](https://www.google.com/) on how to do this.