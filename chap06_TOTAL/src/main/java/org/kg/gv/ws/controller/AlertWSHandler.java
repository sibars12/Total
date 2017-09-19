package org.kg.gv.ws.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
@Component("aws")
public class AlertWSHandler extends TextWebSocketHandler{
	List<WebSocketSession> list=new ArrayList<WebSocketSession>();
	
	public void sendMessage(String message) {
		for(WebSocketSession s : list) {
			try {
				s.sendMessage(new TextMessage(message));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		list.remove(session);
		String json = String.format("현재 접속 인원수 %d", list.size());
		for (WebSocketSession wss : list) {
			wss.sendMessage(new TextMessage(json));
		}
	}
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		String json = String.format("현재 접속 인원수 %d", list.size());
		for (WebSocketSession wss : list) {
			wss.sendMessage(new TextMessage(json));
		}
	}
		
}
