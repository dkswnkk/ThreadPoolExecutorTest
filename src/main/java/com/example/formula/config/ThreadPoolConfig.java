package com.example.formula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {

    @Bean(name = "threadPoolTaskExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(5);
        executor.setThreadNamePrefix("Executor-");

        /**
         * 스레드 풀의 모든 코어 스레드를 미리 시작합니다.
         * 기본 값은 false로, 따로 true로 설정하지 않을 시, 미리 스레드풀에 스레드를 생성해놓지 않습니다.
         */
        executor.setPrestartAllCoreThreads(true);

        executor.initialize();
        return executor;
    }
}
