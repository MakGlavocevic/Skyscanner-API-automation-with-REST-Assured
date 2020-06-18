# Skyscanner-API-automation-with-REST-Assured
Testing API with REST Assured and Junit

## Overview

This automation test was created as a part of a work task. It uses Skyscanner Flight Search API from rapidapi.com

This test represents a smoke test and the main objectives are to see if the API responds to our GET requests as it should 

rapidapi.com link: https://rapidapi.com/skyscanner/api/skyscanner-flight-search/details

--------------------------------------

## Prerequisites
1.Java SDK (https://www.oracle.com/java/technologies/javase-downloads.html)

2.IntelliJ IDEA Community Edition (https://www.jetbrains.com/idea/)

3.REST Assured (https://mvnrepository.com/artifact/io.rest-assured/rest-assured)

4.Junit (https://mvnrepository.com/artifact/junit/junit)

--------------------------------------

## How to run

1. Install latest Java SDK 

2. Install latest IntelliJ IDEA Community Edition

3. Clone my git repository

4. Open IntelliJ IDEA Community Edition

5. Open the folder where my project is

6. In the Project window on the sidebar go to pom.xml and see if all of the required dependencies are up to date

7. Go to src>test>java and click on TestRequest there you can right click and select Run to run the test.

8. In case you want to do the test with different data then mine then you can change the data in the 18th line of code. 

--------------------------------------

 Here are some example of data:

 {Country} (US, UK, DE, FR, BA)

 {Currency} (USD, GBP, EUR)

 {Locale} (en-GB, en-US, fr-FR)

 {Place} (Any name of a town in the world that has an Airport) 
