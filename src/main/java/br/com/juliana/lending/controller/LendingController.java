package br.com.juliana.lending.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.juliana.lending.dto.LendingResponse;
import br.com.juliana.lending.dto.Person;
import br.com.juliana.lending.dto.RequestBodyLending;
import br.com.juliana.lending.service.LendingService;

import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class LendingController {

    private final LendingService service;

    LendingController(LendingService service) {
        this.service = service;
    }

    @PostMapping("/lending")
    ResponseEntity<LendingResponse> newLending(@RequestBody RequestBodyLending newPerson) {
        return ResponseEntity.ok(service.lendingOptions(newPerson.getCliente()));
    }
}
