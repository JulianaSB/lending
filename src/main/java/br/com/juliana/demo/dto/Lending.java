package br.com.juliana.demo.dto;

import br.com.juliana.demo.enumerations.LendingType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lending {
    private String tipo_emprestimo;
    private int taxa;

    public Lending (LendingType lendingType) {
        this.tipo_emprestimo = lendingType.getLendingName();
        this.taxa = lendingType.getLendingTax();
    }
}
