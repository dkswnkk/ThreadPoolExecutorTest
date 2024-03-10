package com.example.formula;

import com.example.formula.service.Run;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(ThreadPoolTest.class, args);

        Run run = context.getBean(Run.class);
        for (int i = 0; i < 20; i++) {
            run.start();

            // 적절한 시간 주면서 확인해볼 것
            Thread.sleep(3000);
        }
    }
}
