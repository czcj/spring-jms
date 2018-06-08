package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan("spittr.controller.websocketcontroller")
public class WebSocketStompConfig extends AbstractWebSocketMessageBrokerConfigurer {

    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        stompEndpointRegistry.addEndpoint("/stomp").withSockJS();
        stompEndpointRegistry.addEndpoint("/marcopolo").withSockJS();
    }
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //简单代理，内存方式
        registry.enableSimpleBroker("/queue","/topic");
        //STOMP代理，集群模式需要
        /**
         * 默认消息代理监听端口为61613，用户名和密码为guest
         */
//        registry.enableStompBrokerRelay("/queue","/topic");
//        registry.enableStompBrokerRelay("/queue","topic")
//                .setRelayHost("http:rabbit.someotherserver")
//                .setRelayPort(61613)
//                .setClientLogin("username")
//                .setClientPasscode("password");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
