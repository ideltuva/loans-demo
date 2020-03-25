package swe.api.loans.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contract {

    int id;

    int clientId;
    String preparedBy;
    String approver;
    String loanType;
    int amount;
    State state;
    Date created;
    Date updated;


    public Contract() {

    }

    public enum State {
        IN_QUEUE,
        APRROVED,
        REJECTED;

    }

    SimpleDateFormat changeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(String created) throws ParseException {
        this.created = changeFormat.parse(created);
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) throws ParseException {
        this.updated = changeFormat.parse(updated);
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }


    public Contract(int id, int clientId, String preparedBy, String loanType, int amount, String created, String updated) throws ParseException {
        this.id = id;
        this.clientId = clientId;
        this.preparedBy = preparedBy;
        this.amount = amount;
        this.loanType = loanType;
        this.state = State.IN_QUEUE;
        this.created = changeFormat.parse(created);
        this.updated = changeFormat.parse(updated);
    }

}
