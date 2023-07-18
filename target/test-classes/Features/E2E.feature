Feature: E2E Testing Of OrangeHRM PIM Function

  Scenario Outline: Validate PIM function
    Given I want to Navigate to OrangeHrm
    And Validate with valid Username "<username>" and Password "<password>"
    When Sucessfully login to Homepage
    And Click on PIM function
    And Select Employee information with Valid  id "<Id>"
    Then Successfully see the records of input Employee

    Examples: 
      | username | password | Id   |
      | Admin    | admin123 | 1021 |
