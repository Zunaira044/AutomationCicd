
@tag
Feature: Purchase the order from the E-Commerce Website 
  I want to use this template for my feature file
  
  Background: 
  Given I landed on ECommerce page

  @tag1
  Scenario: Positive Test for Sumitting the order
    Given login with username <name> and password <password>
    When I add Product <productName> to cart
    And checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page 


    Examples: 
      | name                     | password | productName  |
      | Bilal376@gmail.com       |Bilal@786 |ADIDAS ORIGINAL|
