package swe.api.loans.domain;

public class Query {


    private String loanType;
    private int amount;
    private String customerId;
    private String queryId;

    public String getLoanType() {
        return loanType;
    }

    public Query setLoanType(String loanType) {
        this.loanType = loanType;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Query setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getQueryId() {
        return queryId;
    }

    public Query setQueryId(String queryId) {
        this.queryId = queryId;
        return this;
    }
}
