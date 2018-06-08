package spittr.service.impl;

import org.springframework.stereotype.Service;
import spittr.service.AlertService;

@Service
public class AlertServiceImpl implements AlertService {
    public void sendMessage(String message){
        System.out.println(message);
    }
}
