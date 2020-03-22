package swe.api.loans.dao;

import org.springframework.stereotype.Repository;
import swe.api.loans.domain.Employee;
import swe.api.loans.domain.Employees;


@Repository
public class EmployeeDAO {

    private static Employees list = new Employees();

    static  {
        list.getEmployeeList().add(new Employee("Sheldon", "Cooper", "S12345", false));
        list.getEmployeeList().add(new Employee("Brian", "Lee", "S54321", false));
        list.getEmployeeList().add(new Employee("John", "Rambo", "s89798", false));
        list.getEmployeeList().add(new Employee("Glen", "Davis", "s87677", false));
        list.getEmployeeList().add(new Employee("Sarah", "Parker", "s54722", true));
        list.getEmployeeList().add(new Employee("Maria", "Gomez", "s76677", true));
    }



    public Employees getAllEmployees() {
        return list;
    }

    public void addEmployee(Employee employee) {
        list.getEmployeeList().add(employee);
    }



}
