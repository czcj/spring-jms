package spittr.service.impl;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import spittr.service.ActiveMqService;

import javax.jms.*;

@Service
public class ActiveMqServiceImpl implements ActiveMqService {

    @Autowired
    private JmsOperations jmsOperations;

    public void temAcAct(){
        try {
            TextMessage message = (TextMessage)jmsOperations.receive();
            simpMessagingTemplate.convertAndSend("/queue"+"/notify",message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }




    public void longAcsend() {
        ConnectionFactory cf =
                new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try {
            conn = cf.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination =
                    new ActiveMQQueue("spitter.queue");
            MessageProducer producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();
            textMessage.setText("Hello world!");
            producer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
@Autowired
private SimpMessagingTemplate simpMessagingTemplate;
    public void longAcact(){
        ActiveMQConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        while(true){
            try {
                conn = connFactory.createConnection();
                session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = new ActiveMQQueue("spitter.queue");
                MessageConsumer consumer = session.createConsumer(destination);
                conn.start();
                Message message = consumer.receive();
                simpMessagingTemplate.convertAndSend("/queue"+"/notify",((TextMessage)message).getText());
                System.out.println(((TextMessage)message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(session != null){
                        session.close();
                    }
                    if(conn != null){
                        conn.close();
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
