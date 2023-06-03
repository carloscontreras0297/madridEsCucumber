@regression
Feature: Home Page Test

  Background:
    Given Navigate to MadridES Page

  Scenario: MadridES Verify Twitter Iframe Title Test Case
    Given A loaded MadridES Webpage on the browser
    When Click Accept Cookies
    Then Verify Twitter IFrame Title