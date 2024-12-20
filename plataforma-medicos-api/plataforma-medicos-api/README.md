# Plataforma Médicos

## Descrição

Este projeto é uma aplicação de backend para atender o [Desafio Backend Conexa](https://github.com/conexasaude/desafio-tecnico-backend-conexa)

## Requisitos

- [Java 17](https://adoptopenjdk.net/)
- [MySQL 8.x](https://dev.mysql.com/downloads/installer/)
- [Maven](https://maven.apache.org/install.html)
- [Docker](https://www.docker.com/products/docker-desktop) (opcional para rodar o MySQL em contêiner)

## Instalação

### 1. Clone o repositório

Clone o repositório para sua máquina local:

```bash
git clone https://github.com/srtapoe/desafio-tecnico-backend-conexa.git
cd plataforma-medicos
````

### 2. Instale as dependências

Caso ainda não tenha o Maven instalado, siga as instruções do link de instalação do Maven.

Para instalar as dependências do projeto, execute:
```bash
mvn clean install
````

### 3.  Configuração do Banco de Dados (MySQL)
Usando Docker (opcional)
Se preferir rodar o MySQL em um contêiner Docker, execute o seguinte comando para iniciar o contêiner:

```bash
docker-compose up -d
docker pull mysql
````

Isso irá configurar um contêiner MySQL com as seguintes configurações:

- Banco de dados: plataforma_medicos
- Usuário: root
- Senha: root
- Porta: 3306

Sem Docker
Caso prefira configurar manualmente, instale o MySQL e crie um banco de dados com as seguintes configurações:

- Banco de dados: plataforma_medicos
- Usuário: root
- Senha: root

### 4. Rodando a Aplicação
Com o MySQL configurado, execute a aplicação:

````bash
mvn spring-boot:run
`````
### 5. Acessando a API
Você pode acessar a API localmente em:

````bash
http://localhost:8082
````
### Notas
- Lombok não foi incluído no projeto devido a problemas de configuração.
- Docker Compose não foi utilizado por conta de dificuldades na configuração do ambiente.