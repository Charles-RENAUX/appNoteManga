package jee.core.config;


import ch.qos.logback.classic.Level;
import com.zaxxer.hikari.HikariConfig;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "jee.core")
public class AppConfig {

    public static final String DB_HOST = "localhost:3306";

    public static final String DB_SCHEMA = "projet_JEE";

    public static final String DB_USER = "root";

    public static final String DB_PASSWORD = "root";


    @Bean
    public HikariConfig dbConfiguration(){
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
        logger.setLevel(Level.toLevel("info"));

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://" + DB_HOST + "/" + DB_SCHEMA + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC");
        config.setUsername(DB_USER);
        config.setPassword(DB_PASSWORD);
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return config;
    }

}
