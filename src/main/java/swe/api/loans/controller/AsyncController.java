package swe.api.loans.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import swe.api.loans.domain.Statistics;
import swe.api.loans.service.AsyncService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/asyncstatistics")
public class AsyncController {

    private static Logger log = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private AsyncService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void runAsyncStatistics() throws InterruptedException, ExecutionException {
        log.info("AsyncStatistics started");
        CompletableFuture<Statistics> stats = service.getAsyncStatistics();
        log.info("AsyncStatistics--> " + stats.get());
    }
}
