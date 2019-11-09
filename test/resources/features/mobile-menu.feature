@mobile @mobile-regression @menu
Feature: Menu feature

  @menu-1
  Scenario: Verify sidebar validation
    When I tap on skip button
    And I tap on menu button
    Then I verify sidebar menu is displayed

  @menu-2
     Scenario: Verify invalid signup
        Given I am on signup screen
        And I tap on create button from signup screen
        Then I verify invalid password text
        And I verify invalid username text


   @menu-3
    Scenario: Verify invalid signup
      Given I am on signup screen
      And I tap on create button from signup screen
      Then I verify invalid password text
      And I verify invalid username text
