package br.com.juliana.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.juliana.demo.dto.Lending;
import br.com.juliana.demo.dto.LendingResponse;
import br.com.juliana.demo.dto.Person;
import br.com.juliana.demo.enumerations.LendingType;

import java.time.LocalDateTime; 
@Service
public class LendingService {
    String uuidNumeroSolicitacao = UUID.randomUUID().toString();

    private boolean valueSecuredLending(Person person) {
        if(person.getRenda_mensal() < 3000 && "SP".equals(person.getUf()) && person.getIdade() < 30) {
            return true;
        }

        if(person.getRenda_mensal() >= 3000 && person.getRenda_mensal() < 5000 && "SP".equals(person.getUf()) && person.getIdade() >= 30) {
            return true;
        }

        if(person.getRenda_mensal() >= 5000 && person.getIdade() >= 30) {
            return true;
        }

        return false;

    }

    private boolean valuePayrollLending(Person person) {
        if(person.getRenda_mensal() >= 5000) {
            return true;
        }

        return false;
    }

    public LendingResponse lendingOptions(Person person) {

        List<Lending> lendingList = new ArrayList();
        Lending personLending = new Lending(LendingType.EMPRESTIMO_PESSOAL);
        lendingList.add(personLending);

        if(valueSecuredLending(person)) {
            Lending securedLending = new Lending(LendingType.EMPRESTIMO_GARANTIA);
            lendingList.add(securedLending);
        }

        if(valuePayrollLending(person)) {
            Lending payrollLending = new Lending(LendingType.EMPRESTIMO_CONSIGNADO);
            lendingList.add(payrollLending);
        }

        LendingResponse lendingResponse = new LendingResponse();
        lendingResponse.setNumero_solicitacao(uuidNumeroSolicitacao);
        lendingResponse.setData_solicitacao(LocalDateTime.now());
        lendingResponse.setCliente(person);
        lendingResponse.setProdutos_emprestimo(lendingList);

        return lendingResponse;
    }
}
