@dailymenu
Feature: Customer accessed to Cuchine and pick out the dishes in daily-menu then he wants to checkout his picked dishes in the car
  Description: After sign-in Customer want to see the dishes and chefs in daily menu page
  we need to verify all of the main function are correct on the site or not

  Background: 
    Given Customer access to the Daily-menu page and check around the dishes "http://cuchine:web01@cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com" "<data>"
      | TableID | Categories              | Dishname               | Thumbnail_image                            |
      | 1       | Tom Cruise              | Pizza                  | photo-1_3.jpg                              |
      | 2       |                         | Garlic Rice            | garlic_rice.jpg                            |
      | 3       |                         | Mashed Potato          | mash_potatoes.jpg                          |
      | 4       |                         | Chili                  | chili.jpg                                  |
      | 5       | Victor Alan             | Beefsteak              | images_6_.jpg                              |
      | 6       | Wilson Wat              | clear rice noodle soup | hutieu1.jpg                                |
      | 7       | David Connery           | sushi                  | images_1_.jpg                              |
      | 8       | Victor Alan,Henry King  | Vietnamese Udon        | banh_canh_1.jpg                            |
      | 9       |                         | style noodle           | mi_quang_1.jpg                             |
      | 10      | Magaret Goldlum         | Eggplant Parmesan      | photo-1_3.jpg                              |
      | 12      |                         | Spinach salad          | strawberry-and-avocado-spinach-salad-4.jpg |
      | 13      | Victor Alan             | chinese braised pork   | thit_kho_1.jpg                             |
      | 14      | Laura Kerr              | Cheese wraps           | egg-cheese-burrito.jpg                     |
      | 15      | Henry King              | Pork bread             | images_5_.jpg                              |
      | 16      | Magaret Goldlum         | Hamburger              | meal2.jpg                                  |
      | 17      | Victor Alan             | Beef and egg           | f04da2db11221473709001.jpg                 |
      | 19      | Wilson Wat              | Turkey burger          | lorraine_pita-turkey-burger_2.jpg          |
      | 20      |                         | Eggplant Parmesan 1    | pho.jpg                                    |
      | 21      | Lorem ispum Lorem Ipsum | Sandwich               | download.jpg                               |
      | 22      |                         | Vegetable              | vegetable.jpg                              |
      | 23      | Victor Alan             | Caprese Pasta          | caprese-pasta-665_1.jpg                    |
      | 24      | Lorem Ispum             | Mesclun Salad          | mesclun-tomate-peches-4446.jpg             |
      | 25      | Tom Cruise              | Carrot-Cheddar         | 3596-1.jpg                                 |
      | 26      | Cletus Luu              | Food001                | fast-food_2.jpg                            |
      | 27      | Cletus Luu              | Food002                | food-wallpaper-5775-5940-hd-wallpapers.jpg |
      | 29      | Vinh Luu                | Foody04                | food-wide-wallpaper-334729.jpg             |
      | 30      | Vinh Luu                | Foody05                | food_13.jpg                                |
      | 31      | Martin Yan              | BANH DA                | 110820104606-250-433.jpg                   |
      | 32      | Ken Kenny               | Salmon Fish            | salmon_fish.jpg                            |
      | 33      | Henry King              | Beef noodle            | pho.jpg                                    |
      | 34      | Cletus Luu              | Food003                | download_1.jpg                             |
      | 35      |                         | Garlic Rice 2          | garlic_rice_1.jpg                          |
      | 36      | Henry King              | Chicken rice           | images_8_.jpg                              |
      | 37      | Henry King              | Beef noodle Dup        | pho_1.jpg                                  |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode
    When I access to Dailymenu page with "<zipcode>"
    And click on Calendar
    Then I check Menu that related to user zip code "<Date>" "<Data>"

    Examples: 
      | Date | zipcode | Data       |
      | 29   | 94122   | 8,10,13,19 |
      | 01   | 94122   | 10,15      |
      | 02   | 94122   | 29         |
      | 29   | 94117   | 17,13      |
      | 01   | 94117   | 6,10,15    |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode
    When I access to Dailymenu page with "<zipcode>"
    And click on "<Option>"
    Then I check Menu that related to user zip code "<Data>"

    Examples: 
      | Option       | zipcode | Data       |
      | PICKUPONLY   | 94122   | 8,10,13,19 |
      | DELIVERYONLY | 94122   | 10,15      |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode
    When I access to Dailymenu page with "<zipcode>"
    And click on "<Option>"
    Then I check Menu that related to user zip code "<Data>"

    Examples: 
      | Option       | zipcode | Data       |
      | PICKUPONLY   | 94122   | 8,10,13,19 |
      | DELIVERYONLY | 94122   | 10,15      |
      | PICKUPONLY   | 94117   | 8,10,13,19 |
      | DELIVERYONLY | 94117   |            |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode
    When I access to Dailymenu page with "<zipcode>"
    And open filter
    And click on Clear button
    Then I check Menu that related to user zip code "<Data>"

    Examples: 
      | zipcode | Data       |
      | 94122   | 8,10,13,19 |
      | 94122   | 10,15      |
      | 94117   | 8,10,13,19 |
      | 94117   |            |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode and select filter
    When I access to Dailymenu page with "<zipcode>"
    And click on Calendar
    And select a day in calendar
    And open filter
    And select options in filter "<DietFilter>" "<NeiFilter>" "<TimeFilter>"
    And click Show Result button
    Then I can see list of dishes."<Data>" "<ErrMes>"

    Examples: 
      | zipcode | DietFilter                       | NeiFilter                  | TimeFilter           | Data                      | Errmes                                            |
      | 94122   |                                  |                            |                      | 17,14,13,24,30,10,15,6,29 |                                                   |
      | 94122   | DIETVEGE                         | FORHILL                    | TIMELUNCH            |                           | There is not any available dish in next two weeks |
      | 94122   | DIETVEGE                         | FORHILL                    | TIMEDINNER           |                           | There is not any available dish in next two weeks |
      | 94122   | DIETVEGE                         | FORHILL                    | TIMELUNCH,TIMEDINNER |                           | There is not any available dish in next two weeks |
      | 94122   | GLUFR                            | FORHILL                    | TIMEDINNER           |                           | There is not any available dish in next two weeks |
      | 94122   | GLUFR                            | FORHILL                    | TIMELUNCH            |                           | There is not any available dish in next two weeks |
      | 94122   | GLUFR                            | FORHILL                    | TIMELUNCH,TIMEDINNER |                           | There is not any available dish in next two weeks |
      | 94122   | GLUFR                            | INPAR                      | TIMELUNCH            |                           | There is not any available dish in next two weeks |
      | 94122   | GLUFR                            | INPAR                      | TIMEDINNER           |                           | There is not any available dish in next two weeks |
      | 94122   | GLUFR                            | INPAR                      | TIMELUNCH,TIMEDINNER |                           | There is not any available dish in next two weeks |
      | 94122   | GLUFR                            | WESPOR                     | TIMELUNCH            | 29                        |                                                   |
      | 94122   | GLUFR                            | WESPOR                     | TIMEDINNER           | 30                        |                                                   |
      | 94122   | GLUFR                            | WESPOR                     | TIMELUNCH,TIMEDINNER | 30                        |                                                   |
      | 94122   | GLUFR                            | INSUN                      | TIMELUNCH            | 30                        |                                                   |
      | 94122   | GLUFR                            | INSUN                      | TIMEDINNER           | 30                        |                                                   |
      | 94122   | GLUFR                            | INSUN                      | TIMELUNCH,TIMEDINNER | 30                        |                                                   |
      | 94122   | DAIFR                            | FORHILL                    | TIMEDINNER           |                           | There is not any available dish in next two weeks |
      | 94122   | DAIFR                            | FORHILL                    | TIMELUNCH            |                           | There is not any available dish in next two weeks |
      | 94122   | DAIFR                            | FORHILL                    | TIMELUNCH,TIMEDINNER |                           | There is not any available dish in next two weeks |
      | 94122   | DAIFR                            | INPAR                      | TIMELUNCH            |                           | There is not any available dish in next two weeks |
      | 94122   | DAIFR                            | INPAR                      | TIMEDINNER           |                           | There is not any available dish in next two weeks |
      | 94122   | DAIFR                            | INPAR                      | TIMELUNCH,TIMEDINNER |                           | There is not any available dish in next two weeks |
      | 94122   | DAIFR                            | WESPOR                     | TIMELUNCH            | 29                        |                                                   |
      | 94122   | DAIFR                            | WESPOR                     | TIMEDINNER           | 30                        |                                                   |
      | 94122   | DAIFR                            | WESPOR                     | TIMELUNCH,TIMEDINNER | 30                        |                                                   |
      | 94122   | DAIFR                            | INSUN                      | TIMELUNCH            | 30                        |                                                   |
      | 94122   | DAIFR                            | INSUN                      | TIMEDINNER           | 30                        |                                                   |
      | 94122   | DAIFR                            | INSUN                      | TIMELUNCH,TIMEDINNER | 30                        |                                                   |
      | 94122   | NUTFR                            | FORHILL                    | TIMEDINNER           |                           | There is not any available dish in next two weeks |
      | 94122   | NUTFR                            | FORHILL                    | TIMELUNCH            |                           | There is not any available dish in next two weeks |
      | 94122   | NUTFR                            | FORHILL                    | TIMELUNCH,TIMEDINNER |                           | There is not any available dish in next two weeks |
      | 94122   | NUTFR                            | INPAR                      | TIMELUNCH            |                           | There is not any available dish in next two weeks |
      | 94122   | NUTFR                            | INPAR                      | TIMEDINNER           |                           | There is not any available dish in next two weeks |
      | 94122   | NUTFR                            | INPAR                      | TIMELUNCH,TIMEDINNER |                           | There is not any available dish in next two weeks |
      | 94122   | NUTFR                            | WESPOR                     | TIMELUNCH            | 29                        |                                                   |
      | 94122   | NUTFR                            | WESPOR                     | TIMEDINNER           | 30                        |                                                   |
      | 94122   | NUTFR                            | WESPOR                     | TIMELUNCH,TIMEDINNER | 30                        |                                                   |
      | 94122   | NUTFR                            | INSUN                      | TIMELUNCH            | 30                        |                                                   |
      | 94122   | NUTFR                            | INSUN                      | TIMEDINNER           | 30                        |                                                   |
      | 94122   | NUTFR                            | INSUN                      | TIMELUNCH,TIMEDINNER | 30                        |                                                   |
      | 94122   | VEGAN                            | FORHILL                    | TIMEDINNER           |                           | There is not any available dish in next two weeks |
      | 94122   | VEGAN                            | FORHILL                    | TIMELUNCH            |                           | There is not any available dish in next two weeks |
      | 94122   | VEGAN                            | FORHILL                    | TIMELUNCH,TIMEDINNER |                           | There is not any available dish in next two weeks |
      | 94122   | VEGAN                            | INPAR                      | TIMELUNCH            |                           | There is not any available dish in next two weeks |
      | 94122   | VEGAN                            | INPAR                      | TIMEDINNER           |                           | There is not any available dish in next two weeks |
      | 94122   | VEGAN                            | INPAR                      | TIMELUNCH,TIMEDINNER |                           | There is not any available dish in next two weeks |
      | 94122   | VEGAN                            | WESPOR                     | TIMELUNCH            | 29                        |                                                   |
      | 94122   | VEGAN                            | WESPOR                     | TIMEDINNER           | 30                        |                                                   |
      | 94122   | VEGAN                            | WESPOR                     | TIMELUNCH,TIMEDINNER | 30                        |                                                   |
      | 94122   | VEGAN                            | INSUN                      | TIMELUNCH            | 30                        |                                                   |
      | 94122   | VEGAN                            | INSUN                      | TIMEDINNER           | 30                        |                                                   |
      | 94122   | VEGAN                            | INSUN                      | TIMELUNCH,TIMEDINNER | 30                        |                                                   |
      | 94122   | DIETVEGE,GLUFR                   | FORHILL,INPAR              | TIMELUNCH            | 24                        |                                                   |
      | 94122   | DIETVEGE,GLUFR                   | FORHILL,INPAR              | TIMEDINNER           | 24                        |                                                   |
      | 94122   | DIETVEGE,GLUFR                   | FORHILL,INPAR              | TIMELUNCH,TIMEDINNER | 24                        |                                                   |
      | 94122   | DIETVEGE,GLUFR,DAIFR             | FORHILL,INPAR,WESPOR       | TIMELUNCH            | 14,24,30                  |                                                   |
      | 94122   | DIETVEGE,GLUFR,DAIFR             | FORHILL,INPAR,WESPOR       | TIMEDINNER           | 14,24,30                  |                                                   |
      | 94122   | DIETVEGE,GLUFR,DAIFR             | FORHILL,INPAR,WESPOR       | TIMELUNCH,TIMEDINNER | 14,24,30                  |                                                   |
      | 94122   | DIETVEGE,GLUFR,DAIFR,NUTFR,      | FORHILL,INPAR,WESPOR,INSUN | TIMELUNCH            | 17,14,13,24,30,10,15,6,29 |                                                   |
      | 94122   | DIETVEGE,GLUFR,DAIFR,NUTFR,      | FORHILL,INPAR,WESPOR,INSUN | TIMEDINNER           | 17,14,13,24,30,10,15,6,29 |                                                   |
      | 94122   | DIETVEGE,GLUFR,DAIFR,NUTFR,      | FORHILL,INPAR,WESPOR,INSUN | TIMELUNCH,TIMEDINNER | 17,14,13,24,30,10,15,6,29 |                                                   |
      | 94122   | DIETVEGE,GLUFR,DAIFR,NUTFR,VEGAN | FORHILL,INPAR,WESPOR,INSUN | TIMELUNCH            | 17,14,13,24,30,10,15,6,29 |                                                   |
      | 94122   | DIETVEGE,GLUFR,DAIFR,NUTFR,VEGAN | FORHILL,INPAR,WESPOR,INSUN | TIMEDINNER           | 17,14,13,24,30,10,15,6,29 |                                                   |
      | 94122   | DIETVEGE,GLUFR,DAIFR,NUTFR,VEGAN | FORHILL,INPAR,WESPOR,INSUN | TIMELUNCH,TIMEDINNER | 17,14,13,24,30,10,15,6,29 |                                                   |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode
    When I access to Dailymenu page with "<zipcode>"
    And click on Calendar
    And Select a day in calendar
    And click on a dish
    Then I can see detail of dish "<URL>"

    Examples: 
      | zipcode | URL                                                                            |
      | 94122   | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/dish/beefnoodle |

  Scenario Outline: Customers access to Daily-menu with full supported zipcode and
    When I access to Dailymenu page with "<zipcode>"
    And click on Calendar
    And select a day in calendar
    And click on a dish
    And click on Chef
    Then I can see detail of Chef "<URL>"

    Examples: 
      | zipcode | URL                                                                                |
      | 94122   | http://cuchinesutrixtest-757790250.us-west-2.elb.amazonaws.com/chef/chef-for-94122 |
