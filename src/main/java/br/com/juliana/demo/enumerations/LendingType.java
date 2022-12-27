package br.com.juliana.demo.enumerations;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LendingType {
    EMPRESTIMO_PESSOAL("EMPRESTIMO_PESSOAL", 4),
    EMPRESTIMO_GARANTIA("EMPRESTIMO_GARANTIA", 3),
    EMPRESTIMO_CONSIGNADO("EMPRESTIMO_CONSIGNADO", 2);

    private final String lendingName;
    private final int lendingTax;
}
