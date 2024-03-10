package com.example.formula.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@DependsOn("threadPoolTaskExecutor")
public class Run {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Async(value = "threadPoolTaskExecutor")
    public void start() throws InterruptedException {
        // 스레드 풀의 현재 스레드 수
        int poolSize = threadPoolTaskExecutor.getPoolSize();
        // 현재 활성 스레드 수
        int activeCount = threadPoolTaskExecutor.getActiveCount();
        // 작업 큐의 남은 용량
        int remainingCapacity = threadPoolTaskExecutor.getThreadPoolExecutor().getQueue().remainingCapacity();
        // 현재 작업 큐에 대기 중인 작업 수
        int queueSize = threadPoolTaskExecutor.getThreadPoolExecutor().getQueue().size();

        log.info("현재 스레드 이름: {}, 현재 스레드 풀의 스레드 수: {} 현재 활성 스레드 수: {}, 현재 작업 큐에 대기 중인 작업 수: {}, 작업 큐의 남은 크기: {}",
                Thread.currentThread().getName(), poolSize, activeCount, queueSize, remainingCapacity);

        // 적절한 시간 주면서 확인해볼 것
        Thread.sleep(1000);
    }

    public void checkPrestartedThreads() {
        // 스레드 풀의 현재 스레드 수를 확인합니다.
        int poolSize = threadPoolTaskExecutor.getPoolSize();

        log.info("스레드 풀의 현재 스레드 수: {}", poolSize);
    }
}
