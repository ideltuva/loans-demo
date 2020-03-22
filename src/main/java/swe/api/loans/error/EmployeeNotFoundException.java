package swe.api.loans.error;

public class EmployeeNotFoundException extends RuntimeException {

    EmployeeNotFoundException(String sid) {
        super("Could not find employee: " + sid);
    }

}
