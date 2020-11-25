#This feature file contains test scenario to verify API of TradeMe sandbox
#Author: Suranjit Saha
Feature: To verify API Carbon Credits in TradeMe Sandbox with Rest Assured

Scenario: To verify API Carbon Credit and confirm that the name of the API is correctly return in the response
     Given To initiate Rest service to get Carbon Credits API response
     When Response status code should be "200"
     Then In the response the attribute "Name" should return value as "Carbon credits"

Scenario: To verify API Carbon Credit and confirm that the CanRelist attribute returns value "true" in the response
     Given To initiate Rest service to get Carbon Credits API response
     When Response status code should be "200"
     Then In the response the attribute "CanRelist" returns value as true

Scenario: To verify API Carbon Credit and confirm that The Promotions element with Name = "Gallery" has a Description that contains the text "2x larger image"
     Given To initiate Rest service to get Carbon Credits API response
     When Response status code should be "200"
     And In the response the "Promotions" element has a data with "Name" = "Gallery"
     Then In the response the "Promotions" element with "Name" = "Gallery" has "Description" that contains the text "2x larger image"