package br.com.api.dto;

import br.com.api.entity.Paciente;

public record AtendimentoDTO(
        String dataHora,
        Paciente paciente
) {
}
