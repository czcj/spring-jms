package spittr.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class jmsHandle {
    @Autowired
    private JmsOperations jmsOperations;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void temAcAct(String resultmessage){
        simpMessagingTemplate.convertAndSend("/queue"+"/notify",resultmessage);
    }
}
