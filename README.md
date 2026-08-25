# 📚 Biblioteca Pessoal API

Uma API RESTful desenvolvida para o gerenciamento de uma biblioteca pessoal. Este projeto permite o cadastro, controle e consulta de autores e livros, utilizando boas práticas de desenvolvimento web e arquitetura em camadas.

## 🚀 Funcionalidades

A aplicação expõe endpoints para as seguintes operações:

*   **Gerenciamento de Autores:** Cadastro, listagem paginada, atualização, exclusão e busca por ID.
*   **Gerenciamento de Livros:** Cadastro, listagem dinâmica com filtros avançados, atualização e exclusão.
*   **Consultas Avançadas:** 
    *   Filtros dinâmicos utilizando Spring Data JPA Specifications (`AutorSpecification` e `LivroSpecification`).
    *   Relatórios otimizados utilizando Projections nativas, como a contagem de livros por autor (`QuantidadeLivrosPorAutorProjection`)[cite: 1].
*   **Tratamento de Erros Global:** Uso de `@RestControllerAdvice` para capturar exceções padronizadas, incluindo regras de negócio, validações de DTOs (`@Valid`) e retornos precisos de status HTTP (400, 404, 405, 409, 500).

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias e frameworks:

*   **Java**
*   **Spring Boot** (Web, Data JPA, Validation)
*   **Maven** (Gerenciamento de dependências e build).
*   **PostgreSQL** (Banco de dados relacional)
*   **Flyway** (Controle de versionamento do banco de dados com scripts SQL).
*   **Padrões de Projeto:** DTO (Data Transfer Object), Repository, Service, Controller.

## 📂 Estrutura do Banco de Dados (Migrations)

O projeto utiliza o Flyway para gerenciar as alterações no banco de dados, garantindo consistência e integridade[cite: 1]. As seguintes migrações estão disponíveis:

1.  `V1__criar_tabelas_autores_e_livros.sql`: Criação da estrutura inicial[cite: 1].
2.  `V2__adicionar_isbn_e_editora.sql`: Alterações no schema de livros[cite: 1].
3.  `V3__inserir_dados_iniciais.sql`: Carga de dados iniciais para testes[cite: 1].

## ⚙️ Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/Joaorooliveira/biblioteca-pessoal.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd biblioteca-pessoal
   ```
3. Configure as credenciais do banco de dados PostgreSQL no arquivo `application.properties`[cite: 1].
4. Execute a aplicação utilizando o Maven[cite: 1]:
   ```bash
   ./mvnw spring-boot:run
   ```
   *(No Windows, utilize `mvnw.cmd spring-boot:run`)*[cite: 1]

A API estará disponível em `http://localhost:8080`.

## 👨‍💻 Autor

Desenvolvido por **João Victor Ribeiro Oliveira**.
