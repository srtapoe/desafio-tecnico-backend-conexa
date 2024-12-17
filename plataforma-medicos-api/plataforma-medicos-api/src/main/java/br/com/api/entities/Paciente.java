package br.com.api.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(unique = true, nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;

    public Paciente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}
