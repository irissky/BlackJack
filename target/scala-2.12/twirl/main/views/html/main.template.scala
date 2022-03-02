
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*14.54*/routes/*14.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*14.101*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*15.54*/routes/*15.60*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*15.110*/("""">
        <link rel="shortcut icon" type="image/ico" href=""""),_display_(/*16.59*/routes/*16.65*/.Assets.versioned("images/favicon.ico")),format.raw/*16.104*/("""">
        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Arvo:400,700|Lato">
        <link rel="stylesheet" type="text/css" href=""""),_display_(/*22.55*/routes/*22.61*/.Assets.versioned("stylesheets/style.css")),format.raw/*22.103*/("""">
        <title>"""),_display_(/*23.17*/title),format.raw/*23.22*/("""</title>
    </head>
    <body class="container" style="padding-top:3em;width:60%;background-color:#e9e9e9;">
        """),_display_(/*26.10*/content),format.raw/*26.17*/("""
        """),format.raw/*27.9*/("""<script src=""""),_display_(/*27.23*/routes/*27.29*/.Assets.versioned("javascripts/main.js")),format.raw/*27.69*/("""" type="text/javascript"></script>
    </body>
</html>




"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-03-02T18:48:05.323
                  SOURCE: /root/BlackJack/app/views/main.scala.html
                  HASH: f3e4621488e6959631310a8665db870867fb85c9
                  MATRIX: 987->260|1111->291|1138->292|1388->515|1403->521|1466->562|1549->618|1564->624|1636->674|1724->735|1739->741|1800->780|2438->1391|2453->1397|2517->1439|2563->1458|2589->1463|2735->1582|2763->1589|2799->1598|2840->1612|2855->1618|2916->1658
                  LINES: 26->7|31->8|32->9|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|45->22|45->22|45->22|46->23|46->23|49->26|49->26|50->27|50->27|50->27|50->27
                  -- GENERATED --
              */
          