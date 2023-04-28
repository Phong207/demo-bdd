Feature: Demo feature for getting and identifying customer network based on phone number prefix

  Scenario Outline: Successfully get customer information with phone number prefix belonging to Viettel network
    Given a list of Viettel area codes:
      | Area code |
      | 086       |
      | 096       |
      | 097       |
      | 098       |
      | 032       |
      | 033       |
      | 034       |
      | 035       |
      | 036       |
      | 037       |
      | 038       |
      | 039       |
    When The response phone number is "<phoneNumber>" with the first 3 numbers in the area code of Viettel
    Then the demo process identifies the customer's network as Viettel
    Examples:
      | phoneNumber |
      | 086123456 |
      | 097654321 |
      | 034111222 |
      | 038444555 |