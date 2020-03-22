package swe.api.loans.domain;

public class Contract {

    int id;

    int clientId;
    String preparedBy;
    String approver;
    String loanType;
    int amount;
    State state;

    public Contract() {

    }

    public enum State {
        IN_QUEUE,
        APRROVED,
        REJECTED;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public Contract setClientId(int clientId) {
        this.clientId = clientId;
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Contract(int id, int clientId, String preparedBy, String loanType, int amount) {
        this.id = id;
        this.clientId = clientId;
        this.preparedBy = preparedBy;
        this.amount = amount;
        this.loanType = loanType;
        this.state = State.IN_QUEUE;
    }

}
