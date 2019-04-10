# RadioTrax API Sample - Java

This repository contains a simple Java HTTP client application that
makes API calls to the Cognosos RadioTrax API. 

The sample app uses **Apache HttpClient** and **Jackson JSON** 
to synchronously post updates. It is a Gradle 5 project

#### Running the Example

1. Edit `ApiTestData.java` in `src/main/java/com/cognosos/radiotrax/apiclient/` 
and change `API_APP_CODE`, `API_USERNAME`, and `API_PASSWORD` to the values provided by Cognosos Support. 

2. If desired, edit `InventoryData.java` to represent the fields in your inventory integration.

3. Build and run the code.

   a. If you're on Windows, run `.\gradlew.bat run`

   b. If you're on Mac, or a Unix OS, run `./gradlew run`

4. Observe Results

   * `Executing request POST ... to ...` indicates the request was sent to the server. 
   * `HTTP/1.1 200 OK` indicates the data was successfully posted
   * `HTTP/1.1 401 Unauthorized` indicates the username, password, or application_code was incorrect.


