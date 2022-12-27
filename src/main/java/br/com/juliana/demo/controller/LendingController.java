package br.com.juliana.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.juliana.demo.service.LendingService;

import org.springframework.web.bind.annotation.RequestBody;

public class LendingController {

    private final LendingService service;

    LendingController(LendingService service) {
        this.service = service;
    }

    @PostMapping("/lending")
    LendingService newLending(@RequestBody LendingService newLending) {
        return service.save(newLending);
    }
}
