package spittr.handle;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

public class MarcoSockJsHandle extends AbstractWebSocketHandler {

    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("accept:" + message.getPayload());
        Thread.sleep(2000);
        session.sendMessage(new TextMessage("sockjs service"));
    }
}
