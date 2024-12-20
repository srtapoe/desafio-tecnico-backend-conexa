package br.com.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "atendimentos")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dataHora;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @ManyToOne
    Medico medico;

    public Atendimento(Paciente paciente, LocalDateTime dataHora, Medico medico) {
        this.paciente = paciente;
        this.dataHora = dataHora;
        this.medico = medico;
    }

    public Atendimento(Long id, LocalDateTime dataHora, Paciente paciente) {
        this.id = id;
        this.dataHora = dataHora;
        this.paciente = paciente;
    }

    public Atendimento() {
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
