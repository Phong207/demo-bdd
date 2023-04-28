Feature: Get and save customer information via Service A

  Scenario: Successfully get and save customer information via Service A
    Given I get customer information from Service A
    When the response is received with status is TRUE
    Then the customer information is saved in the database