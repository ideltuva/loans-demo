package swe.api.loans.domain;

public class Contract {

    String customerId;
    String queryId;
    String preparedBy;
    String approver;
    String loanType;
    int amount;

    public Contract(Query query, String preparedBy) {
        this.customerId = query.getCustomerId();
        this.preparedBy = preparedBy;
        this.amount = query.getAmount();
        this.loanType = query.getLoanType();
        this.queryId = query.getQueryId();
    }

    public Contract() {

    }

    public String getCustomerId() {
        return customerId;
    }

    public Contract setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getQueryId() {
        return queryId;
    }

    public Contract setQueryId(String queryId) {
        this.queryId = queryId;
        return this;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public Contract setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
        return this;
    }

    public String getApprover() {
        return approver;
    }

    public Contract setApprover(String approver) {
        this.approver = approver;
        return this;
    }

    public String getLoanType() {
        return loanType;
    }

    public Contract setLoanType(String loanType) {
        this.loanType = loanType;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Contract setAmount(int amount) {
        this.amount = amount;
        return this;
    }

}
