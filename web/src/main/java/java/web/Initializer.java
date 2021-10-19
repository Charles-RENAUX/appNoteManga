package java.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.core.config.AppConfig;
import java.core.config.DBConfig;
import java.web.config.WebConfig;

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
                "/welcome"
        };
        return servMap;
    }
}
