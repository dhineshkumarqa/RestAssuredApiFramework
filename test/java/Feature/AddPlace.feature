Feature: Adding place in API

@Addplace
Scenario Outline: verify if place is added using addPlace Api
 Given Add place Api with <name> <language> <Address> <website>
 When user calls the 'Addplace' api using 'Post' method
 Then verify the status code
 And 'status' verify the value  is 'OK'
 And verify the place_id created map to <name> using 'getplace'

 
Examples:
  | name     | language | Address        | website                                      |
  | 'Dhinesh'| 'Tamil'  | 'Amman Nagar'  | 'https://www.google.com/search?q=youtube'   |
 # | 'kumar'  | 'English'| 'Murugan Nagar'| 'https://www.google.com?search?q=youtube'   |

 @deleteplace
 Scenario: veirfy the delete place api working fine or not
 
 Given delete playload
 When user calls the 'deleteplace' api using 'Post' method
 Then verify the status code
 And 'status' verify the value  is 'OK'