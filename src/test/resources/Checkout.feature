@checkout
Feature: Customer accessed to Cuchine and pick out the dishes in daily-menu then he wants to checkout his picked dishes in the car
  Description: After sign-in Customer want to see the dishes and chefs in daily menu page
  we need to verify all of the main function are correct on the site or not

  Background: 
    Given Customer access to the checkout page from daily-menu and he wants to payment for the dishes on cart "http://cuchine:web01@cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com" "<data>"
      | TableID | Categories      | Dishname               | Thumbnail_image                            |
      | 1       | Tom Cruise      | Pizza                  | photo-1_3.jpg                              |
      | 2       | Magaret Goldlum | Garlic Rice            | garlic_rice.jpg                            |
      | 3       | Ken Kenny       | Mashed Potato          | mash_potatoes.jpg                          |
      | 4       | Ken Kenny       | Chili                  | chili.jpg                                  |
      | 5       | Victor Alan     | Beefsteak              | images_6_.jpg                              |
      | 6       | Wilson Wat      | clear rice noodle soup | hutieu1.jpg                                |
      | 7       | Ken Kenny       | sushi                  | images_1_.jpg                              |
      | 8       | Henry King      | Vietnamese Udon        | banh_canh_1.jpg                            |
      | 9       | Henry King      | style noodle           | mi_quang_1.jpg                             |
      | 10      | Magaret Goldlum | Eggplant Parmesan      | photo-1_3.jpg                              |
      | 12      |                 | Spinach salad          | strawberry-and-avocado-spinach-salad-4.jpg |
      | 13      | Victor Alan     | chinese braised pork   | thit_kho_1.jpg                             |
      | 14      | Laura Kerr      | Cheese wraps           | egg-cheese-burrito.jpg                     |
      | 15      | Henry King      | Pork bread             | images_5_.jpg                              |
      | 16      | Magaret Goldlum | Hamburger              | meal2.jpg                                  |
      | 17      | Magaret Goldlum | Beef and egg           | f04da2db11221473709001.jpg                 |
      | 19      | Wilson Wat      | Turkey burger          | lorraine_pita-turkey-burger_2.jpg          |
      | 20      |                 | Eggplant Parmesan 1    | pho.jpg                                    |
      | 21      | Victor Alan     | Sandwich               | download.jpg                               |
      | 22      | Ken Kenny       | Vegetable              | vegetable.jpg                              |
      | 23      | Victor Alan     | Caprese Pasta          | caprese-pasta-665_1.jpg                    |
      | 24      | Lorem Ispum     | Mesclun Salad          | mesclun-tomate-peches-4446.jpg             |
      | 25      | Tom Cruise      | Carrot-Cheddar         | 3596-1.jpg                                 |
      | 26      | Cletus Luu      | Food001                | fast-food_2.jpg                            |
      | 27      | Cletus Luu      | Food002                | food-wallpaper-5775-5940-hd-wallpapers.jpg |
      | 30      | Vinh Luu        | Foody05                | food_13.jpg                                |
      | 31      | Martin Yan      | BANH DA                | 110820104606-250-433.jpg                   |
      | 32      | Ken Kenny       | Salmon Fish            | salmon_fish.jpg                            |
      | 33      | Ken Kenny       | Beef noodle            | pho.jpg                                    |
      | 34      | Ken Kenny       | Food003                | download_1.jpg                             |
      | 35      | Marie S.        | Garlic Rice 2          | garlic_rice_1.jpg                          |
      | 36      | Henry King      | Chicken rice           | images_8_.jpg                              |
      | 37      | Henry King      | Beef noodle Dup        | pho_1.jpg                                  |
      | 38      | Wilson Wat      | Turkey burger Slider   | lorraine_pita-turkey-burger_2_1.jpg        |
      | 39      | Vinh Luu        | Foody04                | food-wide-wallpaper-334729.jpg             |
      | 40      | Ray William     | Soup                   | soup_3.jpg                                 |
      | 41      | Cletus Luu      | Banh GIo               | egg-cheese-burrito_1.jpg                   |
      | 42      | Cletus Luu      | test                   | images_4_.jpg                              |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode and check-out successfully
    When I access to Dailymenu page with "<zipcode>"
    And click Got it button 
    And sign in with an account "<Email>" "<Password>"
    And open detail a dish "<Dishname>"
    And select quantity of dish "<Quantity>"
    And select Pick Up Time "<PakUpTime>"
    And select Delivery Time "<DeliveryTime>"
    And select Packaging "<Package>"
    And add a note for the Chef
    And click on Checkout button
    And select Payment option and Delivery Address
    And click on Place Order button in checkout page "<URL1>"
    Then Checkout process is completed and redirected to Thankyou page "<URL2>"

    Examples: 
      | zipcode | Email            | Password   | Dishname | Quantity | GarRice | MasPo | DeliveryTime | PakUpTime | Package | URL1                                                                    | URL2 |
      | 94122   | nsqc04@gmail.com | 12345678bB | xDish1   | xQuanty2 |         |       | xDeliTime1   | xPikup1   | xPack2  | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/checkout |      |
      | 94122   | nsqc04@gmail.com | 12345678bB | xDish2   | xQuanty2 |         |       | xDeliTime3   | xPikup2   | xPikup2 | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/checkout |      |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode and edit info in checkout page
    When I access to Dailymenu page with "<zipcode>"
    And sign in with an account "<Email>" "<Password>"
    And open detail a dish "<Dishname>"
    And select quantity of dish "<Quantity>"
    And select quantity of Garlic Rice "<GarRice>"
    And select quantiy of Mashed Potato "<MasPo>"
    And select Pick Up Time "<PakUpTime>"
    And select Packaging "<Package>"
    And add a note for the Chef
    And click on Checkout button
    And edit quantity of Main Dishes
    And remove some dishes
    And click on Place Order button in checkout page
    Then Checkout process is completed, verify info and redirected to Thankyou page "<URL>"

    Examples: 
      | zipcode | Email              | Password   | Dishname | Quantity  | GarRice | MasPo     | PakUpTime | Package | URL |
      | 94122   | xukun310@gmail.com | O12345678a | xDish1   | xQuanty   | xRice0  |           | xPikup1   | xPack1  |     |
      | 94122   | xukun310@gmail.com | O12345678a | xDish2   | xQuanty2  | xRice1  | xPotato1  | xPikup2   | xPack2  |     |
      | 94122   | xukun310@gmail.com | O12345678a | xDish3   | xQuanty7  | xRice5  | xPotato2  |           | xPack1  |     |
      | 94117   | xukun310@gmail.com | O12345678a | xDish4   | xQuanty10 | xRice1  | xPotato1  | xPikup2   | xPack2  |     |
      | 94117   | xukun310@gmail.com | O12345678a | xDish5   | xQuanty7  | xRice5  | xPotato26 | xPikup3   | xPack1  |     |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode and check-out unsuccessfully without any dish
    When I access to Dailymenu page with "<zipcode>"
    And sign in with an account "<Email>" "<Password>"
    And open detail a dish "<Dishname>"
    And click on Checkout button
    And remove current dish
    And click on Place Order button in checkout page
    Then Checkout process is not completed with error pop-up "<ErrMes1>" "<ErrMes2>"

    Examples: 
      | zipcode | Email              | Password   | Dishname | ErrMes1 | ErrMes2        |
      | 94122   | xukun310@gmail.com | O12345678a | xDish1   | Oops!   | Order is wrong |
      | 94117   | xukun310@gmail.com | O12345678a | xDish5   | Oops!   | Order is wrong |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode and check-out unsuccessfully
    When I access to Dailymenu page with "<zipcode>"
    And sign in with an account "<Email>" "<Password>"
    And open detail a dish "<Dishname>"
    And select quantity of dish "<Quantity>"
    And select quantity of Garlic Rice "<GarRice>"
    And select quantiy of Mashed Potato "<MasPo>"
    And select Pick Up Time "<PakUpTime>"
    And select Packaging "<Package>"
    And add a note for the Chef
    And click on Checkout button
    And select Payment option and Delivery Address
    And click on Place Order button in checkout page "<URL1>"
    Then Checkout process is not completed with error pop-up "<ErrMes1>" "<ErrMes2>"

    Examples: 
      | zipcode | Email              | Password   | Dishname | Quantity | GarRice | MasPo     | PakUpTime | Package | URL1                                                                    | ErrMes1 | ErrMes2                       |
      | 94122   | xukun310@gmail.com | O12345678a | xDish1   | xQuanty2 | xRice0  | xPotato0  | xPikup1   | xPack1  | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/checkout | Oops!   | Pork breadno support delivery |
      | 94117   | xukun310@gmail.com | O12345678a | xDish5   | xQuanty7 | xRice5  | xPotato26 | xPikup3   | xPack1  | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/checkout | Oops!   | Pork breadno support delivery |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode and back navigation
    When I access to Dailymenu page with "<zipcode>"
    And open detail a dish "<Dishname>"
    And Press Checkout button
    And Press Back to Dailymenu
    And Press Back to Menu section "<URL1>"
    Then I will be back to Dailymenu page "<URL2>"

    Examples: 
      | zipcode | Dishname | URL1                                                                                 | URL2                                                                      |
      | 94122   | xDish1   | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/dish/eggplantparmesan | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/daily-menu |
      | 94117   | xDish5   | cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/dish/ChickenRice             | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/daily-menu |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode and check-out without sign-in
    When I access to Dailymenu page with "<zipcode>"
    And open detail a dish "<Dishname>"
    And select quantity of dish "<Quantity>"
    And select quantity of Garlic Rice "<GarRice>"
    And select quantiy of Mashed Potato "<MasPo>"
    And select Pick Up Time "<PakUpTime>"
    And select Packaging "<Package>"
    And add a note for the Chef
    And click on Checkout button
    And click on Place Order button
    Then Sign-in pop-up with appear
      | zipcode | Dishname | Quantity  | GarRice | MasPo    | PakUpTime | Package | URL1                                                                    | URL2 |
      | 94122   | xDish1   | xQuanty   | xRice0  | xPotato0 | xPikup1   | xPack1  | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/checkout |      |
      | 94117   | xDish4   | xQuanty10 | xRice1  | xPotato1 | xPikup2   | xPack2  | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/checkout |      |

  Scenario Outline: Customers check-out and add to the meals
    When I access to Dailymenu page with "<zipcode>"
    And open detail a dish "<Dishname>"
    And select quantity of dish "<Quantity>"
    And select quantity of Garlic Rice "<GarRice>"
    And select quantiy of Mashed Potato "<MasPo>"
    And select Pick Up Times "<PakUpTime>"
    And select Packaging "<Package>"
    And click on Add to My Meals button
    And click on Back to menu section
    And click on My meals icon
    Then Customer will be redirected to Checkout page with already meals "<URL1>" "<ExDish>"
      | zipcode | Dishname | Quantity  | GarRice | MasPo    | PakUpTime | Package | URL1                                                                    | ExDish |
      | 94122   | xDish1   | xQuanty   | xRice0  | xPotato0 | xPikup1   | xPack1  | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/checkout | EXMEAL |
      | 94117   | xDish4   | xQuanty10 | xRice1  | xPotato1 | xPikup2   | xPack2  | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/checkout | EXMEAL |

  Scenario Outline: Customers check-out and timeout
    When I access to Dailymenu page with "<zipcode>"
    And open detail a dish "<Dishname>"
    And click on Checkout button and waiting around fifteen minutes
    Then Timeout popup appear with messages "<TimeOutTitle>"
      | zipcode | Dishname | TimeOutTitle | TimeOutContent                                                                                                                                                                                                               |
      | 94122   | xDish1   | Time's Up!   | Lorem ipsum dolor sit amet, sint docendi mea ne, usu feugait constituto et. Ad quem necessitatibus eos, ex salutandi complectitur mea. An soleat epicuri deleniti mel, stet tractatos at per. Eleifend interpretaris ad eum. |
      | 94117   | xDish4   | Time's Up!   | Lorem ipsum dolor sit amet, sint docendi mea ne, usu feugait constituto et. Ad quem necessitatibus eos, ex salutandi complectitur mea. An soleat epicuri deleniti mel, stet tractatos at per. Eleifend interpretaris ad eum. |
