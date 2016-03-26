@signup
Feature: Customer sign-up an account
  Description: New customer accessse to the site, and wants to sign-up an account in order to be an member.
  we need to verify all of the main function are correct on the site or not.

  Background: 
    Given I am a new customer who wants to sign-up as a member of site and I access the website via the URL "http://cuchine:web01@cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com"

  Scenario: Close the sign-up popup
    When I click on the Sign Up in header
    And Click on X label
    Then I can see the pop-up will be closed properly

  Scenario Outline: User request sign-up with Facebook to the website
    When I click on the Sign Up in header
    And Click on Sign Up With Facebook button
    And Log in with facebook account "<usrFB>", "<pwFB>"
    And fill user-info into the form as "<FirstName>", "<LastName>", "<Phonenumber>", "<Zipcode>", "<Password>", "<ConfirmPassword>"  into the form as
    And I press Sign Up button
    Then I will recieve welcome email and be redirected to Daily Menu page with input zip code. "<URL>"

    Examples: 
      | usrFB                  | pwFB        | FirstName | LastName | Phonenumber | Zipcode | Password   | ConfirmPassword | URL | InfoMes1 | InfoMes2                                            |
      | qctester.247@gmail.com | qctester247 | FN123     | LB123    | 1234567     | 94122   | 12345678aA | 12345678aA      |     | Oops!    | There is an account already with that email address |
      | cuch.test1@gmail.com   | 123456?a    | FN        | LN       | 12345678    | 10007   | 123456     | 123456          |     |          |                                                     |

  Scenario Outline: New user registers with email and check form validattion
    When I click on the Sign Up in header
    And fill "<Email>" and click on Sign Up with your email
    And fill user-info into the form on the Sign up pop-up as  "<FirstName>", "<LastName>", "<Phonenumber>", "<Zipcode>", "<Password>", "<ConfirmPassword>"  into the form as
    And I press Sign Up button
    Then I will recieve welcome email and be redirected to Daily Menu page

    Examples: 
      | Email                  | FirstName | LastName | Phonenumber | Zipcode | Password | ConfirmPassword |
      | qctester.247@gmail.com | FN        | LN       | 123456789   | 94122   | 123456   | 123456          |

  Scenario Outline: New user registers successfully with prefilled email and check form validattion
    When I click on the Sign Up in header
    And Fill a valid email into text-box
    And Click on Sign Up with your email
    And fill user-info into the form on the Sign up pop-up as "<FirstName>", "<LastName>", "<Phonenumber>", "<Zipcode>", "<Password>", "<ConfirmPassword>"  into the form as
    And check on Keep sign in checkbox
    And I press Sign Up button
    And I will recieve welcome email and be redirected to Daily Menu page with input zip code.
    And I close the browser and open again to check the Sign-in status
    Then Daily menu page will display

    Examples: 
      | FirstName | LastName | Phonenumber | Zipcode       | Password    | ConfirmPassword |
      | 'FN123'   | 'LB123'  |             |               |             |                 |
      | 'FN'      | 'LN'     | 123456789   | 10007         | 123456      | 123456          |
      | 'FN'      | 'LN'     |             | 10007         | 123456      | 123456          |
      | 'FN'      | 'LN'     | 'string'    | 10007         | 123456      | 123456          |
      | 'FN'      | 'LN'     | 123456789   | 10007         | 'ab@123456' | 12345601        |
      | 'FN'      | 'LN'     | 123456789   | 'Wrongformat' | 123456      | 123456          |

  Scenario: New user registers with duplicated email and check form validattion
    When I click on the Sign Up in header
    And Click on Sign Up with your email
    And Input dupplicated email
    And Press Sign Up button
    Then I will see a warning message
