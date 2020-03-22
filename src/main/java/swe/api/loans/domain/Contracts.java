package swe.api.loans.domain;

import java.util.ArrayList;
import java.util.List;

public class Contracts {

    private List<Contract> contractList;

    public List<Contract> getContractList() {
        if(contractList == null) {
            contractList = new ArrayList<>();
        }
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
