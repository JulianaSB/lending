package br.com.juliana.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String cpf;
    private String nome;
    private int idade;
    private String uf;
    private int renda_mensal;
}
