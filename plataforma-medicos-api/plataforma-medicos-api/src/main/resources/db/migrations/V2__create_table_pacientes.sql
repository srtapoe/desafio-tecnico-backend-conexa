CREATE TABLE pacientes
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) UNIQUE NOT NULL,
    cpf  VARCHAR(14) UNIQUE  NOT NULL
);