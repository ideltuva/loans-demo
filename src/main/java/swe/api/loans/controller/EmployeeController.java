package swe.api.loans.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import swe.api.loans.domain.Client;
import swe.api.loans.domain.Employee;
import swe.api.loans.domain.Employees;
import swe.api.loans.error.EmployeeNotFoundException;
import swe.api.loans.service.EmployeeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;


    @GetMapping(path="/", produces = "application/json")
    public Employees getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path="/{id}", produces = "application/json")
    public Employee getEmployee(String sid) {
        return employeeService.getEmployeeBySid(sid);
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
        employee.setSid(employeeService.generateSID());
        employeeService.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{sid}")
                .buildAndExpand(employee.getSid())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path="/approvers", produces = "application/json")
    public List<Employee> findAllApprovers() {
        return employeeService.findAllApprovers();
    }


}



