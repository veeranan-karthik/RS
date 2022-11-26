@search
Feature: Search and Browse

  Scenario:Search and navigate to PDP page
    Given the user is on traceparts homepage
    When user enters for search word "Photoelectric Sensor" and clicks the search icon
    And user clicks on the first product in the search result
    And user should be in PDP page
    Then the product title should contain "LD46"
    Then the product decription should contain "LD46-UL-715"
    And user right click on the 3D product image, hovers on "Views" option and choose "left" side image
    Then the left view of the image should be displayed