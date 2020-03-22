package swe.api.loans.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import swe.api.loans.domain.Statistics;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {


    private static Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Async("asyncExecutor")
    public CompletableFuture<Statistics> getAsyncStatistics() throws InterruptedException {
        log.info("getAsyncStatistics starts");
        Statistics stats = restTemplate.getForObject("http://localhost:8080/statistics/", Statistics.class);
        log.info("stats, {}", stats);
        Thread.sleep(60000L);
        log.info("Statistics gathering completed");
        return CompletableFuture.completedFuture(stats);
    }

}
