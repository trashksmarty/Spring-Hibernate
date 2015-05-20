package ru.maven.spitter.config.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("ru.maven.spitter")
@EnableTransactionManagement
@ImportResource({"WEB-INF/spring/appServlet/servlet-context.xml"})
public class WebConfig {

    //Отображение представления.
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/view/");
//        resolver.setSuffix(".jsp");
//        resolver.setViewClass(JstlView.class);//JSTL. Поддержка интернационализации
//        return resolver;
//    }
    
}
