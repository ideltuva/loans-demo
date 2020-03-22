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

    public Statistics getAllStatistics() {
        List<Contract> contracts = contractService.getAllApprovedContracts();
        List<Integer> amounts = new ArrayList<>();
        for (Contract contract:contracts) amounts.add(contract.getAmount());

        int sum = sum(amounts);
        int count = contracts.size();
        int avg = 0;
        if (count!= 0) avg = sum/count;
        int max = findMax(amounts);
        int min = findMin(amounts);
        return new Statistics(count, sum, avg, max, min);
    }


    public static Integer findMin(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return Integer.MAX_VALUE;
        }
        List<Integer> sortedlist = new ArrayList<>(list);
        Collections.sort(sortedlist);
        return sortedlist.get(0);
    }

    public static Integer findMax(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return Integer.MIN_VALUE;
        }
        List<Integer> sortedlist = new ArrayList<>(list);
        Collections.sort(sortedlist);
        return sortedlist.get(sortedlist.size() - 1);
    }

    public static Integer sum(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (int amount:list) sum+=amount;
        return sum;
    }


}
