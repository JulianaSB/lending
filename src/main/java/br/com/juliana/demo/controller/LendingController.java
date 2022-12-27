package br.com.juliana.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.juliana.demo.dto.LendingResponse;
import br.com.juliana.demo.dto.Person;
import br.com.juliana.demo.service.LendingService;

import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class LendingController {

    private final LendingService service;

    LendingController(LendingService service) {
        this.service = service;
    }

    @PostMapping("/lending")
    ResponseEntity<LendingResponse> newLending(@RequestBody Person newPerson) {
        return ResponseEntity.ok(service.lendingOptions(newPerson));
    }
}
