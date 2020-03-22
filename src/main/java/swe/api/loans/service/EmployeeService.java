package swe.api.loans.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe.api.loans.controller.EmployeeController;
import swe.api.loans.dao.EmployeeDAO;
import swe.api.loans.domain.Employee;
import swe.api.loans.domain.Employees;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeDAO employeeDao;


    public int getNextId() {
        return employeeDao.getAllEmployees().getEmployeeList().size() + 1;
    }

    public void save(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    public Employees getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    public String generateSID()
    {

        String allNumberSet = "0123456789";
        StringBuilder sb = new StringBuilder(5);

        for (int i=0; i < 5; i++) {
            int index = (int)(allNumberSet.length() * Math.random());
            sb.append(allNumberSet.charAt(index));
        }

        return "s" + sb.toString();
    }

    public Employee getEmployeeBySid(String sid) {
        List<Employee> employeeList = getAllEmployees().getEmployeeList();
        List<Employee> employeeOutList = new ArrayList<>();
        for (Employee emp:employeeList) {
            if (emp.getSid() == sid) employeeOutList.add(emp);

        }
        return employeeOutList.size()>0?employeeOutList.get(0):null;


    }

    public List<Employee> findAllApprovers() {
        List<Employee> employeeList = employeeDao.getAllEmployees().getEmployeeList();
        List<Employee> approverList = new ArrayList<>();

        for (Employee employee:employeeList) {
            if(employee.isLoanApprover()) approverList.add(employee);
        }

        return approverList;
    }


}
