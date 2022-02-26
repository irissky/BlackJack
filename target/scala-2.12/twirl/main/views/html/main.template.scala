
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
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*16.59*/routes/*16.65*/.Assets.versioned("images/favicon.png")),format.raw/*16.104*/("""">
        <title>"""),_display_(/*17.17*/title),format.raw/*17.22*/("""</title>
    </head>
    <body class="container" style="padding-top:3em;width:60%;background-color:#e9e9e9;">
        """),_display_(/*20.10*/content),format.raw/*20.17*/("""
        """),format.raw/*21.9*/("""<script src=""""),_display_(/*21.23*/routes/*21.29*/.Assets.versioned("javascripts/main.js")),format.raw/*21.69*/("""" type="text/javascript"></script>
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
                  DATE: 2022-02-26T06:42:38.025
                  SOURCE: /IT5100A_proj/PlayFrameworkScalaWebSockets/app/views/main.scala.html
                  HASH: 7ee12ecda23c56515377f5284fae628676398680
                  MATRIX: 987->260|1111->291|1138->292|1388->515|1403->521|1466->562|1549->618|1564->624|1636->674|1724->735|1739->741|1800->780|1846->799|1872->804|2018->923|2046->930|2082->939|2123->953|2138->959|2199->999
                  LINES: 26->7|31->8|32->9|37->14|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|40->17|40->17|43->20|43->20|44->21|44->21|44->21|44->21
                  -- GENERATED --
              */
          