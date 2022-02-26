/**
 * Implementation of a single user BlackJack game
 * This is a simple version that supports the player Hit and/or Stand actions
 * Source: https://github.com/sranga/examples-blackjack
 */
// package examples.games
package models
import scala.util.Random
// import java.util.logging.Logger

/**
 * Represents a Card suit - Hearts, Diamonds, Spades, Clubs
 */
sealed trait Suit
case object Heart extends Suit
case object Diamond extends Suit
case object Spade extends Suit
case object Club extends Suit

/**
 * Represents a Card rank - Ace, King, Queen, Jack, 10..1
 */
sealed abstract class Rank(val value: Int)
case object King extends Rank(10)
case object Queen extends Rank(10)
case object Jack extends Rank(10)
case object Ten extends Rank(10)
case object Nine extends Rank(9)
case object Eight extends Rank(8)
case object Seven extends Rank(7)
case object Six extends Rank(6)
case object Five extends Rank(5)
case object Four extends Rank(4)
case object Three extends Rank(3)
case object Two extends Rank(2)
case object Ace extends Rank(1)

/**
 * Represents a card
 */
case class Card(suit: Suit, rank: Rank)

/**
 * Represents a deck of cards
 */
class Deck {

  val cards = collection.mutable.ListBuffer() ++ Random.shuffle(initDeck)

  /**
   * Method that deals a card from the deck.
   * The top card is removed from the deck and returned
   */
  def dealCard: Option[Card] = cards.isEmpty match {
    case true => None
    case false =>
      val card = cards.head
      cards -= card
      Some(card)
  }

  /**
   * Method that initializes the deck of cards
   */
  def initDeck =
    for {
      suit <- List(Heart, Diamond, Spade, Club)
      rank <- List(King, Queen, Jack, Ten, Nine, Eight, Seven, Six, Five, Four, Three, Two, Ace)
    }
    yield new Card(suit, rank)
}

/**
 * Represents a Hand of cards
 * Used for both the player and dealer
 */
class Hand {

  val cards = collection.mutable.ArrayBuffer[Card]()
  val winningValue = 21

  /**
   * Function to determine if the hand has an Ace
   */
  def containsAce(): Boolean = cards.exists(c => c.rank == Ace)

  /**
   * Method that adds a card to the existing hand
   */
  def addCard (c: Card) = cards += c

  /**
   * Function that computes the value of the hand
   */
  def value(): Int = cards.foldLeft(0)((result, card) => result + card.rank.value)

  /**
   * Function that computes the value of the hand with an ace valued at 11 instead of 1
   */
  def specialValue(): Int = if (containsAce()) value + 10 else value()

  /**
   * Checks if this hand has winning cards
   */
  def isBlackJack: Boolean = value() == winningValue || specialValue() == winningValue

  /**
   * Checks if this hand has lost (value > 21)
   */
  def isBust: Boolean = value() > winningValue

  /**
   * Checks if this hand wins over the hand specified
   */
  def winsOver (otherHand: Hand): Boolean = {
    val opponentBestValue = List(otherHand.value(), otherHand.specialValue()).filter(v => v <= winningValue).max
    val bestValue = List(value(), specialValue()).filter(v => v <= winningValue).max
    // Return true if all of this hand's best value is higher than the other hand's best value
    bestValue > opponentBestValue
  }

  /**
   * Return the cards in the hand
   * If the dealer flag is true, only the first card is shown
   */
  def showCards (dealer: Boolean = false): String =
    if (dealer) s"${cards.head.rank.value} X" else cards.map(c => c.rank.value) mkString ", "
}


