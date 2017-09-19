package org.kg.gv.ws.controller;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*ws protocol ó���� ��Ʈ�ѷ�
 * AbstractWebSocketHandler Ȥ��
 * TextWebSocketHandler
 */

public class BasicWsHandle extends TextWebSocketHandler {
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//super.afterConnectionEstablished(session);
		//Ŭ���̾�Ʈ���� ������ ������ �߻���.
		System.out.println("after");
		String msg="�ȳ�";
		session.sendMessage(new TextMessage(msg));
	}
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		//Ŭ���̾�Ʈ���� ���� ���� �Ǿ����� �߻�
		System.out.println("close");
	}
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		//Ŭ���̾�Ʈ�κ��� ���尡 �Ͼ����
		System.out.println("Message="+message.getPayload());
		session.sendMessage(new TextMessage(message.getPayload()));
	}
}
