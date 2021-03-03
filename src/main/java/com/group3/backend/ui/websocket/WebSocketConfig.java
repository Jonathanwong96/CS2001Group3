//package com.group3.backend.ui.websocket;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		registry.addHandler(new SocketTextHandler(), "/email");
//	}
//
//}


//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//	//this didn't work
////	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
////		registry.addHandler(new SocketTextHandler(), "/email");
////	}
//	
//	  @Override
//	  public void registerStompEndpoints(StompEndpointRegistry registry) {
//	    registry.addEndpoint("/mywebsockets").setAllowedOrigins("localhost").withSockJS();
//	    registry.addEndpoint("/mywebsockets").withSockJS();
//	    registry.addEndpoint("/mywebsockets").setAllowedOrigins("*").withSockJS();
//	  }
//
//	  @Override
//	  public void configureMessageBroker(MessageBrokerRegistry config){ 
//	    config.enableSimpleBroker("/topic/", "/queue/");
//	    config.setApplicationDestinationPrefixes("/app");
//	  }
//
//}