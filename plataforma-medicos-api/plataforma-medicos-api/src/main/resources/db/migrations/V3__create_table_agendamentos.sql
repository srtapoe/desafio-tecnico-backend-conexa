CREATE TABLE agendamentos
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora   DATETIME NOT NULL,
    paciente_id BIGINT   NOT NULL,
    CONSTRAINT fk_paciente FOREIGN KEY (paciente_id) REFERENCES pacientes (id)
);
