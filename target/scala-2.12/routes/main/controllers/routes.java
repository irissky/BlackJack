// @GENERATOR:play-routes-compiler
// @SOURCE:/root/BlackJack/conf/routes
// @DATE:Wed Mar 02 16:45:13 SGT 2022

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
