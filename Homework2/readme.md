# Homework2
>*includes* Selenium , Cucumber , Gherkin , Karate , API , Test Automation

  **Background:**</br>
   * def baseURI = 'https://petstore.swagger.io/v2'</br>
   * def helper = Java.type('helpers.Helper')</br>
</br>
  ## Task1
   **Scenario Outline: verify given status**</br>
      *Given* url 'https://petstore.swagger.io/v2/pet/findByStatus?status=<status>'</br>
      *When* method GET</br>
      *Then* status 200</br>
      *And* match responseHeaders['Content-Type'][0] == 'application/json'</br>
      *And* match $..id each contains '#present'</br>
      *And* match $..id each contains '#notnull'</br>
      *And* match $..status contains '<status>'</br>
      *And* print response</br>
      </br>
    Examples:</br>
    |status   |</br>
    |available|</br>
    |pending  |</br>
    
![task1](https://user-images.githubusercontent.com/88919177/146497713-38d7348b-8698-4256-ad2e-2282c7588cef.gif)

 </br>
 ## Task2
  **Scenario: generate emails**</br>
      * print 'email:' , helper.emailGenerator()</br>
![task2](https://user-images.githubusercontent.com/88919177/146497793-7f376da9-b28b-4c7a-bc98-dc47dcd03134.gif)
 </br>
  ## Task3
  **Scenario: set and post user json file**</br>
      *And* def user = read('classpath:data/user.json')</br>
      *Given* url baseURI</br>
      *And* header Content-Type = 'application/json'</br>
      *And* path 'user'</br>
      *And* def id = helper.idGenerator()</br>
      *And* set user.id = id</br>
      *And* set user.username = helper.usernameGenerator()</br>
      *And* set user.firstname = helper.firstnameGenerator()</br>
      *And* set user.lastname = helper.lastnameGenerator()</br>
      *And* set user.email = helper.emailGenerator()</br>
      *And* set user.password = helper.passwordGenerator()</br>
      *And* set user.phone = helper.phoneGenerator()</br>
      *And* set user.userStatus = helper.statusGenerator()</br>
      *And* request user</br>
      *And* method POST</br>
      *And* status 200</br>
      *And* match user.id == id</br>
      * print user</br>
      * print response</br>
      
      ![task3](https://user-images.githubusercontent.com/88919177/146498079-aef6bb1e-fc14-4a7d-b9e4-1465c87fab62.gif)

 </br>
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
  

