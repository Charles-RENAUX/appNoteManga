package java.web.config;

import com.shieldsolutions.velocity.view.VelocityConfigurer;
import com.shieldsolutions.velocity.view.VelocityViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "java.web.controller")
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }

    @Bean
    public VelocityConfigurer velocityConfigurer(){
        VelocityConfigurer velConf = new VelocityConfigurer();
        velConf.setResourceLoaderPath("/WEB-INF/velocity");
        return velConf;
    }

    @Bean
    public VelocityViewResolver velocityViewResolver(){
        VelocityViewResolver velVRes = new VelocityViewResolver();
        velVRes.setSuffix(".vm");
        return velVRes;
    }
}
