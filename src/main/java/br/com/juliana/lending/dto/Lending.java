package br.com.juliana.lending.dto;

import br.com.juliana.lending.enumerations.LendingType;
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
