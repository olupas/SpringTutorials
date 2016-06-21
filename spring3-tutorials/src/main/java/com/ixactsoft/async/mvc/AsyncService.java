package com.ixactsoft.async.mvc;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @author Ovidiu Lupas
 */
@Component
public class AsyncService {

    private final static Logger LOGGER = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public Future<Long> callAsync(int taskCall) throws InterruptedException {

        Stopwatch stopwatch = Stopwatch.createStarted();
        LOGGER.info("task " + taskCall + " starting");
        Thread.sleep(500);
        stopwatch.elapsed(TimeUnit.MILLISECONDS);
        LOGGER.info("task " + taskCall + " completed in " + stopwatch);
        return new AsyncResult<Long>(stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Async
    //executed on Spring default async executor - SimpleAsyncTaskExecutor
    public void asyncMethod() {
        LOGGER.info("Execute method asynchronously. " + Thread.currentThread().getName());
    }

    @Async("threadPoolTaskExecutor")
    //executed on configured executor - SimpleAsyncTaskExecutor
    public void asyncMethodConfiguredExecutor() {
        LOGGER.info("Execute method asynchronously. " + Thread.currentThread().getName());
    }

}