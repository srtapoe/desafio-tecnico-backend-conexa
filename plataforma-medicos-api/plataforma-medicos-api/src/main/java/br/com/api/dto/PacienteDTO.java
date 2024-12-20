package br.com.api.dto;

import br.com.api.entity.Paciente;

public class PacienteDTO {
    String nome;
    String cpf;

    public PacienteDTO(Paciente paciente) {
        this.cpf = paciente.getCpf();
        this.nome = paciente.getNome();
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

    public PacienteDTO(String mensagem) {
        this.nome = mensagem;
    }
}

