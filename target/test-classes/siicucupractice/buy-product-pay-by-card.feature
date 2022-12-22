# new feature
# Tags: optional

Feature: Sii practice project

  @purchaseproduct
  Scenario: A purchase product
    Given click on sign in button
    Given login into website
    When click on menu woman
    Then check if product id is in stock:
    |1|
    |2|
    |3|
    |4|
    |5|
    |6|
    |75|
#    Then put a product with id "7" into the cart
#    And check if cart has a "Product"
#    When click cart button to proceed purchase
#    Then check if product is on list "Printed Chiffon Dress"
#    And click "button" on Order Page "proceed to checkout button in Summary"
#    Then check delivery address "Pomorska 94B"
#    Then check bill address "Pomorska 94B"
#    And click "button" on Order Page "proceed to checkout button in Address"
#    And click "checkout" on Order Page "agree with terms of service"
#    And click "button" on Order Page "proceed to checkout button in Shipping"
#    And choose payment manner "Pay by bank wire"
#    Then check if payment mode "BANK-WIRE PAYMENT." is correct
#    And click "button" on Order Page "confirm button"
