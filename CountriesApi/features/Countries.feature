Feature: Countries


  Background:
            Given endpoint/countries is available, and generate the access token.

  @Smoke
    Scenario: 2631_Retrieve a list of countries
      And version of API and token were added
      When send a request to retrieve a lis of countries
      Then validate the result of sent request

  @Reg
    Scenario: 263000_Create a country
      And Version of API, token and payload for a new country were added
      When send a request to create a new country
      Then match the result of a new country with "postPayload.json"


  @Reg
    Scenario: 2630_Retrieve a country
      And token and version of API were added
      When send a request to retrieve newly created country
      Then validate the result of newly created country

  @Reg
    Scenario Outline: 2630_Update a country
      And Version of API, token and payload to update name and abbriviation of newly created country were added
      When send the request to update the country
      Then collect the response and match with "PutPayload.json"
      Examples:
        |abbreviation |name         |regionLabel|zipLabel|callingCode|sortOrder|hasRegions|showInAddressList|showInCallingCodeList|
        |YY           | YYstringYY  |string     |string  |0          |0        |true      |true             |true                 |

  @Reg
  Scenario: 2630_Delete a country
      And Api version and token were added
      When send a request to delete record of newly created country
      Then validate the response of deleted record