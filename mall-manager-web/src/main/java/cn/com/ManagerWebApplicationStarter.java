package cn.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan("cn.com.*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@PropertySource("classpath:conf/conf.properties")
@EnableScheduling
@EnableAsync
public class ManagerWebApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ManagerWebApplicationStarter.class, args);
    }
}
