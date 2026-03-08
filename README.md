# 🏛️ ForumHub API

O **ForumHub** é uma API RESTful robusta desenvolvida para gerenciar um fórum de discussões. O projeto foca em segurança de dados, regras de negócio consistentes e uma arquitetura limpa e escalável.

---

## 🚀 Sobre o Projeto

Esta API foi construída utilizando o ecossistema **Spring Boot**, aplicando conceitos avançados como:
* **Autenticação Stateless:** Utilização de tokens JWT para segurança.
* **Arquitetura em Camadas:** Separação clara entre *Controller*, *Service*, *Domain* e *Infrastructure*.
* **Strategy Pattern:** Validações de negócio desacopladas e extensíveis.
* **Documentação Automática:** Swagger/OpenAPI configurado para testes interativos.

---

## ✅ Funcionalidades Principais

### 🔐 Segurança e Acesso
* **Login de Usuários:** Autenticação via `login` e `senha`.
* **Criptografia:** Senhas armazenadas com o algoritmo **BCrypt**.
* **Proteção de Rotas:** Filtro de segurança JWT que valida o token em cada requisição.

### 💬 Gestão de Tópicos
* **CRUD Completo:** Criar, listar (com paginação), detalhar, atualizar e excluir tópicos.
* **Regras de Negócio:** Bloqueio de tópicos duplicados (mesmo título ou mensagem).
* **Vínculos:** Cada tópico é associado obrigatoriamente a um **Autor** e a um **Curso**.

### 📚 Entidades de Apoio
* **Autores:** Cadastro de usuários que podem interagir no fórum.
* **Cursos:** Organização de tópicos por categorias (PROGRAMAÇÃO, REDES, etc.).

---

## 🔁 Endpoints da API

| Categoria | Método | Endpoint | Descrição | Acesso |
| :--- | :--- | :--- | :--- | :--- |
| **Auth** | `POST` | `/login` | Gera o token JWT | **Público** |
| **Autores** | `POST` | `/autores` | Cadastra novo autor | Autorizado |
| **Cursos** | `POST` | `/cursos` | Cadastra novo curso | Autorizado |
| **Tópicos** | `POST` | `/topicos` | Cria um novo tópico | Autorizado |
| **Tópicos** | `GET` | `/topicos` | Lista (10 por página) | Autorizado |
| **Tópicos** | `GET` | `/topicos/{id}` | Detalha um tópico | Autorizado |
| **Tópicos** | `PUT` | `/topicos/{id}` | Edita título/mensagem | Autorizado |
| **Tópicos** | `DELETE`| `/topicos/{id}` | Remove um tópico | Autorizado |

> 📖 **Documentação Interativa:** Acesse o Swagger em `http://localhost:8080/swagger-ui.html` para testar os endpoints diretamente no navegador.

---

## 🛠️ Stack Tecnológica

* **Linguagem:** Java 25 (Eclipse Temurin LTS)
* **Framework:** Spring Boot 3+
* **Segurança:** Spring Security & Auth0 JWT
* **Banco de Dados:** MySQL 8
* **Persistência:** Spring Data JPA / Hibernate
* **Migrações:** Flyway
* **Documentação:** SpringDoc OpenAPI

---

## ▶️ Como Executar

### 1. Requisitos
* JDK 25 instalado.
* MySQL Server rodando.

### 2. Variáveis de Ambiente
Configure as seguintes variáveis no seu ambiente ou IDE (IntelliJ):
* `DB_HOST`: localhost
* `DB_NAME`: forum
* `DB_USER`: seu_usuario
* `DB_PASSWORD`: sua_senha
* `JWT_SECRET`: sua_chave_mestra_secreta

### 3. Execução

### Clone o repositório
```bash
git clone [https://github.com/jooao7/forum-hub.git](https://github.com/jooao7/forum-hub.git)
```

### Entre na pasta
```bash
cd forum-hub
```

### Execute a aplicação via Maven
```bash
./mvnw spring-boot:run
```
Desenvolvido por João Gomes
