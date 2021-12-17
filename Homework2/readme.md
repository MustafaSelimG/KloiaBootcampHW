# Homework2
>*includes* Selenium , Cucumber , Gherkin , Karate , API , Test Automation

  **Background:**</br>
   * def baseURI = 'https://petstore.swagger.io/v2'</br>
   * def helper = Java.type('helpers.Helper')</br>
</br>


  ## Task1</br>
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
    </br>
![task1](https://user-images.githubusercontent.com/88919177/146497713-38d7348b-8698-4256-ad2e-2282c7588cef.gif)
 </br>
 
 ## Task2</br>
  **Scenario: generate emails**</br>
      * print 'email:' , helper.emailGenerator() </br>
      
![task2](https://user-images.githubusercontent.com/88919177/146497793-7f376da9-b28b-4c7a-bc98-dc47dcd03134.gif)
 </br>
 
 
  ## Task3</br>
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
      </br>
      ![task3](https://user-images.githubusercontent.com/88919177/146498079-aef6bb1e-fc14-4a7d-b9e4-1465c87fab62.gif)
 </br>
 
  ## Task4</br>
  **Scenario: modify and post user json file**</br>
      *And* def user = read('classpath:data/user.json')</br>
      *Given* url baseURI</br>
      *And* header Content-Type = 'application/json'</br>
      *And* path 'user'</br>
      *And* set user.id = helper.idGenerator()</br>
      *And* set user.username = 'Mustafa'</br>
      *And* set user.lastname = 'Gunaydin'</br>
      *And* set user.firstname = helper.firstnameGenerator()</br>
      *And* set user.email = helper.emailGenerator()</br>
      *And* set user.password = helper.passwordGenerator()</br>
      *And* set user.phone = helper.phoneGenerator()</br>
      *And* set user.userStatus = helper.statusGenerator()</br>
      *And* request user</br>
      *When* method POST</br>
      *Then* status 200</br>
      * print user</br>
      * print response</br>
      </br>
 ![4](https://user-images.githubusercontent.com/88919177/146499245-70648459-5725-45db-b94e-b01c443edefd.gif)
      </br>
