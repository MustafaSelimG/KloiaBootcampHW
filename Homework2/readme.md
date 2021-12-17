# API Automation
>*includes* Selenium , Cucumber , Gherkin , Karate , API , Test Automation
  ## Kata_1
   **Scenario: print task**</br>
      * print 'Hello World!'</br>
      * karate.log("my first log!")</br>
 </br>
  **Scenario: variables printing**</br>
      * def myFirstVar = 'Hello World!'</br>
      * def mySecondVar = 20</br>
      * print myFirstVar,mySecondVar</br>
 </br>
  **Scenario: config print task**</br>
      * print appId</br>

  **Scenario: printing JSON file**</br>
      * def myJson =</br>
       """</br>
           {</br>
           "id": 0,</br>
           "name": 'example',</br>
           "status": "available",</br>
       };</br>
       """</br>
      * print myJson </br>
    </br>
  
![task1](https://user-images.githubusercontent.com/88919177/145682652-15206dcb-bfa7-4eda-9e19-bc73c78a13ed.gif)


   **Scenario: Get request to pet endpoint**</br>
     *Given* url 'https://petstore.swagger.io/v2/pet/250'</br>
     *When* method GET</br>
     *Then* print response</br>
</br>
   **Scenario: Matchers**</br>
     *Given* url 'https://petstore.swagger.io/v2/pet/1'</br>
     *When* method GET</br>
     *Then* status 200</br>
     *And* match response.id == 1</br>
     *And* match response.name == '#string'</br>
     *And* match response.status == '#present'</br>
</br>
   **Scenario: Path params and matchers**</br>
     *Given* url 'https://petstore.swagger.io/v2/'</br>
     *And* def id = 1</br>
     *And* path 'pet', id</br>
     *When* method GET</br>
     *Then* status 200</br>
     *And* match response.id == id</br>
     *And* match responseHeaders['Content-Type'][0] == 'application/json'</br>
</br>
   **Scenario: post request with json defined in feature**</br>
     *Given* url 'https://petstore.swagger.io/v2/'</br>
     *And* path 'pet'</br>
     *And* def myBody =</br>
      """</br>
          {</br>
          "id": 38155,</br>
          "name": 'example',</br>
          "status": "available",</br>
        };</br>
      """</br>
     *And* request myBody</br>
     *When* method POST</br>
     *Then* status 200</br>
     *And* print response</br>
</br>
![task2](https://user-images.githubusercontent.com/88919177/145683936-8da60236-1c72-4912-9e62-d657fcbde87a.gif)
</br>
  ## Kata_2
   **Background:**</br>
   *Given* url baseUrl</br>
</br>
  **Scenario: post request with json**</br>
    *And* path 'pet'</br>
    *And* def myBody = read('classpath:data/myJson.json')</br>
    *And* set myBody.name = 'newName'</br>
    *And* set myBody.id = 2022</br>
    *And* request myBody</br>
    *When* method POST</br>
    *Then* status 200</br>
    *And* match response.id == myBody.id</br>
    *And* match response.name == myBody.name</br>
    *And* match response.status == myBody.status</br>
</br>
  **Scenario Outline: get pet from table**</br>
    *And* path 'pet',id</br>
    *When* method GET</br>
    *Then* status 200</br>
    Examples:</br>
      | id   |</br>
      | 3001 |</br>
      | 3002 |</br>
      | 3003 |</br>
</br>
  **Scenario Outline: get data from csv**</br>
    *And* path 'pet',id</br>
    *When* method GET</br>
    *Then* status 200</br>
</br>
    Examples:</br>
    | read('classpath:data/data.csv') |</br>
</br>
  **Scenario Outline: post request from table**</br>
    *And* path 'pet'</br>
    *And* def myBody = read('classpath:data/myJson.json')</br>
    *And* set myBody.id = id</br>
    *And* set myBody.name = name</br>
    *And* set myBody.status = status</br>
    *And* request myBody</br>
    *When* method POST</br>
    *Then* status 200</br>
</br>
    Examples:</br>
      | read('classpath:data/example.csv') |</br>
      </br>
      
![task3](https://user-images.githubusercontent.com/88919177/145688684-9a0f9c5e-8b4d-4995-8f3c-13aa91becf0f.gif)

</br>

  **Scenario: reading data from json** </br>
    * def myVar = read('classpath:data/myJson.json') </br>
    * print myVar</br>
</br>
  **Scenario: writing data to json**</br>
    * def myVar = read('classpath:data/myJson.json')</br>
    * set myVar.name = "demo"</br>
    * print myVar</br>
</br>
  **Scenario Outline: printing table variables**</br>
    * print id</br>
    Examples:</br>
    | id   |</br>
    | 3001 |</br>
    | 3002 |</br>
    | 3003 |</br>

</br>

![task4](https://user-images.githubusercontent.com/88919177/145688847-3a123c5f-dbe7-4058-9c9a-876c37ac3e4c.gif)

</br>

  ## Kata_3 </br>
   **Background:**</br>
    *Given* url baseUrl </br>
</br>
  **Scenario: call post feature**</br>
    * def callToPost = call read('classpath:callers/caller.feature@name=post')</br>
    * match callToPost.responseStatus == 200</br>
    * print callToPost.response</br>
</br>
  **Scenario: call get feature**</br>
    * def myID = 1</br>
    * def callToGet = call read('classpath:callers/caller.feature@name=get'){id: #(myID)}</br>
    * match callToGet.response.id == myID</br>
</br>
  
  ![task5](https://user-images.githubusercontent.com/88919177/145688921-8d14a5e2-f44b-4696-b226-9c4524719d18.gif)
  

