package ru.maven.spitter.config.app;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Наш DispatcherServlet
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    /**
     * "/" Является сервлетом по умолчанию, отвечающим за обработку всех
     * запросов, включая запросы на получение статического содержимого.
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //Настройка обработки сервлетом кодировки UTF-8
    @Override
    protected Filter[] getServletFilters() {

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[]{characterEncodingFilter};
    }
}
