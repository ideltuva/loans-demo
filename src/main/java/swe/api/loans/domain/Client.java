package swe.api.loans.domain;

public class Client {

    int id;
    String firstName;
    String lastName;
    String customerId;

    public Client() {

    }

    public Client(int id, String firstName, String lastName, String customerId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client " + "[firstname=" + firstName + ", lastName=" + lastName + ", custommerId=" + customerId + ", id=" + id + "]";
    }

}
