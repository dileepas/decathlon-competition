
## Decathlon competition
Java program that would calculate the results of a Decathlon competition.

## Possible Inputs
A CSV file containing the raw results of the competition.

## Output
An XML file which contains all the athletes in ascending order of their places. Athletes should have all the result
data from the CSV file plus calculated total score and the place in the competition. In case of equal scores, athletes
must share the places, e.g. 3-4 and 3-4 instead of 3 and 4.

## Used technologies
Project is written in java.

## Build
This project is built with maven.
Useful maven commands:

* `install` (simply compiles the project)
* `clean` (cleans the build)

example : `mvn clean install`

## Run the program
* Execute `com.decathlon_competition.Main.java`

* `mvn exec:java -Dexec.mainClass="com.decathlon_competition.Main"` (maven command to run the main class)
* Or run `com.ordermatcher.Main.java` in any java support IDE 


