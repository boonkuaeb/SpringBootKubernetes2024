@echo off

call docker image prune -a -f
call docker images | findstr "john3kuae/eazybytes"


:: Clean the project
call mvn clean install -Dmaven.test.skip=true

:: Install the project
cd accounts

:: Build the Docker image using Jib
call mvn compile jib:dockerBuild

:: Install the project
cd ../cards

:: Build the Docker image using Jib
call mvn compile jib:dockerBuild

:: Install the project
cd ../loans

:: Build the Docker image using Jib
call mvn compile jib:dockerBuild


cd ../configserver
:: Clean the project
call mvn clean install -Dmaven.test.skip=true

:: Install the project

:: Build the Docker image using Jib
call mvn compile jib:dockerBuild


cd ..
call docker images | findstr "john3kuae/eazybytes"
