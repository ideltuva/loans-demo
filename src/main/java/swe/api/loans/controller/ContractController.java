package swe.api.loans.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import swe.api.loans.domain.Contract;
import swe.api.loans.domain.Contracts;
import swe.api.loans.service.ContractService;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    SimpleDateFormat changeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");

    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    ContractService contractService;

    @GetMapping(path= "/", consumes = "application/json", produces = "application/json")
    public Contracts getAllContracts() {
        return contractService.getAllContracts();
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addContract(@RequestBody Contract contract) throws ParseException {
        Date date = new Date();
        contract.setId(contractService.getNextId());
        contract.setCreated(changeFormat.format(date));
        contract.setUpdated(changeFormat.format(date));
        contractService.save(contract);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contract.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path= "/approver/{sid}", consumes = "application/json", produces = "application/json")
    public List<Contract> findAllContractsByApprover(@PathVariable String sid) {
        return contractService.getAllContractsByApprover(sid);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> confirmStatus(@RequestBody Contract contract) throws ParseException {
        contract.setState(Contract.State.APRROVED==contract.getState()?Contract.State.APRROVED:Contract.State.REJECTED);
        Date date = new Date();
        contract.setUpdated(changeFormat.format(date));
        contractService.save(contract);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contract.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @GetMapping(path= "/approved", consumes = "application/json", produces = "application/json")
    public List<Contract> findAllApprovedContracts() {
        return contractService.getAllApprovedContracts();
    }


}
