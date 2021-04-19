# Higher-Order Functions Exercises

This project contains several exercises to strengthen your skills with
functional programming, particularly as manifest in higher-order
functions and [Java's Streams library](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/stream/package-summary.html).
The exercises can all be found in `HigherOrderFunctionsLearningTest`.
As the name implies, these are not proper _unit tests_ because they test no 
unit of production code; rather, they are _learning tests_, using the
JUnit framework to explore our understanding of the language and libraries.

## Running the Tests

From within IntelliJ IDEA, right-click on the `test/java` folder,
and choose to run all the tests. Keep in mind that you can also 
run the tests through the debugger so that you can watch variables,
evaluate expressions, _etc._

## Data Files

The tests use two data files. Both contain change data from 
[Wikipedia's Soup Page](https://en.wikipedia.org/wiki/Soup).
The number of changes in each file is encoded in the suffix:
`soup04.json` contains four changes, and `soup30.json` contains 30.

## Troubleshooting

This Java project is powered by Gradle. Sometimes, Gradle and IntelliJ IDEA can
get out of sync. If the project is showing false-positive compiler errors,
try the following:

- Open the Settings, navigate to the Gradle tab, and make sure that Gradle
  is being run through JDK15. This will fix the problem where Gradle fails
  to start because of an older default version of the JVM being installed.
  
- Open the Project Structure, change the language level to something like 1.8,
  apply the settings, then change the language level back to 15. This will
  force a recompile that will often fix the problem.