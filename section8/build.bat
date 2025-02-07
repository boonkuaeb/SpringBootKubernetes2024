@echo off
cd
call docker image prune -a -f
call docker images | findstr "john3kuae/eazybytes"

cd configserver
echo Building configserver starting
:: Clean the project
call mvn clean install -Dmaven.test.skip=true

:: Install the project

:: Build the Docker image using Jib
call mvn compile jib:dockerBuild

cd ../eurekaserver
echo Building eurekaserver starting

:: Clean the project
call mvn clean install -Dmaven.test.skip=true

:: Install the project

:: Build the Docker image using Jib
call mvn compile jib:dockerBuild

cd ..
:: Clean the project
call mvn clean install -Dmaven.test.skip=true
:: Install the project
cd accounts
echo Building accounts starting

:: Build the Docker image using Jib
call mvn compile jib:dockerBuild

:: Install the project
cd ../loans
echo Building Loan starting

:: Build the Docker image using Jib
call mvn compile jib:dockerBuild


:: Install the project
cd ../cards
echo Building cards starting

:: Build the Docker image using Jib
call mvn compile jib:dockerBuild




cd ..
echo Docker images

call docker images | findstr "john3kuae/eazybytes"

set IMAGE_PREFIX=docker.io/john3kuae/
set TAG=:s8

for %%i in (eazybytes-accounts, eazybytes-loans, eazybytes-cards, eazybytes-configserver, eazybytes-eurekaserver) do (
  call docker image push %IMAGE_PREFIX%%%i%TAG%
)
