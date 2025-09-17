# NEdit

NEdit is text editing software made with Java and Java Swing, using the [FlatLaf](https://www.formdev.com/flatlaf/) Look and Feel. It is used for simple file editing, allowing for creating, opening, and saving files.

In the future, there will be more editing features (e.g. find/replace).

## Prerequisites

* Git
* JDK 21 (to run the JAR, only JRE 21 is needed)
* Maven
* When building, make sure the JAVA_HOME environment variable is set to the path to the JDK

## Build

To build NEdit, run: 
1. `git clone https://github.com/DamareonC/NEdit`
2. `cd NEdit`
3. `./mvnw package` (Mac/Linux) or `mvnw.cmd package` (Windows)

## Run

To run NEdit, run: `java -jar ./target/NEdit-1.1.jar`