CREATE TABLE medicos
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    email           VARCHAR(255) UNIQUE NOT NULL,
    senha           VARCHAR(255)        NOT NULL,
    especialidade   VARCHAR(50)         NOT NULL,
    cpf             VARCHAR(14) UNIQUE  NOT NULL,
    telefone        VARCHAR(20),
    data_nascimento DATETIME            NOT NULL,
    role            VARCHAR(50)         NOT NULL
);
