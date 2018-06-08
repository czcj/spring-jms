package spittr.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class Application extends AbstractAnnotationConfigDispatcherServletInitializer {
    //ContextLoaderListener创建spring上下文
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringConfig.class};
    }
    //springmvc 的spring上下文也就是springmvc容器
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{SpringMvcConfig.class};
    }

    //DispatcherServletl映射路径“/”
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //因为DispatcherServlet不是直接通过Servlet初始化类的方式进行配置，所以不会有对Dynamic Servlet registration的引用供我们使用
    //所以我们通过重载customizeRegistration方法来获得这个引用，使用这个引用来配置multipart的具体细节
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //上传文件临时写入目录地址，上传文件大小限制2M，整个请求大小不超过4M，所有文件都要写入磁盘
        MultipartConfigElement multipartConfigElement =
//                new MultipartConfigElement("/tmp/spittr/uploads",2097152,4194304,0);
                new MultipartConfigElement("/",2097152,4194304,0);


        registration.setMultipartConfig(multipartConfigElement);
    }
}
