@web @regression @payments
Feature: Payment Feature

  Background:
    Given I am on payment screen

  @payments-1
  Scenario: Verify invalid payment
    When I enter invalid details on payment form
    And I click on submit
    Then I should see invalid payment error message
