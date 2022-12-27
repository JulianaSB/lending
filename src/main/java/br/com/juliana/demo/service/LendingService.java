package br.com.juliana.demo.service;

import br.com.juliana.demo.model.Lending;
import br.com.juliana.demo.repository.LendingRepository;

public class LendingService {
    private LendingRepository repository;

    public Lending save(Lending lending) {
        return repository.save(lending);
    }
}
