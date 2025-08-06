

Feature: Registration Functionality
  I want to use this template for my feature file

 
  Scenario: Register with Mandatory filed
   Given  user navigates to Registration menu
   When User enter the values into the below field
      | firstname | Nandha                          |
      | lastname  | Kumar                           |
      | email     | nandhakumarj.038@gmail.com       |
      | telephone | 1234567890                      |
      | password  | Pass@123                        |
      | confirmpassword  | Pass@123                        |
   And user click on privacy policy
   And user clicks on continue
   Then User registration should be complete
   
     Scenario: Register with existing email  filed
   Given  user navigates to Registration menu
   When User enter the values into the below field
      | firstname | Nandha                          |
      | lastname  | Kumar                           |
      | email     | nandhakumarj.036@gmail.com       |
      | telephone | 1234567890                      |
      | password  | Pass@123                        |
      | confirmpassword  | Pass@123                        |
   And user click on privacy policy
   And user clicks on continue
   Then validate warning E-Mail Address is already registered!
 