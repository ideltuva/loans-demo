package swe.api.loans.dao;


import org.springframework.stereotype.Repository;
import swe.api.loans.domain.Client;
import swe.api.loans.domain.Clients;

@Repository
public class ClientDAO {

    private static Clients list = new Clients();

    static
    {
        list.getClientList().add(new Client(1, "Joe", "James", "er-tr3j-343"));
        list.getClientList().add(new Client(2, "Alex", "Caravan", "22-fd4k-2we"));
        list.getClientList().add(new Client(3, "Jane", "May", "jj-87k0-9j9"));
    }


    public Clients getAllClients() {
        return list;
    }

    public void addClient(Client client) {
        list.getClientList().add(client);
    }

    public Client getClient(int id) {
        return list.getClientList().get(id);
    }


}
