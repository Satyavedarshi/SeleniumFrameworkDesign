
@tag
Feature: Purchase the Order from ECommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on the Ecommerce Page

  @tag1
  Scenario Outline: Positive test of Submitting the Order
    Given Logged in with username <email> and password <password>
    When I add <productName> to cart
    And checkout <productName> and submit the order
    Then "Thankyou for the order." message is displayed on ConfirmationPage

    Examples: 
      | email  | password | productName  |
      | testpractice1@gmail.com |     Nuzvid@123 | ZARA COAT 3 |
