package swe.api.loans.domain;

public class Statistics {

    int contractCount;
    double loanSum;
    double avgLoanSum;
    double maxLoanSum;
    double minLonadSum;

    public int getContractCount() {
        return contractCount;
    }

    public void setContractCount(int contractCount) {
        this.contractCount = contractCount;
    }

    public double getLoanSum() {
        return loanSum;
    }

    public void setLoanSum(double loanSum) {
        this.loanSum = loanSum;
    }

    public double getAvgLoanSum() {
        return avgLoanSum;
    }

    public void setAvgLoanSum(double avgLoanSum) {
        this.avgLoanSum = avgLoanSum;
    }

    public double getMaxLoanSum() {
        return maxLoanSum;
    }

    public void setMaxLoanSum(double maxLoanSum) {
        this.maxLoanSum = maxLoanSum;
    }

    public double getMinLonadSum() {
        return minLonadSum;
    }

    public void setMinLonadSum(double minLonadSum) {
        this.minLonadSum = minLonadSum;
    }

    public Statistics(int contractCount, double loanSum, double avgLoanSum, double maxLoanSum, double minLonadSum) {
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
