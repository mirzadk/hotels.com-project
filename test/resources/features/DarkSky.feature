@web @regression @login
Feature: DarkSky home

  Background:

   @homework-1
       Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
           Given I am on Darksky Home Page
           Then I verify current temp is not greater or less then temps from daily timeline

       @homework-2
       Scenario: Verify individual day temp timeline
           Given I am on Darksky Home Page
           When I expand todays timeline
           Then I verify lowest and highest temp is displayed correctly

       @homework-3
       Scenario: Verify timline is displayed in correct format
           Given I am on Darksky Home Page
           Then I verify timeline is displayed with two hours incremented

       @signup-3
       Scenario: Verify invalid sign up error message
         Given I am on the Darksky register page
         When I click on Register button
         Then I verify error message "Please fill out this field."

















