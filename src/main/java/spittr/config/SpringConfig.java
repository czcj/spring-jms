package spittr.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spittr.service.SpittrService;
import spittr.service.impl.SpittrServiceImpl;

@Configuration
//,WebSocketConfig.class
@Import({SpringjdbcConfig.class,WebSocketStompConfig.class})
@ImportResource("classpath:spring/messaging.xml")
//,"spittr.dao"
@ComponentScan(basePackages = {"spittr.service"})
public class SpringConfig {

}
