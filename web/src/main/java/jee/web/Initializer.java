package jee.web;

import jee.web.config.WSConfig;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jee.core.config.AppConfig;
import jee.core.config.DBConfig;
import jee.web.config.WebConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("cxfServlet", new CXFServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/api/*");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        Class<?>[] rootConfigClass = new Class<?>[]{
                AppConfig.class,
                DBConfig.class,
                WSConfig.class
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
