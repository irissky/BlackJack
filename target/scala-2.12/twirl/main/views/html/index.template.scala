
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

    """),format.raw/*5.5*/("""<h1>The Game of Twenty-One</h1>
    <h5>by Hu Yue &amp; Hu Xuan</h5>
    <h6>IT5100A Final Project</h6>
    <div id="rules">
        <p>Welcome to the single-user game of 21 (also called Blackjack)!</p>
        <p>The game starts by dealing out two cards each to the player and dealer. A score of 21 wins the game for the player or dealer.</p>
        <p>In the event of a tie, the dealer wins. The user shall receive 100 coins at the beginning of the game.He can choose to bet any number of available coins at each hand. Once all the coins are exhausted, the game ends.The user can choose to "Hit" by entering a "H" when prompted. A "S" response would be assumed to be a "Stand".Good Luck!! </p>
    </div>
    <div class="container" id="content-container">
        <div id="item-1">
            <img src=""""),_display_(/*15.24*/routes/*15.30*/.Assets.versioned("images/dealer.png")),format.raw/*15.68*/("""">
        </div>
        <div id="item-2">
            <div id="message-content"></div>
        </div>
        <div id="item-3">
            <form>
                <textarea id="message-input" class="form-control" placeholder="type in 'hi' to start/restart the game"></textarea>
                <div id="div-send-button">
                    <button id="send-button" type="button" class="btn btn-primary">Send</button> 
                </div> 
            </form>
        </div>
        <div id="item-4">
            <img src=""""),_display_(/*29.24*/routes/*29.30*/.Assets.versioned("images/player.png")),format.raw/*29.68*/("""">
        </div>
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <script>
    var webSocket;
    var messageInput;

    function init() """),format.raw/*41.21*/("""{"""),format.raw/*41.22*/("""
        """),format.raw/*42.9*/("""webSocket = new WebSocket("ws://localhost:9000/ws");
        webSocket.onopen = onOpen;
        webSocket.onclose = onClose;
        webSocket.onmessage = onMessage;
        webSocket.onerror = onError;
        $("#message-input").focus();
    """),format.raw/*48.5*/("""}"""),format.raw/*48.6*/("""

    """),format.raw/*50.5*/("""function onOpen(event) """),format.raw/*50.28*/("""{"""),format.raw/*50.29*/("""
        """),format.raw/*51.9*/("""consoleLog("CONNECTED");
    """),format.raw/*52.5*/("""}"""),format.raw/*52.6*/("""

    """),format.raw/*54.5*/("""function onClose(event) """),format.raw/*54.29*/("""{"""),format.raw/*54.30*/("""
        """),format.raw/*55.9*/("""consoleLog("DISCONNECTED");
        appendClientMessageToView(":", "DISCONNECTED");
    """),format.raw/*57.5*/("""}"""),format.raw/*57.6*/("""

    """),format.raw/*59.5*/("""function onError(event) """),format.raw/*59.29*/("""{"""),format.raw/*59.30*/("""
        """),format.raw/*60.9*/("""consoleLog("ERROR: " + event.data);
        consoleLog("ERROR: " + JSON.stringify(event));
    """),format.raw/*62.5*/("""}"""),format.raw/*62.6*/("""

    """),format.raw/*64.5*/("""function onMessage(event) """),format.raw/*64.31*/("""{"""),format.raw/*64.32*/("""
        """),format.raw/*65.9*/("""console.log(event.data);
        let receivedData = JSON.parse(event.data);
        console.log("New Data: ", receivedData);
        // get the text from the "body" field of the json we
        // receive from the server.
        appendServerMessageToView("Server", receivedData.body);
    """),format.raw/*71.5*/("""}"""),format.raw/*71.6*/("""

    """),format.raw/*73.5*/("""function appendClientMessageToView(title, message) """),format.raw/*73.56*/("""{"""),format.raw/*73.57*/("""
        """),format.raw/*74.9*/("""$("#message-content").append("<div class='server-message'>" + message + "◀︎</div>");
    """),format.raw/*75.5*/("""}"""),format.raw/*75.6*/("""

    """),format.raw/*77.5*/("""function appendServerMessageToView(title, message) """),format.raw/*77.56*/("""{"""),format.raw/*77.57*/("""
        """),format.raw/*78.9*/("""$("#message-content").append("<div class='client-message'>►" + message + "</div>");
    """),format.raw/*79.5*/("""}"""),format.raw/*79.6*/("""

    """),format.raw/*81.5*/("""function consoleLog(message) """),format.raw/*81.34*/("""{"""),format.raw/*81.35*/("""
        """),format.raw/*82.9*/("""console.log("New message: ", message);
    """),format.raw/*83.5*/("""}"""),format.raw/*83.6*/("""

    """),format.raw/*85.5*/("""window.addEventListener("load", init, false);

    $("#send-button").click(function (e) """),format.raw/*87.42*/("""{"""),format.raw/*87.43*/("""
        """),format.raw/*88.9*/("""console.log("Sending ...");
        getMessageAndSendToServer();
        // put focus back in the textarea
        $("#message-input").focus();
    """),format.raw/*92.5*/("""}"""),format.raw/*92.6*/(""");

    // send the message when the user presses the <enter> key while in the textarea
    $(window).on("keydown", function (e) """),format.raw/*95.42*/("""{"""),format.raw/*95.43*/("""
        """),format.raw/*96.9*/("""if (e.which == 13) """),format.raw/*96.28*/("""{"""),format.raw/*96.29*/("""
            """),format.raw/*97.13*/("""getMessageAndSendToServer();
            return false;
        """),format.raw/*99.9*/("""}"""),format.raw/*99.10*/("""
    """),format.raw/*100.5*/("""}"""),format.raw/*100.6*/(""");

    // there’s a lot going on here:
    // 1. get our message from the textarea.
    // 2. append that message to our view/div.
    // 3. create a json version of the message.
    // 4. send the message to the server.
    function getMessageAndSendToServer() """),format.raw/*107.42*/("""{"""),format.raw/*107.43*/("""

        """),format.raw/*109.9*/("""// get the text from the textarea
        messageInput = $("#message-input").val();

        // clear the textarea
        $("#message-input").val("");

        // if the trimmed message was blank, return now
        if ($.trim(messageInput) == "") """),format.raw/*116.41*/("""{"""),format.raw/*116.42*/("""
            """),format.raw/*117.13*/("""return false;
        """),format.raw/*118.9*/("""}"""),format.raw/*118.10*/("""

        """),format.raw/*120.9*/("""// add the message to the view/div
        appendClientMessageToView("Me", messageInput);

        // create the message as json
        let jsonMessage = """),format.raw/*124.27*/("""{"""),format.raw/*124.28*/("""
            """),format.raw/*125.13*/("""message: messageInput
        """),format.raw/*126.9*/("""}"""),format.raw/*126.10*/(""";

        // send our json message to the server
        sendToServer(jsonMessage);
    """),format.raw/*130.5*/("""}"""),format.raw/*130.6*/("""

    """),format.raw/*132.5*/("""// send the data to the server using the WebSocket
    function sendToServer(jsonMessage) """),format.raw/*133.40*/("""{"""),format.raw/*133.41*/("""
        """),format.raw/*134.9*/("""if(webSocket.readyState == WebSocket.OPEN) """),format.raw/*134.52*/("""{"""),format.raw/*134.53*/("""
            """),format.raw/*135.13*/("""consoleLog("SENT: " + jsonMessage.message);
            webSocket.send(JSON.stringify(jsonMessage));
        """),format.raw/*137.9*/("""}"""),format.raw/*137.10*/(""" """),format.raw/*137.11*/("""else """),format.raw/*137.16*/("""{"""),format.raw/*137.17*/("""
            """),format.raw/*138.13*/("""consoleLog("Could not send data. Websocket is not open.");
        """),format.raw/*139.9*/("""}"""),format.raw/*139.10*/("""
    """),format.raw/*140.5*/("""}"""),format.raw/*140.6*/("""

    """),format.raw/*142.5*/("""</script>
""")))}),format.raw/*143.2*/("""
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
                  DATE: 2022-03-02T21:23:07.564
                  SOURCE: /root/BlackJack/app/views/index.scala.html
                  HASH: 7c9bde06be37d19c45bc91161f2e5186b27ea197
                  MATRIX: 722->1|818->4|845->6|883->36|922->38|954->44|1789->852|1804->858|1863->896|2419->1425|2434->1431|2493->1469|2715->1663|2744->1664|2780->1673|3051->1917|3079->1918|3112->1924|3163->1947|3192->1948|3228->1957|3284->1986|3312->1987|3345->1993|3397->2017|3426->2018|3462->2027|3577->2115|3605->2116|3638->2122|3690->2146|3719->2147|3755->2156|3877->2251|3905->2252|3938->2258|3992->2284|4021->2285|4057->2294|4374->2584|4402->2585|4435->2591|4514->2642|4543->2643|4579->2652|4695->2741|4723->2742|4756->2748|4835->2799|4864->2800|4900->2809|5015->2897|5043->2898|5076->2904|5133->2933|5162->2934|5198->2943|5268->2986|5296->2987|5329->2993|5445->3081|5474->3082|5510->3091|5685->3239|5713->3240|5870->3369|5899->3370|5935->3379|5982->3398|6011->3399|6052->3412|6142->3475|6171->3476|6204->3481|6233->3482|6525->3745|6555->3746|6593->3756|6871->4005|6901->4006|6943->4019|6993->4041|7023->4042|7061->4052|7245->4207|7275->4208|7317->4221|7375->4251|7405->4252|7522->4341|7551->4342|7585->4348|7704->4438|7734->4439|7771->4448|7843->4491|7873->4492|7915->4505|8052->4614|8082->4615|8112->4616|8146->4621|8176->4622|8218->4635|8313->4702|8343->4703|8376->4708|8405->4709|8439->4715|8481->4726
                  LINES: 21->1|26->2|27->3|27->3|27->3|29->5|39->15|39->15|39->15|53->29|53->29|53->29|65->41|65->41|66->42|72->48|72->48|74->50|74->50|74->50|75->51|76->52|76->52|78->54|78->54|78->54|79->55|81->57|81->57|83->59|83->59|83->59|84->60|86->62|86->62|88->64|88->64|88->64|89->65|95->71|95->71|97->73|97->73|97->73|98->74|99->75|99->75|101->77|101->77|101->77|102->78|103->79|103->79|105->81|105->81|105->81|106->82|107->83|107->83|109->85|111->87|111->87|112->88|116->92|116->92|119->95|119->95|120->96|120->96|120->96|121->97|123->99|123->99|124->100|124->100|131->107|131->107|133->109|140->116|140->116|141->117|142->118|142->118|144->120|148->124|148->124|149->125|150->126|150->126|154->130|154->130|156->132|157->133|157->133|158->134|158->134|158->134|159->135|161->137|161->137|161->137|161->137|161->137|162->138|163->139|163->139|164->140|164->140|166->142|167->143
                  -- GENERATED --
              */
          