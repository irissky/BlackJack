// @GENERATOR:play-routes-compiler
// @SOURCE:/root/BlackJack/conf/routes
// @DATE:Wed Mar 02 16:45:13 SGT 2022

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  WebSocketsController_0: controllers.WebSocketsController,
  // @LINE:14
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    WebSocketsController_0: controllers.WebSocketsController,
    // @LINE:14
    Assets_1: controllers.Assets
  ) = this(errorHandler, WebSocketsController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, WebSocketsController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.WebSocketsController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws""", """controllers.WebSocketsController.ws"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_WebSocketsController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_WebSocketsController_index0_invoker = createInvoker(
    WebSocketsController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebSocketsController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ the page you get when you go to http://localhost:9000/""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_WebSocketsController_ws1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws")))
  )
  private[this] lazy val controllers_WebSocketsController_ws1_invoker = createInvoker(
    WebSocketsController_0.ws,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.WebSocketsController",
      "ws",
      Nil,
      "GET",
      this.prefix + """ws""",
      """ the websocket that will be used by that index page""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned2_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_WebSocketsController_index0_route(params@_) =>
      call { 
        controllers_WebSocketsController_index0_invoker.call(WebSocketsController_0.index)
      }
  
    // @LINE:10
    case controllers_WebSocketsController_ws1_route(params@_) =>
      call { 
        controllers_WebSocketsController_ws1_invoker.call(WebSocketsController_0.ws)
      }
  
    // @LINE:14
    case controllers_Assets_versioned2_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned2_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
