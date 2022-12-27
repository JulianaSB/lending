package br.com.juliana.demo.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class LendingResponse {
    private String numero_solicitacao;
    private LocalDateTime data_solicitacao;
    private Person cliente;
    private List<Lending> produtos_emprestimo;
}
