@web @regression @messenger
Feature: Messenger Feature

  Background:
    Given I am on messenger page

  @messenger-1
  Scenario: Verify invalid login from messenger page
    When I enter  mohammad@technosoft.io into username field on messenger page
    And I enter  test1234 into password field on messenger page
    And I click on signup button on messenger page
    Then I verify invalid login verify message on signup page