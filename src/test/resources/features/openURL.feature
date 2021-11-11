Feature: Opening the Browser

  Scenario Outline: Verify the URL
    Given Open the Webdriver
    When Enter the '<Specified>' URL
    Then page is Displayed
    Then Wait for page to load
    Then Enter the '<search>' in the value
    And click enter
    When Page is loaded
    Then Scroll Down
    And click on SortBy button
    Then Select '<one>'
    And Press enter

    Examples:
    |Specified|search|one|
    |https://www.kohls.com/|Tuxedo|Price High-Low|


