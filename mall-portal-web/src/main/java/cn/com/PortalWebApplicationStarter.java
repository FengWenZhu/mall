package cn.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@PropertySource("classpath:conf/conf.properties")
@EnableScheduling
@EnableAsync
public class PortalWebApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(PortalWebApplicationStarter.class, args);
    }
}
