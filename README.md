# TestiSelenium

This project is an open source framework integrating java and maven and offers automatic automatonization for ui testing on a given site in Selenium, JUnit and Log4j target libraries 

## Features

- Hard-coded strings will be defined and used as Constants.
- Logging events and levels will be more regular.
- Selenium libraries will be used more healthily (Some performance issues)

> Frankly, using libraries that I have never used made me feel a little different. This includes the Java programming language :) 

## Tech

TestiSelenium uses a number of open source projects to work properly:

- [Selenium Support](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/support/package-summary.html) - Used for UI operations.
- [Selenium Chrome Driver](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/chrome/ChromeDriver.html) - Used for the application controlling a Chrome browser running on the local machine.
- [Log4j](http://logging.apache.org/log4j/1.2/) - Userd for logging.
- [JUnit 5](https://junit.org/junit5/) - Used for developer-side testing.

## Installation

TestiSelenium requires 
- [Maven](https://maven.apache.org/download.cgi) v3.3+ to run.
- [JDK](https://openjdk.java.net/) v1.7+ to run.


Install the dependencies and start the test.

```sh
mvn install
mvn test WebAutomationTest
```

## Development

Want to contribute?  Great!

- Create a personal fork of the project on Github.
- Clone the fork on your local machine. Your remote repo on Github is called origin.
- Add the original repository as a remote called upstream.
- If you created your fork a while ago be sure to pull upstream changes into your local repository.
- Create a new branch to work on! Branch from develop if it exists, else from master.
- Implement/fix your feature, comment your code.
- Follow the code style of the project, including indentation.
- If the project has tests run them!
- Write or adapt tests as needed.
- Add or change the documentation as needed.
- Squash your commits into a single commit with git's interactive rebase.      
- Create a new branch if necessary.
- Push your branch to your fork on Github, the remote origin.
- From your fork open a pull request in the correct branch. Target the project's develop branch if there is one, else go for master!
- Once the pull request is approved and merged you can pull the changes from upstream to your local repo and delete your extra branch(es).

## License

/ MIT /
