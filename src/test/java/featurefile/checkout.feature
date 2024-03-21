Feature:  place order
@checkoutpage
Scenario: search product in shortname place the order compare name with checkout page

Given User is on greencart landing page
When  User searched with shortname <Name> and extracted actual name of product
And add "3" items of selectes product to cart
Then user proceed to checkout and validate the <Name> item in checkout page
And verify user has ablity to enter promocode and place the order
Examples:
	| Name |
	| Tom |
	| bea|
	| car |
					
 #cucumber.ansi-colors.disabled=  # true or false. default: false
#cucumber.execution.dry-run=     # true or false. default: false
#cucumber.execution.limit=       # number of scenarios to execute (CLI only).
#cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
#cucumber.execution.wip=         # true or false. default: false.
#cucumber.features=              # comma separated paths to feature files. example: path/to/example.feature, path/to/other.feature
#cucumber.filter.name=           # regex. example: .*Hello.*
#cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
#cucumber.glue=                  # comma separated package names. example: com.example.glue
#cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
#cucumber.object-factory=        # object factory class name. example: com.example.MyObjectFactory
#cucumber.snippet-type=          # underscore or camelcase. default: underscore
 