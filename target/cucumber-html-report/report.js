$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/SearchAndBrowse.feature");
formatter.feature({
  "name": "Search and Browse",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@search"
    }
  ]
});
formatter.scenario({
  "name": "Search and navigate to PDP page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@search"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on traceparts homepage",
  "keyword": "Given "
});
formatter.match({
  "location": "com.rscomponent.stepdef.HomePageSteps.theUserIsOnTracepartsHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters for search word \"Photoelectric Sensor\" and clicks the search icon",
  "keyword": "When "
});
formatter.match({
  "location": "com.rscomponent.stepdef.HomePageSteps.userEntersForSearchWordAndClicksTheSearchIcon(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on the first product in the search result",
  "keyword": "And "
});
formatter.match({
  "location": "com.rscomponent.stepdef.PlpPageSteps.userClicksOnTheFirstProductInTheSearchResult()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be in PDP page",
  "keyword": "And "
});
formatter.match({
  "location": "com.rscomponent.stepdef.PdpPageSteps.userShouldBeInPDPPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the product title should contain \"LD46\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.rscomponent.stepdef.PdpPageSteps.theProductTitleShouldContain(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the product decription should contain \"LD46-UL-715\"",
  "keyword": "Then "
});
formatter.match({
  "location": "com.rscomponent.stepdef.PdpPageSteps.theProductDecriptionShouldContain(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user right click on the 3D product image, hovers on \"Views\" option and choose \"Left\" side image",
  "keyword": "And "
});
formatter.match({
  "location": "com.rscomponent.stepdef.PdpPageSteps.userRightClickOnTheDProductImageHoversOnOptionAndChooseSideImage(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the \"Left\" view of the image should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.rscomponent.stepdef.PdpPageSteps.theViewOfTheImageShouldBeDisplayed(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});