package br.com.api.enums;


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

    Especialidade(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
