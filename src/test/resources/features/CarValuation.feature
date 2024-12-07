Feature: Car Valuation and Verification

  @CarValuationTest
  Scenario Outline: Verify car valuation details
    Given the car input file "<InputFile>" is loaded
    When I extract vehicle registration numbers from the input file
    And I perform car valuation for each registration number
    Then I compare the actual "<ActualOutputFile>" with the expected file "<ExpectedOutputFile>"

    Examples:
      | InputFile     | ActualOutputFile | ExpectedOutputFile     |
      | car_input.txt | car_output.txt   | car_expectedoutput.txt |