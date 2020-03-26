package swe.api.loans.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;
import swe.api.loans.domain.Statistics;
import swe.api.loans.service.StatisticsService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    StatisticsService statisticsService;

    private static Logger log = LoggerFactory.getLogger(StatisticsController.class);

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public Statistics getStatisticsInSecondsPeriod(@RequestParam(value="inSecondsPeriod", defaultValue="60") String inSecondsPeriod) {
        int seconds = Integer.parseInt(inSecondsPeriod);
        return statisticsService.getAllStatistics(seconds);
    }


}
