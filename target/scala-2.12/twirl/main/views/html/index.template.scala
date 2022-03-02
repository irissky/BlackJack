
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),_display_(/*3.2*/main("The Game of Twenty-One")/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

    """),format.raw/*5.5*/("""<h1 class="text-primary" style="font-size:24px;padding-bottom:1.5em;">The Game of Twenty-One: <small>Hu Yue &amp; Hu Xuan</small></h1>
    <h6>IT5100A Final Project</h6>
    <p>Welcome to the single-user game of 21 (also called Blackjack)!</p>
    <p>The game starts by dealing out two cards each to the player and dealer. A score of 21 wins the game for the player or dealer.</p>
    <p>In the event of a tie, the dealer wins. The user shall receive 100 coins at the beginning of the game.He can choose to bet any number of available coins at each hand. Once all the coins are exhausted, the game ends.The user can choose to "Hit" by entering a "H" when prompted. A "S" response would be assumed to be a "Stand".Good Luck!! </p>
    <h6 class="text-primary"> type in 'hi' to start the game </h2>
    <!-- this is where the client and server output will be shown/appended -->
    <h4>Dealer</h4>
    <div id="message-content-server" style="height:230px;overflow-y:auto !important;background-color:#fff;padding:1em;border-radius:10px;"></div>
    <h4>Player</h4>
    <div id="message-content-client" style="height:230px;overflow-y:auto !important;background-color:#fff;padding:1em;border-radius:10px;"></div>

    <form style="padding-top:1.5em;">
        <div class="form-group">
            <label for="message-input">Message:</label>
            <textarea id="message-input" class="form-control" ></textarea>
        </div>
        <button id="send-button" type="button" class="btn btn-primary">Send</button>
    </form>

    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <script>
    var webSocket;
    var messageInput;

    function init() """),format.raw/*31.21*/("""{"""),format.raw/*31.22*/("""
        """),format.raw/*32.9*/("""webSocket = new WebSocket("ws://localhost:9000/ws");
        webSocket.onopen = onOpen;
        webSocket.onclose = onClose;
        webSocket.onmessage = onMessage;
        webSocket.onerror = onError;
        $("#message-input").focus();
    """),format.raw/*38.5*/("""}"""),format.raw/*38.6*/("""

    """),format.raw/*40.5*/("""function onOpen(event) """),format.raw/*40.28*/("""{"""),format.raw/*40.29*/("""
        """),format.raw/*41.9*/("""consoleLog("CONNECTED");
    """),format.raw/*42.5*/("""}"""),format.raw/*42.6*/("""

    """),format.raw/*44.5*/("""function onClose(event) """),format.raw/*44.29*/("""{"""),format.raw/*44.30*/("""
        """),format.raw/*45.9*/("""consoleLog("DISCONNECTED");
        appendClientMessageToView(":", "DISCONNECTED");
    """),format.raw/*47.5*/("""}"""),format.raw/*47.6*/("""

    """),format.raw/*49.5*/("""function onError(event) """),format.raw/*49.29*/("""{"""),format.raw/*49.30*/("""
        """),format.raw/*50.9*/("""consoleLog("ERROR: " + event.data);
        consoleLog("ERROR: " + JSON.stringify(event));
    """),format.raw/*52.5*/("""}"""),format.raw/*52.6*/("""

    """),format.raw/*54.5*/("""function onMessage(event) """),format.raw/*54.31*/("""{"""),format.raw/*54.32*/("""
        """),format.raw/*55.9*/("""console.log(event.data);
        let receivedData = JSON.parse(event.data);
        console.log("New Data: ", receivedData);
        // get the text from the "body" field of the json we
        // receive from the server.
        appendServerMessageToView("Server", receivedData.body);
    """),format.raw/*61.5*/("""}"""),format.raw/*61.6*/("""

    """),format.raw/*63.5*/("""function appendClientMessageToView(title, message) """),format.raw/*63.56*/("""{"""),format.raw/*63.57*/("""
        """),format.raw/*64.9*/("""$("#message-content-client").append("<span>" + title + ": " + message + "<br /></span>");
    """),format.raw/*65.5*/("""}"""),format.raw/*65.6*/("""

    """),format.raw/*67.5*/("""function appendServerMessageToView(title, message) """),format.raw/*67.56*/("""{"""),format.raw/*67.57*/("""
        """),format.raw/*68.9*/("""$("#message-content-server").append("<span>" + title + ": " + message + "<br /><br /></span>");
    """),format.raw/*69.5*/("""}"""),format.raw/*69.6*/("""

    """),format.raw/*71.5*/("""function consoleLog(message) """),format.raw/*71.34*/("""{"""),format.raw/*71.35*/("""
        """),format.raw/*72.9*/("""console.log("New message: ", message);
    """),format.raw/*73.5*/("""}"""),format.raw/*73.6*/("""

    """),format.raw/*75.5*/("""window.addEventListener("load", init, false);

    $("#send-button").click(function (e) """),format.raw/*77.42*/("""{"""),format.raw/*77.43*/("""
        """),format.raw/*78.9*/("""console.log("Sending ...");
        getMessageAndSendToServer();
        // put focus back in the textarea
        $("#message-input").focus();
    """),format.raw/*82.5*/("""}"""),format.raw/*82.6*/(""");

    // send the message when the user presses the <enter> key while in the textarea
    $(window).on("keydown", function (e) """),format.raw/*85.42*/("""{"""),format.raw/*85.43*/("""
        """),format.raw/*86.9*/("""if (e.which == 13) """),format.raw/*86.28*/("""{"""),format.raw/*86.29*/("""
            """),format.raw/*87.13*/("""getMessageAndSendToServer();
            return false;
        """),format.raw/*89.9*/("""}"""),format.raw/*89.10*/("""
    """),format.raw/*90.5*/("""}"""),format.raw/*90.6*/(""");

    // there’s a lot going on here:
    // 1. get our message from the textarea.
    // 2. append that message to our view/div.
    // 3. create a json version of the message.
    // 4. send the message to the server.
    function getMessageAndSendToServer() """),format.raw/*97.42*/("""{"""),format.raw/*97.43*/("""

        """),format.raw/*99.9*/("""// get the text from the textarea
        messageInput = $("#message-input").val();

        // clear the textarea
        $("#message-input").val("");

        // if the trimmed message was blank, return now
        if ($.trim(messageInput) == "") """),format.raw/*106.41*/("""{"""),format.raw/*106.42*/("""
            """),format.raw/*107.13*/("""return false;
        """),format.raw/*108.9*/("""}"""),format.raw/*108.10*/("""

        """),format.raw/*110.9*/("""// add the message to the view/div
        appendClientMessageToView("Me", messageInput);

        // create the message as json
        let jsonMessage = """),format.raw/*114.27*/("""{"""),format.raw/*114.28*/("""
            """),format.raw/*115.13*/("""message: messageInput
        """),format.raw/*116.9*/("""}"""),format.raw/*116.10*/(""";

        // send our json message to the server
        sendToServer(jsonMessage);
    """),format.raw/*120.5*/("""}"""),format.raw/*120.6*/("""

    """),format.raw/*122.5*/("""// send the data to the server using the WebSocket
    function sendToServer(jsonMessage) """),format.raw/*123.40*/("""{"""),format.raw/*123.41*/("""
        """),format.raw/*124.9*/("""if(webSocket.readyState == WebSocket.OPEN) """),format.raw/*124.52*/("""{"""),format.raw/*124.53*/("""
            """),format.raw/*125.13*/("""consoleLog("SENT: " + jsonMessage.message);
            webSocket.send(JSON.stringify(jsonMessage));
        """),format.raw/*127.9*/("""}"""),format.raw/*127.10*/(""" """),format.raw/*127.11*/("""else """),format.raw/*127.16*/("""{"""),format.raw/*127.17*/("""
            """),format.raw/*128.13*/("""consoleLog("Could not send data. Websocket is not open.");
        """),format.raw/*129.9*/("""}"""),format.raw/*129.10*/("""
    """),format.raw/*130.5*/("""}"""),format.raw/*130.6*/("""

    """),format.raw/*132.5*/("""</script>
""")))}),format.raw/*133.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-03-02T16:50:31.919
                  SOURCE: /root/BlackJack/app/views/index.scala.html
                  HASH: 5a55d45c09f1c3a788e80800d53fbc72ff2d6aec
                  MATRIX: 722->1|818->4|845->6|883->36|922->38|954->44|2654->1716|2683->1717|2719->1726|2990->1970|3018->1971|3051->1977|3102->2000|3131->2001|3167->2010|3223->2039|3251->2040|3284->2046|3336->2070|3365->2071|3401->2080|3516->2168|3544->2169|3577->2175|3629->2199|3658->2200|3694->2209|3816->2304|3844->2305|3877->2311|3931->2337|3960->2338|3996->2347|4313->2637|4341->2638|4374->2644|4453->2695|4482->2696|4518->2705|4639->2799|4667->2800|4700->2806|4779->2857|4808->2858|4844->2867|4971->2967|4999->2968|5032->2974|5089->3003|5118->3004|5154->3013|5224->3056|5252->3057|5285->3063|5401->3151|5430->3152|5466->3161|5641->3309|5669->3310|5826->3439|5855->3440|5891->3449|5938->3468|5967->3469|6008->3482|6098->3545|6127->3546|6159->3551|6187->3552|6478->3815|6507->3816|6544->3826|6822->4075|6852->4076|6894->4089|6944->4111|6974->4112|7012->4122|7196->4277|7226->4278|7268->4291|7326->4321|7356->4322|7473->4411|7502->4412|7536->4418|7655->4508|7685->4509|7722->4518|7794->4561|7824->4562|7866->4575|8003->4684|8033->4685|8063->4686|8097->4691|8127->4692|8169->4705|8264->4772|8294->4773|8327->4778|8356->4779|8390->4785|8432->4796
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|55->31|55->31|56->32|62->38|62->38|64->40|64->40|64->40|65->41|66->42|66->42|68->44|68->44|68->44|69->45|71->47|71->47|73->49|73->49|73->49|74->50|76->52|76->52|78->54|78->54|78->54|79->55|85->61|85->61|87->63|87->63|87->63|88->64|89->65|89->65|91->67|91->67|91->67|92->68|93->69|93->69|95->71|95->71|95->71|96->72|97->73|97->73|99->75|101->77|101->77|102->78|106->82|106->82|109->85|109->85|110->86|110->86|110->86|111->87|113->89|113->89|114->90|114->90|121->97|121->97|123->99|130->106|130->106|131->107|132->108|132->108|134->110|138->114|138->114|139->115|140->116|140->116|144->120|144->120|146->122|147->123|147->123|148->124|148->124|148->124|149->125|151->127|151->127|151->127|151->127|151->127|152->128|153->129|153->129|154->130|154->130|156->132|157->133
                  -- GENERATED --
              */
          