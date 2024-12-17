package br.com.api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "agendamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private LocalDateTime dataHora;
    @OneToOne
    private Paciente paciente;

    public Agendamento(Paciente paciente, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.dataHora = dataHora;
    }
}
