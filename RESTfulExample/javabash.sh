#!/bin/bash

echo creating build
mvn clean package
cd target
cp *.war /Users/lbomma/Documents/workspace/apache-tomcat-8.0.35/webapps/TestJava.war

