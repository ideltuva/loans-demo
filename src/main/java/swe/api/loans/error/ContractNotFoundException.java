package swe.api.loans.error;

public class ContractNotFoundException extends RuntimeException {

    ContractNotFoundException(int id) {
        super("Could not find contract: " + id);
    }

}
