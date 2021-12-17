Feature: case study 2

  Background:
    * def baseURI = 'https://petstore.swagger.io/v2'
    * def helper = Java.type('helpers.Helper')

  @task1
  Scenario Outline: verify given status
    Given url 'https://petstore.swagger.io/v2/pet/findByStatus?status=<status>'
    When method GET
    Then status 200
    And match responseHeaders['Content-Type'][0] == 'application/json'
    And match $..id each contains '#present'
    And match $..id each contains '#notnull'
    And match $..status contains '<status>'
    And print response

    Examples:
    |status   |
    |available|
    |pending  |

  @task2
  Scenario: generate emails
    * print 'email:' , helper.emailGenerator()

  @task3
  Scenario: set and post user json file
    And def user = read('classpath:data/user.json')
    Given url baseURI
    And header Content-Type = 'application/json'
    And path 'user'
    And def id = helper.idGenerator()
    And set user.id = id
    And set user.username = helper.usernameGenerator()
    And set user.firstname = helper.firstnameGenerator()
    And set user.lastname = helper.lastnameGenerator()
    And set user.email = helper.emailGenerator()
    And set user.password = helper.passwordGenerator()
    And set user.phone = helper.phoneGenerator()
    And set user.userStatus = helper.statusGenerator()
    And request user
    When method POST
    Then status 200
    And match user.id == id
    * print user
    * print response

  @task4
  Scenario: test4
    And def user = read('classpath:data/user.json')
    Given url baseURI
    And header Content-Type = 'application/json'
    And path 'user'
    And set user.id = helper.idGenerator()
    And set user.username = 'Mustafa'
    And set user.lastname = 'Gunaydin'
    And set user.firstname = helper.firstnameGenerator()
    And set user.email = helper.emailGenerator()
    And set user.password = helper.passwordGenerator()
    And set user.phone = helper.phoneGenerator()
    And set user.userStatus = helper.statusGenerator()
    And request user
    When method POST
    Then status 200
    * print user
    * print response

