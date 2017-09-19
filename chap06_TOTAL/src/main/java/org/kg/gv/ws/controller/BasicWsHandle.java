package org.kg.gv.ws.controller;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*ws protocol 처리용 컨트롤러
 * AbstractWebSocketHandler 혹은
 * TextWebSocketHandler
 */

public class BasicWsHandle extends TextWebSocketHandler {
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//super.afterConnectionEstablished(session);
		//클라이언트에서 연결을 했을때 발생함.
		System.out.println("after");
		String msg="안녕";
		session.sendMessage(new TextMessage(msg));
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//클라이언트에서 접속 해제 되었을떄 발생
		System.out.println("close");
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//클라이언트로부터 센드가 일어났을때
		System.out.println("Message="+message.getPayload());
		session.sendMessage(new TextMessage(message.getPayload()));
	}
}
