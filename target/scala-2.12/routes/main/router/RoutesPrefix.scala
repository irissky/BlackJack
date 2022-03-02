// @GENERATOR:play-routes-compiler
// @SOURCE:/root/BlackJack/conf/routes
// @DATE:Wed Mar 02 16:45:13 SGT 2022


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
