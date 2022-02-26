// @GENERATOR:play-routes-compiler
// @SOURCE:/IT5100A_proj/PlayFrameworkScalaWebSockets/conf/routes
// @DATE:Sat Feb 26 06:42:37 GMT 2022


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
