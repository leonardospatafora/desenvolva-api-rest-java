# 🏥 Voll.med API

API REST desenvolvida durante o curso **Spring Boot 3: desenvolva uma API Rest em Java** da Alura.

## Sobre o Projeto

A Voll.med API é um sistema de gerenciamento de médicos para uma clínica fictícia. A aplicação segue as boas práticas REST e implementa operações CRUD com exclusão lógica (soft delete).

## Tecnologias

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Validation**
- **MySQL**
- **Flyway** — migrations de banco de dados
- **Lombok**
- **SpringDoc OpenAPI (Swagger UI)**

## Endpoints

Base URL: `/medicos`

| Método | Endpoint        | Descrição                                  |
|--------|-----------------|--------------------------------------------|
| POST   | `/medicos`      | Cadastra um novo médico                    |
| GET    | `/medicos`      | Lista médicos ativos (paginado, 10/página) |
| PUT    | `/medicos`      | Atualiza dados de um médico                |
| DELETE | `/medicos/{id}` | Desativa um médico (soft delete)           |

A documentação completa da API está disponível via Swagger UI em:
```
http://localhost:8080/swagger-ui.html
```

## Pré-requisitos

- Java 17+
- Maven
- MySQL rodando localmente

## Configuração do Banco de Dados

Crie o banco de dados no MySQL:

```sql
CREATE DATABASE base_medicos;
```

Configure as credenciais em `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost/base_medicos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

> As migrations do Flyway criam e evoluem as tabelas automaticamente ao iniciar a aplicação.

## Como Executar

```bash
# Clone o repositório
git clone https://github.com/leonardospatafora/desenvolva-api-rest-java.git

# Acesse o diretório do projeto
cd desenvolva-api-rest-java/spring-boot-api

# Execute com Maven
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Estrutura do Projeto

```
spring-boot-api/
└── src/main/java/med/voll/api/
    ├── controller/       # Controllers REST
    ├── entities/         # Entidades JPA (Doctor, Address)
    ├── enums/            # Enumerações (Expertise)
    ├── models/           # DTOs (MedicalData, UpdateDoctorData, etc.)
    └── repositories/     # Repositórios Spring Data
```

## Migrations

| Versão | Descrição                                        |
|--------|--------------------------------------------------|
| V1     | Criação da tabela `medicos`                      |
| V2     | Adição da coluna `telefone`                      |
| V3     | Adição da coluna `ativo` (exclusão lógica)       |
