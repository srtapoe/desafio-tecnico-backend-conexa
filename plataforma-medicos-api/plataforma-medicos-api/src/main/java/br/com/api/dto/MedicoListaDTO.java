package br.com.api.dto;

import br.com.api.enums.Especialidade;
import br.com.api.enums.Role;

public record MedicoListaDTO(
        String email,
        Especialidade especialidade,
        String cpf,
        String dataNascimento,
        String telefone,
        Role role
) {

}
