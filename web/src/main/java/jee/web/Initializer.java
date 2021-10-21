package jee.web;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jee.core.config.AppConfig;
import jee.core.config.DBConfig;
import jee.web.config.WebConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        Class<?>[] rootConfigClass = new Class<?>[]{
                AppConfig.class,
                DBConfig.class
        };
        return rootConfigClass;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class<?>[] servletConfigClass = new Class<?>[]{
                WebConfig.class
        };
        return servletConfigClass;
    }

    @Override
    protected String[] getServletMappings() {
        String[] servMap = new String[]{
                "/"
        };
        return servMap;
    }
}
