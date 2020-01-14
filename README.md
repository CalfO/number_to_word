# Number to word
This repo is the result of a Coding Kata named number to letter.

## Prerequisite
Java 11 and maven need to be installed.
### Check before install
    java -version 
    mvn --version

## Build
    mvn clean install

## Run
    cd target
    java -jar numbertowords-1.0.0-SNAPSHOT.jar

You should see initialization of spring boot then `shell:>` should be displayed 
## Usage
    help                    =>  show all available commands    
    number-to-word <NUMBER> =>  Convert the input <NUMBER> into his equivalent string

## Limit
At the moment the numbers handled by this project are on the following range  
0  <= NUMBER < 10000 