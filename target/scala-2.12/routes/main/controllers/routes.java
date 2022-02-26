// @GENERATOR:play-routes-compiler
// @SOURCE:/IT5100A_proj/PlayFrameworkScalaWebSockets/conf/routes
// @DATE:Sat Feb 26 06:42:37 GMT 2022

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseWebSocketsController WebSocketsController = new controllers.ReverseWebSocketsController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseWebSocketsController WebSocketsController = new controllers.javascript.ReverseWebSocketsController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
