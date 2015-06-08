package ru.maven.spitter.config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ru.maven.spitter.config.security.SpringSecurityGlobalConfiguration;

@Configuration
@EnableWebMvc
@ComponentScan("ru.maven.spitter")
@EnableTransactionManagement
@ImportResource({"WEB-INF/spring/appServlet/servlet-context.xml"})
@Import(SpringSecurityGlobalConfiguration.class)
public class WebConfig {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
    
}
