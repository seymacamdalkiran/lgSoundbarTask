Feature: Sort the product
  Background:
    Given Go to the url
  Scenario: Sort the lg soundbar product
    Given Write "LG soundbar" in the search button and click
    When Select lg brand xheckbox
    And Read product price and name
    And Print product price and name in desc order of price via code.