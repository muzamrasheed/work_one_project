Feature: Countries API

  @TC001
  Scenario: GET a list of countries
    Given Endpoint /counties is available
    When set request HEADERS
    Then send GET HTTP request and validate response
  @TC002
  Scenario Outline: create a <country> .
      Given set post a country endpoint
      When set post request with HEADERS, Token, Payload
      Then Send Post Request and validate response
    Examples:
      | country    |
      | xxstringxx |

  @TC003
  Scenario: 3339_Retrieve a list of countries
    Given set GET a new country api endpoints
    When set request HEADERS and token
    Then send GET HTTP request and validate response for a new country

  @TC004
  Scenario: Update a name of a country was created
    Given set PUT a country endpoint
    When set put request with HEADERS, Token, updated Payload for PUT
    Then Send Put Request and validate response after Put.

  @TC005
  Scenario: GET a Updated country after put
    Given set GET updated country api endpoints
    When set request HEADERS and token for updated country
    Then send GET HTTP request and validate response for updated country

  @TC006
  Scenario: Delete the country that was created
    Given set Delete country api endpoints
    When set request HEADERS and token for delete
    Then send DELETE HTTP request and validate response

