Feature: case study 1

  Background:
    Given homepage is open
    And I close the pop up

  @task1
  Scenario: verify search results
    And I verify the page title
    When I search for "drone"
    Then search result "drone" should be seen

  @task2
  Scenario: verify successful login
    When I open the "Account" dropdown menu
    And I choose Sign In
    And I fill the login page
    Then should be logged in

  @task3
  Scenario: verify saved item
    And I choose menu
    And I open wireless headphones
    And I filter philips brand
    And I open second product
    And I save the product
    And I open saved items
    Then title of the saved product should be on the list


