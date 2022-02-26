package models

import akka.actor._
import play.api.libs.json._
import play.api.libs.json.Json
import scala.compat.Platform.EOL
object SimpleWebSocketActor {
    // DOCS: Props is a ActorRef configuration object, that is immutable, so it is 
    // thread-safe and fully sharable. Used when creating new actors through 
    // ActorSystem.actorOf and ActorContext.actorOf.
    def props(clientActorRef: ActorRef) = Props(new SimpleWebSocketActor(clientActorRef))
}

class SimpleWebSocketActor(clientActorRef: ActorRef) extends Actor {
    val logger = play.api.Logger(getClass)
    logger.info(s"SimpleWebSocketActor class started")
    val game_responses = List("S", "H", "h", "s")  
    val final_responses = List("Y", "N", "n", "y")  
    var userCredit = 100
    var status = "no"    
    var credit = 0;
    var playerHand =  new Hand()
    var dealerHand = new Hand()
    def receive = {
        case jsValue: JsValue =>
            val clientMessage = getMessage(jsValue)
            if(clientMessage == "hi"){
                status = "betForHand";
                credit = 0;
                userCredit = 100;
                playerHand = new Hand()
                dealerHand = new Hand()
                betForHand()
            }
            else if(status == "getCredit"){  
                if (clientMessage.forall(Character.isDigit)){
                    credit = clientMessage.toInt
                    playHand(credit)
                }
                else{
                    printMessage("invalid input, please try again")
                }
            }
            else if(status == "getPlayerAct"){
                if(game_responses.contains(clientMessage)){
                     didPlayerWin(new Deck, playerHand, dealerHand,clientMessage)
              
                     if(status == "getPlayerAct" ){
                        showCards(playerHand, dealerHand)
                        printMessage("Hit or Stand? Enter one of (H,h,S,s): ")
                     }
                     else if(status == "checkcontinue"){
                         if(userCredit <= 0) {
                             printMessage("not enough credit to continue, game over, type in 'hi' to restart the game")
                         }
                         else{
                             printMessage("Continue the game? Enter one of (Y,y,N,n):")
                         }
                     }
                }
                else{
                    printMessage("invalid input, please try again")
                }
            }
            else if(status == "checkcontinue"){
                if(clientMessage == "Y" || clientMessage == "y")
                    betForHand()
                else if(clientMessage == "N" || clientMessage == "n"){
                    printMessage("bye, have a nice day :)")
                }
                else{
                    printMessage("invalid message, please try again")
                }
            }
    }

    def printMessage(input:String) = {
        var json: JsValue = Json.parse(s"""{"body": "$input"}""")
        clientActorRef ! (json)
    }
    // parse the "message" field from the json the client sends us
    // def getMessage(json: JsValue): String = (json \ "message").as[String]
    def getMessage(json: JsValue): String = (json\ "message").as[String]
    

    def playHand(credit: Int)= {
        printMessage("Bet for the current hand:"+credit.toString)
        val cardDeck = new Deck
        val res = dealCards(cardDeck)//(playerHand, dealerHand) = 
        playerHand = res._1
        dealerHand = res._2
      
        // After the cards are dealt, a hand with 21 wins
        // If there is a tie, the dealer wins
        if (dealerHand.isBlackJack) {
            showCards(playerHand, dealerHand, maskDealerCards = false)
            printMessage("*** BlackJack: Dealer wins! ***")
            userCredit = userCredit - credit
            if(userCredit > 0){
                printMessage("Continue the game? Enter one of (Y,y,N,n):")
                status = "checkcontinue"
            }
            else{
                printMessage("game over, please type in 'hi' to try again")
            }
        } 
        else if (playerHand.isBlackJack) {
            showCards(playerHand, dealerHand, maskDealerCards = false)
            printMessage("*** BlackJack: Player wins! ***")
            userCredit = userCredit + credit
            if(userCredit > 0){
                printMessage("Continue the game? Enter one of (Y,y,N,n):")
                status = "checkcontinue"
            }
            else{
                printMessage("game over, please type in 'hi' to try again")
            }
        } 
        else {
            status = "getPlayerAct"
  
            showCards(playerHand, dealerHand)
            printMessage("Hit or Stand? Enter one of (H,h,S,s): ")

            // val playerWon = didPlayerWin(cardDeck, playerHand, dealerHand)
            // result = if (playerWon) credit else -credit
        }
  
    }

    def betForHand() = {
        var credit = userCredit + 1 // initialize credit to be more than the current credit to keep the loop below going
        if (credit > userCredit || credit < 1) {
            printMessage("Please enter your bet for this round. Credit at hand:"+userCredit.toString)
            status = "getCredit"
        }
        // Return the bet for this hand
  }
    def test(s:String){
        printMessage("hue")
    }


  def showCards (playerHand: Hand, dealerHand: Hand, maskDealerCards: Boolean = true) = {
    val s1 = "Dealer hand: "+dealerHand.showCards(maskDealerCards).mkString
    val s2 =  "Player hand: "+playerHand.showCards().mkString
    printMessage(s1)
    printMessage(s2)
  }

  /**
   * Function that deals the cards to the player & dealer
   */
  def dealCards (deck: Deck) = {
    val playerHand = new Hand
    val dealerHand = new Hand
    // Deal two cards to the player
    playerHand.addCard(deck.dealCard.get)
    playerHand.addCard(deck.dealCard.get)

    // Deal two cards to the dealer
    dealerHand.addCard(deck.dealCard.get)
    dealerHand.addCard(deck.dealCard.get)

    // Return the hands
    (playerHand, dealerHand)

  }
  def didPlayerWin(deck: Deck, playerHand: Hand, dealerHand: Hand,input:String) = {
      if ("S".equalsIgnoreCase(input)) {
        // Deal card to the dealer till his hand's value is over 17
        while (dealerHand.value() < 17) {
          dealerHand.addCard(deck.dealCard.get)
        }
        // Player wins if dealer had goes bust or dealer's hand value is less than that of the player's
        var playerWon = dealerHand.isBust || playerHand.winsOver(dealerHand)
        if(playerWon){
            printMessage("*** You win! *** ")
            userCredit = userCredit + credit
            status = "checkcontinue"
        }
        else{
            printMessage("*** You lose! *** ")
            userCredit = userCredit - credit
            status = "checkcontinue"
        }
   
        showCards(playerHand, dealerHand, maskDealerCards = false)
      } else {
        // If user chooses to "Hit", deal a card
        // Player loses if his hand value goes bust
        playerHand.addCard(deck.dealCard.get)
        if (playerHand.isBust) {
          printMessage("*** You lose! ***")
          showCards(playerHand, dealerHand, maskDealerCards = false)

          userCredit = userCredit - credit
          status = "checkcontinue"
        }
      }

  }

  

}
