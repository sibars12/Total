package org.kg.gv.ws.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component("cws")
public class ChatWsHandler extends TextWebSocketHandler {
	List<WebSocketSession> list;
	@Autowired
	ObjectMapper mapper;
	@PostConstruct
	public void chatWSInit() {
		System.out.println("chatHandler init!");
		list = new ArrayList<WebSocketSession>();
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		list.remove(session);
		String json = String.format("{\"mode\":\"cnt\", \"cnt\":%d }", list.size());
		for (WebSocketSession wss : list) {
			wss.sendMessage(new TextMessage(json));
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		list.add(session);
		String json = String.format("{\"mode\": \"cnt\", \"cnt\":%d }", list.size());
		for (WebSocketSession wss : list) {
			wss.sendMessage(new TextMessage(json));
		}
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		Map map = new HashMap();
		String id = session.getId(); // httpsession id는 아니고 자동으로 1씩 증가
		String m = message.getPayload();
		map.put("mode" , "chat");
		map.put("sender", "사용자" + id);
		map.put("msg", m);
		String json = mapper.writeValueAsString(map);
		System.out.println(json);
		for (WebSocketSession wss : list) {
			wss.sendMessage(new TextMessage(json));
		}

	}
}
