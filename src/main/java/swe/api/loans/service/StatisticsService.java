package swe.api.loans.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe.api.loans.domain.Contract;
import swe.api.loans.domain.Statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    ContractService contractService;

    public Statistics getAllStatistics(int secondPeriod) {
        List<Contract> contracts = contractService.getAllApprovedContractsInPeriod(secondPeriod);

        if (contracts!=null) {
            List<Integer> amounts = new ArrayList<>();
            for (Contract contract : contracts) amounts.add(contract.getAmount());
            double sum = sum(amounts);
            int count = contracts.size();
            double avg = 0.0;
            if (count != 0) avg = sum / count;
            double max = findMax(amounts);
            double min = findMin(amounts);
            return new Statistics(count, sum, avg, max, min);
        } else return new Statistics();
    }


    public static double findMin(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        List<Integer> sortedlist = new ArrayList<>(list);
        Collections.sort(sortedlist);
        return sortedlist.get(0);
    }

    public static Integer findMax(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        List<Integer> sortedlist = new ArrayList<>(list);
        Collections.sort(sortedlist);
        return sortedlist.get(sortedlist.size() - 1);
    }

    public static double sum(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (int amount:list) sum+=amount;
        return sum;
    }


}
