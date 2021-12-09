# SELENIUM x JUNIT5
This repository contains the source code testing a scenario on different applications created with different technologies (Angular, ReactJS, ...) found on the website [TodoMVC](https://todomvc.com/)

## Requirements
* **JDK** : JDK8 or higher is required
* **Maven** building tool

## Scenario
* Open the website
* Pick the application to test based on the technology used to created (example : backbone.js)
* Add for todos
* Mark the first and the third as done
* return the number of todos left wrapped in a WebElement object
* Test if this element contains "2 items left" as it's innerHtml

## Source Code description
This repository contains two classes handling the job
* **Scenario** : This class contains the scenario tested
* **ScenarioTest** : This class contains the two test methods one of them being parametrized to run several times using different todo applications from the website