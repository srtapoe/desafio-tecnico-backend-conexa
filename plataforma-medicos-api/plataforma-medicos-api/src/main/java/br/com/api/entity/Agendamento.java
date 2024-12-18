package br.com.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    @OneToOne
    private Paciente paciente;

    public Agendamento(Paciente paciente, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.dataHora = dataHora;
    }

    public Agendamento(Long id, LocalDateTime dataHora, Paciente paciente) {
        this.id = id;
        this.dataHora = dataHora;
        this.paciente = paciente;
    }

    public Agendamento() {
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
