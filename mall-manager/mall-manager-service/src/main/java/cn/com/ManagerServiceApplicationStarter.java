package cn.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("cn.com.mapper")
@ComponentScan("cn.com.*")
@SpringBootApplication
public class ManagerServiceApplicationStarter {

    public static void main(String[] args) throws InterruptedException {
        /*new SpringApplicationBuilder()
                .sources(ManagerServiceApplicationStarter.class)
                .web(WebApplicationType.NONE)
                .run(args);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();*/
        SpringApplication.run(ManagerServiceApplicationStarter.class, args);
    }
}