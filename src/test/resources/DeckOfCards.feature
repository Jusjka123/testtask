Feature: DeckOfCards

  Scenario Outline: 1
    Given User creates a deck
    When User draws <drawCardsCount> cards
    Then Remaining cards left <cardsLeft>

    Examples:
      | drawCardsCount | cardsLeft |
      | 12             | 40        |
      | 20             | 32        |
      | 30             | 22        |

  Scenario: 2
    Given User creates a deck containing cards
      | AS |
      | AD |
      | AC |
      | AH |
    When User draws 4 cards
    Then Remaining cards left 0
    And Drawn cards are "ACE"

#  Scenario: 3
#  Given
#  When
#  Then