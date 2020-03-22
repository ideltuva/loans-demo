package swe.api.loans.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import swe.api.loans.domain.Contract;
import swe.api.loans.service.ContractService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {


    private static final Logger logger = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    ContractService contractService;

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addContract(@RequestBody Contract contract) {

        contract.setId(contractService.getNextId());
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
    public ResponseEntity<Object> approve(@RequestBody Contract contract) {
        contract.setState(Contract.State.APRROVED);
        contractService.save(contract);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(contract.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> reject(@RequestBody Contract contract) {
        contract.setState(Contract.State.REJECTED);
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
