Feature: To test login feautre for YNHH

	Scenario: Login validation with varity of test data
	
	Given Browser launched and navigated to url
	When User enter username as "username" and password as "password"
	And Click login button
	Then for testcase "testcasename" validate urls