package br.com.juliana.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    private int cpf;
    private String name;
    private int age;
    private String uf;
    private int monthlyIncome;
}
