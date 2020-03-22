package swe.api.loans.domain;

public class Statistics {

    int contractCount;
    int loanSum;
    int avgLoanSum;
    int maxLoanSum;
    int minLonadSum;

    public int getContractCount() {
        return contractCount;
    }

    public void setContractCount(int contractCount) {
        this.contractCount = contractCount;
    }

    public int getLoanSum() {
        return loanSum;
    }

    public void setLoanSum(int loanSum) {
        this.loanSum = loanSum;
    }

    public int getAvgLoanSum() {
        return avgLoanSum;
    }

    public void setAvgLoanSum(int avgLoanSum) {
        this.avgLoanSum = avgLoanSum;
    }

    public int getMaxLoanSum() {
        return maxLoanSum;
    }

    public void setMaxLoanSum(int maxLoanSum) {
        this.maxLoanSum = maxLoanSum;
    }

    public int getMinLonadSum() {
        return minLonadSum;
    }

    public void setMinLonadSum(int minLonadSum) {
        this.minLonadSum = minLonadSum;
    }

    public Statistics(int contractCount, int loanSum, int avgLoanSum, int maxLoanSum, int minLonadSum) {
        this.contractCount = contractCount;
        this.loanSum = loanSum;
        this.avgLoanSum = avgLoanSum;
        this.maxLoanSum = maxLoanSum;
        this.minLonadSum = minLonadSum;
    }

    @Override
    public String toString() {
        return "Statistics: [contractCount=" + contractCount + ", loanSum= " + loanSum +
                ", avgLoanSum=" + avgLoanSum + ", maxLoanSum=" + maxLoanSum + ", minLoanSum=" + minLonadSum + "]";
    }
}
