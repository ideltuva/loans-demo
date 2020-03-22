package swe.api.loans.domain;

public class Employee {

    String name;
    String lastName;
    String sid;
    boolean isLoanApprover;

    public Employee(String name, String lastName, String sid, boolean isLoanApprover) {
        this.name = name;
        this.lastName = lastName;
        this.sid = sid;
        this.isLoanApprover = isLoanApprover;
    }


    public boolean isLoanApprover() {
        return isLoanApprover;
    }

    public void setLoanApprover(boolean loanApprover) {
        isLoanApprover = loanApprover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }




}
