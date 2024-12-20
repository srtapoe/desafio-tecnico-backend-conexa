package br.com.api.dto;

import br.com.api.entity.Paciente;

public class PacienteDTO {
    String nome;
    String cpf;

    public PacienteDTO(Paciente paciente) {
        this.nome = paciente.getNome();
        this.cpf = paciente.getCpf();
    }

    public PacienteDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PacienteDTO(String mensagemErro) {
        this.cpf = mensagemErro;
    }
}

