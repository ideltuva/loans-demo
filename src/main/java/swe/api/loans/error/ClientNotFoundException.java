package swe.api.loans.error;

public class ClientNotFoundException extends RuntimeException {

    ClientNotFoundException(int id) {
        super("Could not find client: " + id);
    }

}
