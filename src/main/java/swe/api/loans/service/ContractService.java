package swe.api.loans.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe.api.loans.dao.ContractDAO;
import swe.api.loans.domain.Contract;
import swe.api.loans.domain.Contracts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContractService {

    private static final Logger logger = LoggerFactory.getLogger(ContractService.class);

    @Autowired
    ContractDAO contractDao;

    public void save(Contract contract) {
        contractDao.addContract(contract);
    }

    public Contracts getAllContracts() {
        return contractDao.getAllContracts();
    }

    public int getNextId() {
        return contractDao.getAllContracts().getContractList().size() + 1;
    }

    public List<Contract> getAllContractsByApprover(String sid) {
        List<Contract> contracts = getAllContracts().getContractList();
        List<Contract> approverContracts = new ArrayList<>();

        for (Contract contract:contracts) {
            if (contract.getApprover()==sid) approverContracts.add(contract);
        }

        return approverContracts;

    }

    public Contract findContractById(int id) {
        List<Contract> contracts = getAllContracts().getContractList();
        List<Contract> approverContracts = new ArrayList<>();

        for (Contract contract:contracts) {
            if (contract.getId()==id) approverContracts.add(contract);
        }

        return approverContracts.size()>0?approverContracts.get(0):null;

    }

    public List<Contract> getAllApprovedContracts() {
        List<Contract> contracts = getAllContracts().getContractList();
        List<Contract> approvedContracts = new ArrayList<>();
        for (Contract contract:contracts) {
            if (contract.getState()==Contract.State.APRROVED) approvedContracts.add(contract);
        }

        return approvedContracts;
    }

    public List<Contract> getAllApprovedContractsInPeriod(int periodTimeInSeconds) {
        List<Contract> contracts = getAllContracts().getContractList();
        List<Contract> approvedContracts = new ArrayList<>();
        Date date = new Date();
        date.setTime(date.getTime() - periodTimeInSeconds * 1000);
        for (Contract contract:contracts) {
            if (contract.getState()==Contract.State.APRROVED && (contract.getUpdated().compareTo(date) >= 0)) approvedContracts.add(contract);
        }

        return approvedContracts;
    }



}
