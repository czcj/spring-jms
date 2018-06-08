package spittr.controller.websocketcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;
import spittr.pojo.Spitter;
import spittr.service.ActiveMqService;
import spittr.service.SpittrService;

import java.security.Principal;
import java.util.Map;

@Controller
public class StompController {
    @Autowired
    private SpittrService spittrService;
    @Autowired
    private ActiveMqService activeMqService;

    @MessageMapping("/marco")
    @SendTo("/queue/polo")
    public Spitter marco(Spitter spitter){
        System.out.println(spitter.getUsername());
        return spitter;
    }
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/say")
    public void say(Spitter spitter){
//        System.out.println(principal.getName());
//        activeMqService.longAcact();
        activeMqService.temAcAct();
//        simpMessagingTemplate.convertAndSend("/queue/"+spittrService.test().getId()+"/notify",spittrService.test());
//        simpMessagingTemplate.convertAndSendToUser("meng","/queue/notify",spittrService.test().getUsername());
    }
}
