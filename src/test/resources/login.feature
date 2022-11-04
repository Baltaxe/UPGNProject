@UPGN-Login
Feature: As a user, I should be able to login

  Background:
    Given user is on the login page

  @UPGN-726
  Scenario Outline: verify user login with valid credentials

    When user enter valid "<username>" and "<password>"
    And user click login button
    Then Verify user launched to the dashboard
    Then user logs out

    Examples:
      | username                 | password     |
      | salesmanager8@info.com   | salesmanager |
      | salesmanager78@info.com  | salesmanager |
      | salesmanager104@info.com | salesmanager |
      | posmanager10@info.com    | posmanager   |
      | posmanager65@info.com    | posmanager   |
      | posmanager145@info.com   | posmanager   |

  @UPGN-777
  Scenario Outline: verify user login fail with invalid credentials
    When user enter invalid "<username>" and "<password>"
    And user click login button
    Then "Wrong username or password" warning message should be displayed

    Examples:
      | username                 | password     |
      | salesmanager8@info.com   | posmanager   |
      | posmanager10@info.com    | salesmanager |
      | salesmanager250@info.com | salesmanager |
      | posmanager250@info.com   | posmanager   |
      | salesmanager106@info.com | salesmanager |
      | salesmanager107@info.com | salesmanager |

  @UPGN-778
  Scenario Outline: User see "Please fill out this field" message if the "username" or "password" is empty
    When user enter valid "<username>" and "<password>"
    And user click login button
    Then user see warning message
    Examples:
      | username                 | password   |
      | salesmanager104@info.com |            |
      |                          | posmanager |

  @UPGN-780
  Scenario Outline: User should verify Enter key is working correctly
    When user enter valid "<username>" and "<password>"
    And user push enter key on keyboard
    Then Verify user launched to the dashboard
    Examples:
      | username                 | password     |
      | salesmanager104@info.com | salesmanager |
      | posmanager10@info.com    | posmanager   |