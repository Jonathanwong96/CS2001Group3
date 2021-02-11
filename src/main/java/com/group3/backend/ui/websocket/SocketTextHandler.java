//package com.group3.backend.ui.websocket;
//
//import java.io.IOException;
//
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//@Component
//public class SocketTextHandler extends TextWebSocketHandler {
//
//	@Override
//	public void handleTextMessage(WebSocketSession session, TextMessage message)
//			throws InterruptedException, IOException {
//
//		String payload = message.getPayload();
//		session.sendMessage(new TextMessage("Hi " + payload));
//	}
//
//}