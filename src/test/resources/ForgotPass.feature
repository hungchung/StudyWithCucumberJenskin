@forgotpass
Feature: Customer forgot their account.
  Description: Customers come back as a member and they want to sign in but they forgot their password and want to get the password 
  we need to verify all of the main function are correct on the site or not.

  Background: 
    Given I am a customer who wants to get back the password from the website via the URL "http://cuchine:web01@cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com"

  Scenario Outline: Customer forgot password and get it back from the sign-in pop-up
    When Customer click on the section Sign in at the header
    And click on Forgot Password section
    And fills my "<Email>" into the field
    And click on Reset Password button
    And open the mailbox to check the new password "<EmailTitle>" "<Gpw>" "<Email>" "<URL>"
    Then Customer receive a email with new password "<EmailTitle>"

    Examples: 
      | Email                | Password | Gpw        | EmailTitle                                                        | URL              |
      | khoaforfun@gmail.com | 123456?b | 123546Khoa | Replacement login information for khoaforfun@gmail.com at Cuchine | http://gmail.com |

  Scenario Outline: Customer forgets his password and input wrong or Not-exist email
    When Customer click on the section Sign in at the header
    And click on Forgot Password section
    And fills my "<wrongEmail>" into the field
    And click on Reset Password button
    Then Customer recieve an pop-up with error message "<ErrMes>"

    Examples: 
      | wrongEmail    | ErrMes                     |
      | est1@gmail    | Please enter a valid email |
      | est2gmail.com | Please enter a valid email |

  Scenario Outline: Customer change to new password
    When Customer click on the section Sign in at the header
    And Sign-in by account "<Email>" "<Password>"
    And click on My Account
    And click on field of Change Password
    And input old password "<Password>"
    And input New password and confirm password "<NewPass>" "<ConfirmPW>"
    And submit the change
    Then Customer can change password and receive a thank you pop-up "<CompleteMessage>"

    Examples: 
      | Email            | Password   | NewPass    | ConfirmPW  | CompleteMessage                             |
      | nsqc04@gmail.com | 12345678aA | 12354678bB | 12354678bB | Your password has been changed successfully |
