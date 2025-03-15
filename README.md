# NEdit

NEdit is text editing software made with Java and Java Swing. It is used for simple file editing, allowing for creating, opening, and saving files.

In the future, there will be UI changes and support for shortcuts and more editing features (e.g. find/replace).

## Prerequisites

* JDK 21 (to run the JAR, only JRE 21 is needed)
* When building, make sure the JAVA_HOME environment variable is set to the path to the JDK

## Build

To build NEdit, run: `./mvnw package` (Mac/Linux) or `mvnw.cmd package` (Windows)

## Run

To run NEdit, run: `java -jar ./target/NEdit-1.0-SNAPSHOT.jar`