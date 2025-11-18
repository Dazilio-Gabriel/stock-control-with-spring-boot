# stock-control-with-spring-boot

# 🧮 Controle de Estoque - Versão Spring Boot + MongoDB

Projeto desenvolvido em **Java (Spring Boot)** com integração ao **MongoDB**, simulando um sistema de controle de
estoque moderno com API REST.  
Esta versão é uma evolução do projeto anterior em console (com MySQL + JDBC), agora utilizando **frameworks
profissionais**, como o **Spring Boot** e o **Spring Data MongoDB**, permitindo operações via **endpoints HTTP** e
conexão automática com o banco **NoSQL** MongoDB.

---

## 👨‍🏫 Disciplina e Professor

- **Disciplina:** Banco de Dados
- **Professor:** Howard Roatti

---

## 👥 Integrantes do Grupo

- Gabriel Dazilio Fanchiotti
- Victor Castro

---

## 🚀 Objetivo do Projeto

Implementar um sistema de **gerenciamento de produtos e movimentações** (entradas e saídas de estoque), desta vez com *
*arquitetura baseada em API REST** e persistência no **MongoDB**.  
O foco é demonstrar:

- Modelagem de dados no formato **documento (NoSQL)**;
- Integração entre aplicação **Java Spring Boot** e **MongoDB**;
- Utilização de **Spring Data** para consultas, inserções e exclusões sem uso de SQL.

---

## ✨ Funcionalidades Implementadas

O sistema oferece as seguintes funcionalidades através de um menu interativo no console:

- `📊 Relatórios:`
    - **Listagem Geral:** Exibição de todas as movimentações com os dados do produto associado (resolução de referência
      via `@DBRef`).
    - **Agregação:** Relatório estatístico utilizando o framework nativo do MongoDB (`aggregation`) para somar totais
      por tipo (ENTRADA/SAIDA).

- `➕ Inserir Registro:`
    - Cadastro de Produtos e Movimentações via console.
    - **Lógica de Negócio:** Atualização automática e atômica do estoque (`$inc`) a cada nova movimentação.
    - **Segurança:** Uso de `@Transactional` para garantir a consistência dos dados entre as coleções.
    - Loop de repetição para inserções múltiplas.

- `➖ Remover Registro:`
    - Remoção de documentos pelo ID (MongoDB `_id`).
    - **Integridade:** Verificação prévia que impede a exclusão de um Produto caso existam Movimentações associadas a
      ele (Item 7.c.i do Edital).
    - Confirmação de segurança antes de efetivar a exclusão.

- `🔄 Atualizar Registro:`
    - Busca e edição de documentos existentes nas coleções `products` e `movements`.
    - Permite alterar nome, descrição e saldo de produtos, ou corrigir lançamentos de movimentações.

- `🖥️ Interface (Console):`
    - **Splash Screen:** Tela inicial dinâmica exibindo a contagem em tempo real de documentos nas coleções.
    - Menu de navegação numérico com tratamento de erros de entrada.

## 🛠️ Tecnologias Utilizadas

| Tecnologia              | Finalidade                                 |
|-------------------------|--------------------------------------------|
| **Java 21**             | Linguagem principal                        |
| **Spring Boot 3.5.7**   | Framework principal                        |
| **Spring Data MongoDB** | Integração e persistência no banco MongoDB |
| **MongoDB**             | Banco de dados Nao relacional              |
| **MongoDB Atlhas**      | Banco de dados nçao relacional em nuvem    |
| **Maven**               | Gerenciador de dependências                |
| **Spring Web**          | Exposição de endpoints REST                |
| **Gson**                | Serialização/deserialização de dados       |
| **Intellij IDE**        | IDE utilizada para fazer o projeto         |

---
