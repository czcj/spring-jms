package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import java.io.IOException;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"spittr.controller.webmvccontroller"})
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

    //jsp试图解析器
    @Bean
    public ViewResolver jspViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setOrder(1);
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }
    //Thymeleaf试图解析器
    @Bean
    public TemplateResolver templateResolver(){
        ServletContextTemplateResolver servletContextTemplateResolver = new ServletContextTemplateResolver();
        servletContextTemplateResolver.setPrefix("/WEB-INF/html/");
        servletContextTemplateResolver.setSuffix(".html");
        servletContextTemplateResolver.setTemplateMode("HTML5");
        servletContextTemplateResolver.setCacheable(false);
//        servletContextTemplateResolver.setOrder(0);
        return servletContextTemplateResolver;
    }
    @Bean
    public SpringTemplateEngine templateEngine(TemplateResolver templateResolver){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
    @Bean
    public ViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine){
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine);
//        thymeleafViewResolver.setCache(false);
        thymeleafViewResolver.setOrder(0);
        return thymeleafViewResolver;
    }

    //配置静态资源
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //配置文件上传解析器，具体规则配置在初始化contextloadelistener配置文件中
    @Bean
    public MultipartResolver multipartResolver() throws IOException{
        return new StandardServletMultipartResolver();
    }
}
