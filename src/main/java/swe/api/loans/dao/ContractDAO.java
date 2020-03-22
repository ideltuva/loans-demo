package swe.api.loans.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import swe.api.loans.domain.Client;
import swe.api.loans.domain.Contract;
import swe.api.loans.domain.Contracts;

@Repository
public class ContractDAO {

    private static Contracts list = new Contracts();

    static {

        list.getContractList().add(new Contract(0, "s12345", "leasing", 5000));
        list.getContractList().add(new Contract(0, "s12345", "credit", 300));
        list.getContractList().add(new Contract(1, "s54321", "mortgage", 100000));
        list.getContractList().add(new Contract(2, "s54321", "leasing", 3000));
        list.getContractList().add(new Contract(2, "s54321", "leasing", 4000));
    }


    public Contracts getAllContracts() {
        return list;
    }

    public void addContract(Contract contract) {
        list.getContractList().add(contract);
    }



}
