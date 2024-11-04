Feature: Search & Place the order for Products

@OffersPage
Scenario Outline: Search Experience for product search in both Home & Offers page

Given User is on GreenKart landing page
When User searched with shortname <Name> and extracted actual name of the product
Then User searched for <Name> shortname in offers page
And validate product name in Offers page matches with Landing page

Examples:
|	Name	|
|	tom		|
|	beet	|