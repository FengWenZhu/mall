package cn.com;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.CountDownLatch;

@EnableTransactionManagement
@EnableDubbo
@MapperScan("cn.com.mapper")
@ComponentScan("cn.com.*")
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class ContentServiceApplicationStarter {

    public static void main(String[] args) throws InterruptedException {
        new SpringApplicationBuilder()
                .sources(ContentServiceApplicationStarter.class)
                .web(WebApplicationType.NONE)
                .run(args);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}