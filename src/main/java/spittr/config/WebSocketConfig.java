package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import spittr.handle.MarcoSockJsHandle;
import spittr.handle.MarcoWebSocketHandle;

@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(marcoWebSocketHandle(),"/marcoByWebSocket");
        webSocketHandlerRegistry.addHandler(marcoSockJsHandle(),"/marcoBySockJs").withSockJS();
    }
    @Bean
    public MarcoWebSocketHandle marcoWebSocketHandle(){
        return new MarcoWebSocketHandle();
    }
    @Bean
    public MarcoSockJsHandle marcoSockJsHandle(){
        return new MarcoSockJsHandle();
    }
}
