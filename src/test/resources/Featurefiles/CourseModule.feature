Feature: Course Module
  Verify if admin is able to create course and delete it

  Scenario: Create and Delete Course
    Given I navigate to skillrary app
    And login to Skillrary as admin
    When I enter course page
    And add course
      | RPA                                            |
      | testing                                        |
      |                                          20000 |
      | C:\\Users\\TRACK QJSPIDERS\\Downloads\\RPA.jpg |
      | RPA course                                     |
    Then course should be created
    When I delete course
    Then course should be removed from course list
    And logout of skillrary
