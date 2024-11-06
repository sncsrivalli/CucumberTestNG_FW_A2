Feature: User Module
	Verify if admin is able to create user and delete it
  
  Scenario: Create and Delete User
    Given I navigate to skillrary app
    And login to Skillrary as admin
    When I enter user page 
    And add an user
    Then user should be created
    When I delete user
    Then user should be removed from user list
    And logout of skillrary