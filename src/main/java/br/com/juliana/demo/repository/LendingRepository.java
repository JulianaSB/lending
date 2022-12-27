package br.com.juliana.demo.repository;

import br.com.juliana.demo.model.Person;
import br.com.juliana.demo.model.Lending;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class LendingRepository {
    UUID uuid = UUID.randomUUID();
    String uuidAsString = uuid.toString();
    private int cpf;
    private String name;
    private int age;
    private String uf;
    private int monthlyIncome;

    void Person(int cpf, String name, int age, String uf, int monthlyIncome) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
        this.uf = uf;
        this.monthlyIncome = monthlyIncome;
    }

    public String toString() {
        boolean valueSecuredLending = false;
        boolean valuePayrollLending = false;

        Lending lending = new Lending();
        lending.setTypeLending("EMPRESTIMO_PESSOAL");
        lending.setTax(4);

        if (this.monthlyIncome < 3000) {

            if(this.uf == "SP" && this.age < 30) {
                valueSecuredLending = true;
            }
        }

        if (this.monthlyIncome >= 3000 && this.monthlyIncome < 5000) {

            if (this.uf == "SP") {
                valueSecuredLending = true;
            }
        }

        if (this.monthlyIncome >= 5000) {
            valuePayrollLending = true;  

            if (this.age < 30) {
                valueSecuredLending = true;
            }
        }
        
        if(valueSecuredLending) {
            lending.setTypeLending("EMPRESTIMO_GARANTIA");
            lending.setTax(3);
        }

        if(valuePayrollLending) {
            lending.setTypeLending("EMPRESTIMO_GARANTIA");
            lending.setTax(2);
        }


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return "data: {" + "numero_solicitacao=" + this.uuidAsString + ", data_solicitacao:" + dtf.format(now) + ", cliente: { nome='" + this.name + '\'' + ", cpf='" + this.cpf + ", idade='" + this.age + ", uf='" + this.uf + ", renda_mensal='" + this.monthlyIncome +"}"  +'\'' + '}';
    }
}
