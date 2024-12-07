# identity e2e test

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java Development Kit (JDK) installed (version 11 or later)
- Maven build tool installed
- [ChromeDriver](https://sites.google.com/chromium.org/driver/) installed and available in the system PATH
- [Firefox Driver](https://github.com/mozilla/geckodriver/releases) (optional, if using Firefox)
- Install 'Gherkin' plugin in IDE

## Getting Started

1. Clone the repository:
git clone https://github.com/Saral-raj/Identity-E2E-Technical-Test.git

## Project Structure
src/main/java: Contains production source code.
src/test/java: Contains automated test source code.
src/test/resources: Contains test resources, such as feature files and configuration files.
target: Contains generated files and reports.

##Running the Tests
mvn clean verify

##Reporting
After running the tests, open the target/site/serenity/index.html file in a web browser to view the test results.



