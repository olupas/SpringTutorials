package com.ixactsoft.async.mvc;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import com.ixactsoft.async.github.GitHubLookupService;
import com.ixactsoft.async.github.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Ovidiu Lupas
 */
@Controller
public class RestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private GitHubLookupService gitHubLookupService;

    @RequestMapping(value = "/taskExecutor", produces = { MediaType.TEXT_HTML_VALUE }, method = RequestMethod.GET)
    @ResponseBody
    public String taskExecutor() throws InterruptedException, ExecutionException {

        Stopwatch stopwatch = Stopwatch.createStarted();

        Future<Long> asyncResult1 = asyncService.callAsync(1);
        Future<Long> asyncResult2 = asyncService.callAsync(2);
        Future<Long> asyncResult3 = asyncService.callAsync(3);
        Future<Long> asyncResult4 = asyncService.callAsync(4);

        LOGGER.info("result 1 took: " + asyncResult1.get());
        LOGGER.info("result 2 took: " + asyncResult2.get());
        LOGGER.info("result 3 took: " + asyncResult3.get());
        LOGGER.info("result 4 took: " + asyncResult4.get());

        stopwatch.elapsed(TimeUnit.MILLISECONDS);

        return "time it took to perform work " + stopwatch;
    }

    @RequestMapping(value = "/sleep", produces = { MediaType.TEXT_HTML_VALUE }, method = RequestMethod.GET)
    @ResponseBody
    public String sleep() throws InterruptedException, ExecutionException {

        Stopwatch stopwatch = Stopwatch.createStarted();

        CompletableFuture asyncResult1 = asyncService.sleep();
        LOGGER.info("Sleep result is: " + asyncResult1.get());
        stopwatch.elapsed(TimeUnit.MILLISECONDS);

        return "time it took to perform work " + stopwatch;
    }

    @RequestMapping(value = "/api", produces = { MediaType.TEXT_HTML_VALUE }, method = RequestMethod.GET)
    @ResponseBody
    public String asyncAPI() {
        LOGGER.info("Starting sync api calls");
        Stopwatch stopwatch = Stopwatch.createStarted();

        // called on default executor
        asyncService.asyncMethod();
        // called on configured executor
        asyncService.asyncMethodConfiguredExecutor();

        stopwatch.elapsed(TimeUnit.MILLISECONDS);

        return "time it took to perform work " + stopwatch;
    }

    @RequestMapping(value = "/users", produces = { MediaType.TEXT_HTML_VALUE }, method = RequestMethod.GET)
    @ResponseBody
    public String getUsers() throws Exception {
        LOGGER.info("Starting getting github users");
        Stopwatch stopwatch = Stopwatch.createStarted();

        CompletableFuture<User> user1 = gitHubLookupService.findUserComplete("olupas");
        CompletableFuture<User> user2 = gitHubLookupService.findUserComplete("CloudFoundry");
        CompletableFuture<User> user3 = gitHubLookupService.findUserComplete("Spring-Projects");

        //wait until calls are completed
        CompletableFuture.allOf(user1, user2, user3).join();

        return "time it took to perform work " + stopwatch;
    }

    @RequestMapping(value = "/asyncresponse", produces = { MediaType.TEXT_HTML_VALUE }, method = RequestMethod.GET)
    @ResponseBody
    public Callable<String> asyncResponse() throws Exception {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                LOGGER.info("Write response on. " + Thread.currentThread().getName());
                return "Response";
            }
        };
    }

}