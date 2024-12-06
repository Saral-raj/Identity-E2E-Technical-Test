@UI
Feature: Visa checks

  Background:
    Given I am on the Check UK visa website
    And I start visa check

  Scenario Outline: check visa Australia & Columbian
    When I select a nationality of "<nationality>"
    And I select reason "<reason>"
    Then I will be informed "<resultText>"

    Examples:
      | nationality | reason       | resultText                                 |
      | Australia   | Tourism      | You will not need a visa to come to the UK |
      | Colombia    | Join partner | You may need a visa                        |

  Scenario: A Chilean coming to the UK for Work and plans on staying for longer than 6 months.
    When I select a nationality of 'Chile'
    And I select reason 'Work, academic'
    And I state I am intending to stay for 'less' than 6 months
    Then I will be informed 'You do not need a visa for some business and academic activities, but you must get a visa if you plan to work in the UK'

