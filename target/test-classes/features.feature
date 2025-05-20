Feature: User Signup functionality

	@G1
  Scenario: Generate the Sompo Fire Cover note.
    Given the user is on the login page "<Username>" "<Password>"
    When the user is on the dashboard page 
    When the user is on quote preface page "<Product Name>" "<Client Name>" "Inception Date>"
    When the user is on premises details page "<Occupied As>" "<Trade Code>" "<Occ Desc>" "<Const Class>" "<Rating Type>" "<Interest Code>" "<Sum Insured>"
    When the user is on the peril clause page
    Then the user is on the premium summary page
    
  Examples:
  	| Username	  | Password		 | Product Name | Client Name | Inception Date | Occupied As | Trade Code | Occ Desc | Const Class | Rating Type | Interest Code | Sum Insured |
    | 10002002    | Kgisl@123456 | SOMPO FIRE   | IND-TEST-01 | 26-03-2002     | 1001				| 0002			 | Occ			|	C1A					| TARIFF			|	001						|	100000			|