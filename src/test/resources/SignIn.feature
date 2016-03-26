@signin
Feature: Customer signs-in by their account.
  Description: Customers come back as a member and they want to sign in and see the dishes which available in our website.
  we need to verify all of the main function are correct on the site or not.

  Background: 
    Given I am a customer who wants to sign-in and access the website via the URL "http://cuchine:web01@cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com"

  Scenario: Close the sign-in popup
    When I click on the Sign in section at the header
    And Click on X label
    Then I can see the pop-up will be closed properly

  Scenario Outline: Customer signs in successfully with email and check validation
    When I click on the Sign in section at the header
    And fill Email and Password into the form with "<Email>" , "<Password>"
    And click on Sign In button
    Then I will be redirected to Daily Menu page with "<URL>"

    Examples: 
      | Email            | Password   | URL                                                                       | ExpectedDisplay1      |
      | nsqc04@gmail.com | 12345678bB | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/daily-menu | Welcome Back Tom... ! |

  Scenario Outline: Customer signs in unsuccessfully with email and check validation
    When I click on the Sign in section at the header
    And fill Email and Password into the form with "<Email>" , "<Password>"
    And click on Sign In button
    Then I will receice a validation message from system "<ExpectedDisplay1>"

    Examples: 
      | Email                | Password | ExpectedDisplay1              |
      |                      |          | Please enter a valid email    |
      | cuch.test2@gmail.com |          | Please enter a valid Password |
      | cuch.test2@          | 123456?a | Please enter a valid email    |

  Scenario Outline: Customer signs in successfully with email and check validation with keep sign in
    When I click on the Sign in section at the header
    And fill Email and Password into the form with "<Email>" , "<Password>"
    And check on the Keep me Sign in checkbox
    And click on Sign In button
    Then I will be redirected to Daily Menu page with "<URL1>"

    Examples: 
      | Email            | Password   | URL1                                                                      |
      | nsqc04@gmail.com | 12345678bB | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/daily-menu |

  Scenario Outline: Customer signs in successfully with facebook and check validation
    When I click on the Sign in section at the header
    And click on Sign in with Facebook
    And sign in with "<FBEmail1>" , "<FBPassword1>"
    Then I will be redirected to Daily Menu page with account info "<URL2>"

    Examples: 
      | FBEmail1         | FBPassword1 | URL2                                                                      |
      | nsqc01@gmail.com | sutrix01    | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/daily-menu |

  Scenario Outline: Customer signs in unsuccessfully with facebook and check validation
    When I click on the Sign in section at the header
    And click on Sign in with Facebook
    And sign in with "<FBEmail2>" , "<FBPassword2>"
    Then I will be redirected to Daily Menu page with validation message "<ExpectedDisplay>"

    Examples: 
      | FBEmail2         | FBPassword2 | ExpectedDisplay                                                     |
      | nsqc02@gmail.com | sutrix02    | Sorry, we can not locate your account. Please check again and retry |
