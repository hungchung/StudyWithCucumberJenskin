@landingpage
Feature: Check around the landing page
  Description: 
  we need to verify all of the main function are correct on the site or not.

  Background: 
    Given as customer who want to pick up a dish so access to the website via URL "http://cuchine:web01@cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com"

  Scenario Outline: Access to landing page and input the zipcode in services zone or neighborhood
    When I input Zipcode as "<Zipcode>"
    And I submit the Zip code by clicking on [See What Cooking] button
    Then I will check that the Zip Code zone being displayed in the first time, display Menu page will be shown "<DailyPage1>"

    Examples: 
      | Zipcode | DailyPage1                                                                |
      | 94122   | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/daily-menu |

  Scenario Outline: Access to landing page and input Zip code which is Out of service
    When I input Zipcode as "<Zipcode1>"
    And I submit the Zip code by clicking on [See What Cooking] button
    And I input "<Email>" into email field
    And I click [Keep Me in the Loop] button
    Then I can redirect to register page "<Postlaunch>"

    Examples: 
      | Zipcode1 | Email                | Postlaunch                                                                                   |
      | 19873    | qctest.247@gmail.com | http://cuchine.us12.list-manage.com/subscribe/post?u=201c1baba5eda6f3853ad2537&id=6e51a37b66 |

  Scenario Outline: Access to landing page and input Zip code  with wrong format
    When I input Zipcode as "<Zipcode2>"
    And I submit the Zip code by clicking on [See What Cooking] button
    Then System displays error message "<ErrorMs>"

    Examples: 
      | Zipcode2 | ErrorMs                       |
      | 789      | Please enter a valid zip code |
      |          | Please enter a valid zip code |
      | string   | Please enter a valid zip code |

  Scenario Outline: Access to landing page and input Zip code with pickup only
    When I input Zipcode as "<Zipcode3>"
    And I submit the Zip code by clicking on [See What Cooking] button
    Then I can refirect to Daily menu page "<DailyPage3>" with pickup only

    Examples: 
      | Zipcode3 | DailyPage3                                                                |
      | 94116    | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/daily-menu |
      

  Scenario Outline: Check navigation of Logo
    When I click on Logo
    Then I will be visited to landing page "<Landing>"

    Examples: 
      | Landing                                                         |
      | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/ |

  Scenario Outline: Check navigation of Our Philosophy
    When I click on Our Philosophy
    Then I will be visited to Our Philosophy page "<OurPhilosophy>"

    Examples: 
      | OurPhilosophy                                                                 |
      | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/our-philosophy |

  Scenario Outline: Check navigation of How It Work
    When I click on How It Work
    Then I will be visited to How It Work page "<HowItWork>"

    Examples: 
      | HowItWork                                                                   |
      | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/how-it-works |

  Scenario Outline: Check navigation of Cook With Us
    When I click on Cook With Us
    Then I will be visited to Cook With Us page "<CookWithUs>"

    Examples: 
      | CookWithUs                                                                  |
      | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/cook-with-us |
