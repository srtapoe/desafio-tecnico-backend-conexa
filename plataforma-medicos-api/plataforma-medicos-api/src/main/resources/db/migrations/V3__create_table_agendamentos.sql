CREATE TABLE atendimentos
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_hora   DATETIME NOT NULL,
    medico_id   BIGINT   NOT NULL,
    paciente_id BIGINT   NOT NULL,
    FOREIGN KEY (medico_id) REFERENCES medicos (id),
    FOREIGN KEY (paciente_id) REFERENCES pacientes (id),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

