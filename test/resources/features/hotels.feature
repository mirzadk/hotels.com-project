@web @regression @login
Feature: Hotels.com home

  Background:

 @hotels-1
   Scenario Outline: Verify room count dropdown
     Given I am on hotels.com home page
     Then I select <select_rooms> from room dropdown
     Then I verify <number_of_room_dropdown> is displayed

     Examples:
       | select_rooms | number_of_room_dropdown |
       | 1            | 1                       |
       | 2            | 2                       |
       | 3            | 3                       |
       | 4            | 4                       |
       | 5            | 5                       |
       | 6            | 6                       |
       | 7            | 7                       |
       | 8            | 8                       |
       | 9            | 0                       |

   @hotels-2
   Scenario Outline: Verify user can only view the result by selected property class
     Given I am on default locations search result screen
     When I select property class <stars>
     Then I verify system displays only <stars> hotels on search result

     Examples:
       | stars   |
       | 5 stars |
       | 4 stars |
       | 3 stars |

   @hotels-3
   Scenario: List of all of hotel within 10 miles radius of airport or downtown
     Given I am on default locations search result screen
     Then I verify system displays all hotels within 10 miles radius of airport

   @hotels-4
   Scenario: Verify todays deal price value
     Given I am on default locations search result screen
     Then I verify todays deal is less than $200