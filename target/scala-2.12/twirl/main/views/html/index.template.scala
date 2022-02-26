
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
"""),_display_(/*3.2*/main("Play WebSockets 101")/*3.29*/ {_display_(Seq[Any](format.raw/*3.31*/("""

    """),format.raw/*5.5*/("""<h1 class="text-primary" style="font-size:24px;padding-bottom:1.5em;">Black Jack: <small>Hu Yue &amp; Hu Xuan</small></h1>
    <h6>IT5100A Final Project</h6>
    <p>Welcome to the Single-user BlackJack game!</p>
    <p>The game starts by dealing out two cards each to the player and dealer. A score of 21 wins the game for the player or dealer.</p>
    <p>In the event of a tie, the dealer wins. The user shall receive 100 coins at the beginning of the game.He can choose to bet any number of available coins at each hand. Once all the coins are exhausted, the game ends.The user can choose to "Hit" by entering a "H" when prompted. A "S" response would be assumed to be a "Stand".Good Luck!! </p>
    <h6 class="text-primary"> type in 'hi' to start the game </h2>
    <!-- this is where the client and server output will be shown/appended -->
    <div id="message-content" style="height:230px;overflow-y:auto !important;background-color:#fff;padding:1em;border-radius:10px;"></div>

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

    function init() """),format.raw/*28.21*/("""{"""),format.raw/*28.22*/("""
        """),format.raw/*29.9*/("""webSocket = new WebSocket("ws://localhost:9000/ws");
        webSocket.onopen = onOpen;
        webSocket.onclose = onClose;
        webSocket.onmessage = onMessage;
        webSocket.onerror = onError;
        $("#message-input").focus();
    """),format.raw/*35.5*/("""}"""),format.raw/*35.6*/("""

    """),format.raw/*37.5*/("""function onOpen(event) """),format.raw/*37.28*/("""{"""),format.raw/*37.29*/("""
        """),format.raw/*38.9*/("""consoleLog("CONNECTED");
    """),format.raw/*39.5*/("""}"""),format.raw/*39.6*/("""

    """),format.raw/*41.5*/("""function onClose(event) """),format.raw/*41.29*/("""{"""),format.raw/*41.30*/("""
        """),format.raw/*42.9*/("""consoleLog("DISCONNECTED");
        appendClientMessageToView(":", "DISCONNECTED");
    """),format.raw/*44.5*/("""}"""),format.raw/*44.6*/("""

    """),format.raw/*46.5*/("""function onError(event) """),format.raw/*46.29*/("""{"""),format.raw/*46.30*/("""
        """),format.raw/*47.9*/("""consoleLog("ERROR: " + event.data);
        consoleLog("ERROR: " + JSON.stringify(event));
    """),format.raw/*49.5*/("""}"""),format.raw/*49.6*/("""

    """),format.raw/*51.5*/("""function onMessage(event) """),format.raw/*51.31*/("""{"""),format.raw/*51.32*/("""
        """),format.raw/*52.9*/("""console.log(event.data);
        let receivedData = JSON.parse(event.data);
        console.log("New Data: ", receivedData);
        // get the text from the "body" field of the json we
        // receive from the server.
        appendServerMessageToView("Server", receivedData.body);
    """),format.raw/*58.5*/("""}"""),format.raw/*58.6*/("""

    """),format.raw/*60.5*/("""function appendClientMessageToView(title, message) """),format.raw/*60.56*/("""{"""),format.raw/*60.57*/("""
        """),format.raw/*61.9*/("""$("#message-content").append("<span>" + title + ": " + message + "<br /></span>");
    """),format.raw/*62.5*/("""}"""),format.raw/*62.6*/("""

    """),format.raw/*64.5*/("""function appendServerMessageToView(title, message) """),format.raw/*64.56*/("""{"""),format.raw/*64.57*/("""
        """),format.raw/*65.9*/("""$("#message-content").append("<span>" + title + ": " + message + "<br /><br /></span>");
    """),format.raw/*66.5*/("""}"""),format.raw/*66.6*/("""

    """),format.raw/*68.5*/("""function consoleLog(message) """),format.raw/*68.34*/("""{"""),format.raw/*68.35*/("""
        """),format.raw/*69.9*/("""console.log("New message: ", message);
    """),format.raw/*70.5*/("""}"""),format.raw/*70.6*/("""

    """),format.raw/*72.5*/("""window.addEventListener("load", init, false);

    $("#send-button").click(function (e) """),format.raw/*74.42*/("""{"""),format.raw/*74.43*/("""
        """),format.raw/*75.9*/("""console.log("Sending ...");
        getMessageAndSendToServer();
        // put focus back in the textarea
        $("#message-input").focus();
    """),format.raw/*79.5*/("""}"""),format.raw/*79.6*/(""");

    // send the message when the user presses the <enter> key while in the textarea
    $(window).on("keydown", function (e) """),format.raw/*82.42*/("""{"""),format.raw/*82.43*/("""
        """),format.raw/*83.9*/("""if (e.which == 13) """),format.raw/*83.28*/("""{"""),format.raw/*83.29*/("""
            """),format.raw/*84.13*/("""getMessageAndSendToServer();
            return false;
        """),format.raw/*86.9*/("""}"""),format.raw/*86.10*/("""
    """),format.raw/*87.5*/("""}"""),format.raw/*87.6*/(""");

    // there’s a lot going on here:
    // 1. get our message from the textarea.
    // 2. append that message to our view/div.
    // 3. create a json version of the message.
    // 4. send the message to the server.
    function getMessageAndSendToServer() """),format.raw/*94.42*/("""{"""),format.raw/*94.43*/("""

        """),format.raw/*96.9*/("""// get the text from the textarea
        messageInput = $("#message-input").val();

        // clear the textarea
        $("#message-input").val("");

        // if the trimmed message was blank, return now
        if ($.trim(messageInput) == "") """),format.raw/*103.41*/("""{"""),format.raw/*103.42*/("""
            """),format.raw/*104.13*/("""return false;
        """),format.raw/*105.9*/("""}"""),format.raw/*105.10*/("""

        """),format.raw/*107.9*/("""// add the message to the view/div
        appendClientMessageToView("Me", messageInput);

        // create the message as json
        let jsonMessage = """),format.raw/*111.27*/("""{"""),format.raw/*111.28*/("""
            """),format.raw/*112.13*/("""message: messageInput
        """),format.raw/*113.9*/("""}"""),format.raw/*113.10*/(""";

        // send our json message to the server
        sendToServer(jsonMessage);
    """),format.raw/*117.5*/("""}"""),format.raw/*117.6*/("""

    """),format.raw/*119.5*/("""// send the data to the server using the WebSocket
    function sendToServer(jsonMessage) """),format.raw/*120.40*/("""{"""),format.raw/*120.41*/("""
        """),format.raw/*121.9*/("""if(webSocket.readyState == WebSocket.OPEN) """),format.raw/*121.52*/("""{"""),format.raw/*121.53*/("""
            """),format.raw/*122.13*/("""consoleLog("SENT: " + jsonMessage.message);
            webSocket.send(JSON.stringify(jsonMessage));
        """),format.raw/*124.9*/("""}"""),format.raw/*124.10*/(""" """),format.raw/*124.11*/("""else """),format.raw/*124.16*/("""{"""),format.raw/*124.17*/("""
            """),format.raw/*125.13*/("""consoleLog("Could not send data. Websocket is not open.");
        """),format.raw/*126.9*/("""}"""),format.raw/*126.10*/("""
    """),format.raw/*127.5*/("""}"""),format.raw/*127.6*/("""

    """),format.raw/*129.5*/("""</script>
""")))}),format.raw/*130.2*/("""
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
                  DATE: 2022-02-26T14:07:45.700
                  SOURCE: /IT5100A_proj/PlayFrameworkScalaWebSockets/app/views/index.scala.html
                  HASH: 94adabe7ee48377294be5aa131a2f723a9d21768
                  MATRIX: 722->1|818->4|845->6|880->33|919->35|951->41|2426->1488|2455->1489|2491->1498|2762->1742|2790->1743|2823->1749|2874->1772|2903->1773|2939->1782|2995->1811|3023->1812|3056->1818|3108->1842|3137->1843|3173->1852|3288->1940|3316->1941|3349->1947|3401->1971|3430->1972|3466->1981|3588->2076|3616->2077|3649->2083|3703->2109|3732->2110|3768->2119|4085->2409|4113->2410|4146->2416|4225->2467|4254->2468|4290->2477|4404->2564|4432->2565|4465->2571|4544->2622|4573->2623|4609->2632|4729->2725|4757->2726|4790->2732|4847->2761|4876->2762|4912->2771|4982->2814|5010->2815|5043->2821|5159->2909|5188->2910|5224->2919|5399->3067|5427->3068|5584->3197|5613->3198|5649->3207|5696->3226|5725->3227|5766->3240|5856->3303|5885->3304|5917->3309|5945->3310|6236->3573|6265->3574|6302->3584|6580->3833|6610->3834|6652->3847|6702->3869|6732->3870|6770->3880|6954->4035|6984->4036|7026->4049|7084->4079|7114->4080|7231->4169|7260->4170|7294->4176|7413->4266|7443->4267|7480->4276|7552->4319|7582->4320|7624->4333|7761->4442|7791->4443|7821->4444|7855->4449|7885->4450|7927->4463|8022->4530|8052->4531|8085->4536|8114->4537|8148->4543|8190->4554
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|52->28|52->28|53->29|59->35|59->35|61->37|61->37|61->37|62->38|63->39|63->39|65->41|65->41|65->41|66->42|68->44|68->44|70->46|70->46|70->46|71->47|73->49|73->49|75->51|75->51|75->51|76->52|82->58|82->58|84->60|84->60|84->60|85->61|86->62|86->62|88->64|88->64|88->64|89->65|90->66|90->66|92->68|92->68|92->68|93->69|94->70|94->70|96->72|98->74|98->74|99->75|103->79|103->79|106->82|106->82|107->83|107->83|107->83|108->84|110->86|110->86|111->87|111->87|118->94|118->94|120->96|127->103|127->103|128->104|129->105|129->105|131->107|135->111|135->111|136->112|137->113|137->113|141->117|141->117|143->119|144->120|144->120|145->121|145->121|145->121|146->122|148->124|148->124|148->124|148->124|148->124|149->125|150->126|150->126|151->127|151->127|153->129|154->130
                  -- GENERATED --
              */
          