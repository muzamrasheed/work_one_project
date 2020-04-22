Feature: Group Rule Definitions


  Scenario: 3369_Retrieve all rules APIs

    Given version of API & token were added
    When send a request to retrieve response of rules
    Then validate the result of each request