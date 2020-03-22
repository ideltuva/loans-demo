package swe.api.loans.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swe.api.loans.domain.Contract;
import swe.api.loans.domain.Statistics;
import swe.api.loans.service.StatisticsService;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    private static Logger log = LoggerFactory.getLogger(StatisticsController.class);

    @GetMapping(path= "/", consumes = "application/json", produces = "application/json")
    public Statistics getStatistics() {
        return statisticsService.getAllStatistics();
    }


}
