Feature: Category Module
  Verify if admin is able to create category and delete it

  Scenario Outline: Create and Delete Category
    Given I navigate to skillrary app
    And login to Skillrary as admin
    When I enter category page
    And add a <category>
    Then category should be created
    When I delete category
    Then category should be removed from category list
    And logout of skillrary

    Examples: 
      | RPA        |
      | Automation |
