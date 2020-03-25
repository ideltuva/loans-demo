package swe.api.loans.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import swe.api.loans.domain.Client;
import swe.api.loans.domain.Contract;
import swe.api.loans.domain.Contracts;

import java.text.ParseException;

@Repository
public class ContractDAO {

    private static Contracts list = new Contracts();

    static {
        try {
            list.getContractList().add(new Contract(1, 0, "s12345", "leasing", 5000, "2012-07-13 14:58:00.000000", "2020-03-24 13:18:30.000000"));
            list.getContractList().add(new Contract(2, 0, "s12345", "credit", 300, "2013-07-10 14:58:00.000000", "2020-03-04 14:23:00.000000"));
            list.getContractList().add(new Contract(3, 1, "s54321", "mortgage", 100000, "2020-03-01 16:58:00.000000", "2020-03-10 11:58:00.000000"));
            list.getContractList().add(new Contract(4, 2, "s54321", "leasing", 3000, "2017-04-10 14:58:00.000000", "2019-09-10 14:15:00.000000"));
            list.getContractList().add(new Contract(5, 2, "s54321", "leasing", 4000, "2018-03-19 17:58:00.000000", "2020-01-10 12:08:00.000000"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public Contracts getAllContracts() {
        return list;
    }

    public void addContract(Contract contract) {


        list.getContractList().add(contract);
    }



}
