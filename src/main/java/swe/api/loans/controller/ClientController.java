package swe.api.loans.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import swe.api.loans.dao.ClientDAO;
import swe.api.loans.domain.Client;
import swe.api.loans.domain.Clients;
import swe.api.loans.service.ClientService;

import java.net.URI;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;

    @GetMapping(path="/", produces = "application/json")
    public Clients getClients() {
        return clientService.getAllClients();
    }

    @GetMapping(value="/{id}", produces = "application/json")
    public Client getClient(@PathVariable int id) {
        return clientService.getClient(id);
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addClient(@RequestBody Client client) {
        client.setId(clientService.getNextId());
        client.setCustomerId(clientService.generateCustomerId());
        clientService.save(client);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }




}
