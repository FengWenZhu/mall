package cn.com;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableDubbo()
@MapperScan("cn.com.mapper")
@ComponentScan("cn.com.*")
@SpringBootApplication
@EnableScheduling
@EnableAsync
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