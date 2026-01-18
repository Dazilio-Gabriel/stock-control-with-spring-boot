# 🧮 Controle de Estoque - Spring Boot + MongoDB

Projeto desenvolvido em **Java com Spring Boot** e integração ao **MongoDB**, simulando um sistema de controle de
estoque com persistência NoSQL, regras de negócio, relatórios e testes automatizados.

Esta aplicação é a evolução de uma versão anterior em console (MySQL + JDBC), agora utilizando **Spring Boot**, **Spring
Data MongoDB**, **arquitetura em camadas** e **testes com JUnit e Mockito**.

---

## 👨‍🏫 Disciplina e Professor

- **Disciplina:** Banco de Dados
- **Professor:** Howard Roatti

---

## 👥 Integrantes

- Gabriel Dazilio Fanchiotti

---

## 🎯 Objetivo

Implementar um sistema de **gerenciamento de produtos e movimentações (entrada e saída)** com:

- Persistência em **MongoDB**
- Arquitetura em camadas (Controller, Service, Repository)
- Regras de negócio com consistência transacional
- Relatórios com **Aggregation Framework**
- Testes unitários com **JUnit 5** e **Mockito**

---

## ✨ Funcionalidades

### 📦 Produtos

- Cadastro
- Listagem
- Atualização
- Remoção com validação de integridade
- Busca por **ID** e por **Nome**

### 🔄 Movimentações

- Registro de ENTRADA e SAÍDA
- Atualização automática do estoque com `$inc`
- Controle transacional com `@Transactional`

### 📊 Relatórios

- Total de movimentações por tipo (Aggregation)
- Contagem de registros
- Splash screen com dados do banco ao iniciar

### 🧪 Testes

- Testes unitários da camada Service
- Uso de:
    - `@Mock`
    - `@InjectMocks`
    - `Mockito.when()`
    - `Optional`
    - `assertThrows()`
    - Padrão AAA (Arrange, Act, Assert)

---

## 🛠️ Tecnologias

| Tecnologia          | Uso          |
|---------------------|--------------|
| Java 21             | Linguagem    |
| Spring Boot 3       | Framework    |
| Spring Data MongoDB | Persistência |
| MongoDB             | Banco NoSQL  |
| JUnit 5             | Testes       |
| Mockito             | Mocks        |
| Maven               | Build        |
| IntelliJ IDEA       | IDE          |

---

### 📂 Estrutura do Projeto

- `controller` – Camada de apresentação (APIs / Console)
- `service` – Regras de negócio e validações
- `repository` – Acesso a dados (Spring Data MongoDB)
- `model` – Entidades e documentos
- `dto` – Objetos de transferência de dados
- `tests` – Testes unitários com JUnit e Mockito

---

## 🚀 Como Executar o Projeto

### 📋 Pré-requisitos

Certifique-se de ter instalado em sua máquina:

- **Java JDK 17+** (recomendado JDK 21)  
  Verifique com: `java -version`
- **MongoDB** (local) ou conta no **MongoDB Atlas**
- **Git**
- Terminal (Linux, macOS ou Windows com WSL)

---

### ▶️ Passo a Passo para Execução

1. Clone o repositório:

```bash
  git clone https://github.com/Dazilio-Gabriel/stock-control-with-spring-boot
```

2. Acesse a pasta do projeto:

```bash 
  cd stock-control-with-spring-boot
```

3. Conceda permissão de execução ao Maven Wrapper (Linux/macOS):

```bash 
  chmod +x mvnw
```
4. Compile e execute a aplicação:

```bash 
  ./mvnw spring-boot:run
```