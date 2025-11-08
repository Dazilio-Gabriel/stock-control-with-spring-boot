# stock-control-with-spring-boot
# 🧮 Controle de Estoque - Versão Spring Boot + MongoDB

Projeto desenvolvido em **Java (Spring Boot)** com integração ao **MongoDB**, simulando um sistema de controle de estoque moderno com API REST.  
Esta versão é uma evolução do projeto anterior em console (com MySQL + JDBC), agora utilizando **frameworks profissionais**, como o **Spring Boot** e o **Spring Data MongoDB**, permitindo operações via **endpoints HTTP** e conexão automática com o banco **NoSQL** MongoDB.

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

Implementar um sistema de **gerenciamento de produtos e movimentações** (entradas e saídas de estoque), desta vez com **arquitetura baseada em API REST** e persistência no **MongoDB**.  
O foco é demonstrar:
- Modelagem de dados no formato **documento (NoSQL)**;
- Integração entre aplicação **Java Spring Boot** e **MongoDB**;
- Utilização de **Spring Data** para consultas, inserções e exclusões sem uso de SQL.

---

## ✨ Funcionalidades Implementadas

- **📦 Produtos**
    - Cadastro, listagem, atualização e exclusão lógica;
    - Cada produto possui nome, descrição e quantidade em estoque.

- **🔁 Movimentações**
    - Registro de entradas e saídas de produtos;
    - Atualização automática do estoque do produto associado.

- **📊 Relatórios**
    - Consulta de movimentações por tipo (entrada/saída);
    - Total de movimentações agrupado por produto.

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Finalidade |
|-------------|-------------|
| **Java 21** | Linguagem principal |
| **Spring Boot 3.5.7** | Framework principal |
| **Spring Data MongoDB** | Integração e persistência no banco MongoDB |
| **MongoDB** | Banco de dados NoSQL |
| **Maven** | Gerenciador de dependências |
| **Lombok** | Simplificação do código (getters/setters automáticos) |
| **Spring Web** | Exposição de endpoints REST |
| **Gson** | Serialização/deserialização de dados |

---
