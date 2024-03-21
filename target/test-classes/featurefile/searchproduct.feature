Feature: search and place the order for product
@offerpage
Scenario Outline: Search experience for the product search in home page and offer page

Given User is on greencart landing page
When User searched with shortname <Name> and extracted actual name of product
Then User searched for same shortname <Name> in offerpage to check if product exist
And Validate productname in offer page matches with landing page 

Examples:
			| Name |
			| Tom  |
			|Beet  |