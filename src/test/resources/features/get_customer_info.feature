Feature: Get and save customer information via Service A

  Scenario: Successfully get and save customer information via Service A
    Given this is a demo to get customer information
    When the response is received with status is TRUE
    Then the demo gets customer info and saves the response customer information from service A to the database