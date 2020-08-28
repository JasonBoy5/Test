package com.jason.web.socket.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class SystemWebSocketHandler implements WebSocketHandler {

	private static Timer timer;
	
	static {
		timer = new Timer();
    	timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
		        TextMessage txt = new TextMessage((new Date()).toString());
		    	sendMessageToUsers(txt);
			}}, 0, 5000);
	}
 
    private static final ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();;
 
 
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	System.out.println("ConnectionEstablished");
        users.add(session);
        System.out.println(session);
        System.out.println(session.getAttributes());
        TextMessage txt = new TextMessage(session.toString());
    	sendMessageToUsers(txt);

    }
 
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    	System.out.println("session:"+session.toString());
    	System.out.println("the size of message:"+message.getPayloadLength());
    	System.out.println("message:"+message.getPayload());
    	System.out.println("message:"+message);
    	TextMessage txt = new TextMessage("news test");
    	sendMessageToUsers(txt);
    }
 
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if(session.isOpen()){
            session.close();
        }
        users.remove(session);
        System.out.println("TransportError");
        System.out.println(session);
        System.out.println(session.getAttributes());
    }
 
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        users.remove(session);
        System.out.println("ConnectionClosed");
        System.out.println(session);
        System.out.println(session.getAttributes());
    }
 
    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
 
    /**
     * 
     *
     * @param message
     */
    public static void sendMessageToUsers(TextMessage message) {
        for (WebSocketSession user : users) {
            try {
                if (user.isOpen()) {
                    user.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
}
