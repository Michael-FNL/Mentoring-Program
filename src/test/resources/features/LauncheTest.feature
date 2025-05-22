Feature: Launch Test

  @Regression
  Scenario Outline: User is able to see launches list sorted by most recent by default, and is able to resort them.
    Given the username is logged into the portal:
      | username   | superadmin  |
      | password   | erebus      |
    And the user navigates to the Launches page
    When the user selects '<filterOption>' from the Launches page filters
    Then the launches should be sorted and show correct type
    Examples:
      | filterOption             |
      | ALL_LAUNCHES             |
      | LATEST_LAUNCHES          |

  @Regression
  Scenario: All launches have a delete option.
    Given the username is logged into the portal:
      | username   | superadmin  |
      | password   | erebus      |
    When the user navigates to the Launches page
    Then all launches should have the delete option

  @Regression
  Scenario Outline: Each launch contains tests count dat a.
    Given the username is logged into the portal:
      | username   | superadmin  |
      | password   | erebus      |
    When the user navigates to the Launches page
    Then the launches table should display the correct '<header>'
    Examples:
      | header             |
      | PASSED             |
      | FAILED             |
      | SKIPPED            |
      | PRODUCT_BUG        |
      | AUTO_BUG           |
      | SYSTEM_ISSUE       |
      | TO_INVESTIGATE     |