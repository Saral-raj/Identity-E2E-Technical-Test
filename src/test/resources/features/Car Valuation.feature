Feature: Car Valuation

  Background:
    Given I am on the car valuation website
    And I start visa check

  Scenario Outline: check visa Australia & Columbian
    When I select a nationality of "<nationality>"
    And I select reason "<reason>"
    Then I will be informed "<resultText>"

    Examples:
      | nationality | reason       | resultText                                 |
      | Australia   | Tourism      | You will not need a visa to come to the UK |
      | Colombia    | Join partner | You may need a visa                        |

