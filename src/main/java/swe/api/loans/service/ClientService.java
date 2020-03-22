package swe.api.loans.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe.api.loans.dao.ClientDAO;
import swe.api.loans.domain.Client;
import swe.api.loans.domain.Clients;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientDAO clientDao;

    public String generateCustomerId () {

        String randomStringSeq = getStringFromLettersAndNumbers(9);
        StringBuilder sb = new StringBuilder(11);
        for (int i=0; i < 9; i++) {
            if((i==2)||(i==6)) {
                sb.append("-");
                sb.append(randomStringSeq.charAt(i));

            } else sb.append(randomStringSeq.charAt(i));
        }
        return isUnique(sb.toString())?sb.toString():getStringFromLettersAndNumbers(9);
    }

    private String getStringFromLettersAndNumbers(int length)
    {

        String allStringSet = "abcdefghijklmnopqrstuvxyz"
                                    + "0123456789";
        StringBuilder sb = new StringBuilder(length);

        for (int i=0; i < length; i++) {
            int index = (int)(allStringSet.length() * Math.random());
            sb.append(allStringSet.charAt(index));
        }

        return sb.toString();
    }

    private boolean isUnique(String customerId) {
        List<Client> clients = clientDao.getAllClients().getClientList();
        for (Client client:clients) {
            if (client.getCustomerId() == customerId) {
                return false;
            }
        }

        return true;

    }

    public int getNextId() {
        return clientDao.getAllClients().getClientList().size() + 1;
    }

    public void save(Client client) {
        clientDao.addClient(client);
    }

    public Clients getAllClients() {
        return clientDao.getAllClients();
    }




}
