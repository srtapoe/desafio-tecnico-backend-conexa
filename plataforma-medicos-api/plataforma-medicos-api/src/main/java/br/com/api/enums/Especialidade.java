package br.com.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Especialidade {

    CARDIOLOGISTA("Cardiologista"),
    DERMATOLOGISTA("Dermatologista"),
    ENDOCRINOLOGISTA("Endocrinologista"),
    GASTROENTEROLOGISTA("Gastroenterologista"),
    NEUROLOGISTA("Neurologista"),
    OFTALMOLOGISTA("Oftalmologista"),
    ORTOPEDISTA("Ortopedista"),
    PEDIATRA("Pediatra"),
    PSIQUIATRA("Psiquiatra"),
    UROLOGISTA("Urologista");

    private final String description;
}
