# stock-control-with-spring-boot

# 🧮 Controle de Estoque - Versão Spring Boot + MongoDB

Projeto desenvolvido em **Java (Spring Boot)** com integração ao **MongoDB Atlas (Nuvem)**, simulando um sistema de controle de estoque com persistência de dados NoSQL.

Esta versão é uma evolução do projeto anterior em console (com MySQL + JDBC), agora utilizando **frameworks profissionais**, como o **Spring Boot** e o **Spring Data MongoDB**. A aplicação oferece uma interface interativa via **Console (Terminal)**, permitindo gerenciamento robusto de dados com transações e agregações nativas.

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

Implementar um sistema de **gerenciamento de produtos e movimentações** (entradas e saídas de estoque) com persistência no **MongoDB**.

O foco é demonstrar:
- Modelagem de dados no formato **documento (NoSQL)** com `@Document`;
- Integração entre aplicação **Java Spring Boot** e **MongoDB Atlas**;
- Utilização de **Spring Data** para consultas, inserções e agregações sem uso de SQL;
- Uso de **Transações** e atualizações atômicas para consistência.

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
  
---
## Video demonstrando a utilizacao do programa com suas funcionalidades:
-Aqui vou deixar o link do video gravado e postado como nao listado no YouTube mostrando todas as funcionalidades do sistema

LINK:

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia              | Finalidade                                 |
|-------------------------|--------------------------------------------|
| **Java 21**             | Linguagem principal                        |
| **Spring Boot 3.5.7**   | Framework principal                        |
| **Spring Data MongoDB** | Integração e persistência no banco MongoDB |
| **MongoDB**             | Banco de dados Nao relacional              |
| **MongoDB Atlhas**      | Banco de dados não relacional em nuvem     |
| **Maven**               | Gerenciador de dependências                |
| **Spring Web**          | Exposição de endpoints REST                |
| **Gson**                | Serialização/deserialização de dados       |
| **Intellij IDE**        | IDE utilizada para fazer o projeto         |

---

## 🐧 Configuração do Ambiente (Linux)

Para executar este projeto em um ambiente Linux, você precisará dos seguintes componentes:

### 1. Java Development Kit (JDK)

- **Verificação:** Abra o terminal e digite `java -version`. Você precisa de uma versão 17 ou superior (Recomendado JDK
  21).
- **Instalação (Debian/Ubuntu):**
  ```bash
  sudo apt update
  sudo apt install openjdk-21-jdk

### 2. MongoDB (Cloud - Atlas)
- **Não é necessária instalação local:** Como o projeto utiliza o MongoDB Atlas (Database as a Service), você não precisa

- **Requisito:** A máquina deve ter acesso à internet para conectar-se ao cluster na AWS.

### 3. Maven (Build Tool)
- **Incluso no Projeto:** O projeto utiliza o Maven Wrapper (mvnw), então você não precisa instalar o Maven manualmente no
- **sistema operacional.** O script baixará as dependências automaticamente.

### 4. Código Fonte do Projeto
- **Clone o Repositório:** Use git clone para baixar o código do GitHub para sua máquina Linux.

---

## 🚀 Como Compilar e Executar o Projeto (Linux)
- Siga estas etapas no terminal Linux, estando dentro do diretório raiz do projeto (ex: ~/DEV/stock-control-with-spring-boot):

### 1. Conceder Permissão de Execução: 
- Antes de rodar pela primeira vez, garanta que o script do Maven tenha permissão de execução.

```bash 
 chmod +x mvnw
```

### 2. Compilar e Executar (Tudo em um comando):
- Utilize o wrapper do Maven para baixar as dependências do Spring Boot, compilar o código e iniciar a aplicação.

```bash
 ./mvnw spring-boot:run
```
- (**Nota** Na primeira execução, isso pode levar alguns minutos enquanto o Maven baixa as bibliotecas da internet)

### 3. Interaja com o Sistema: 
- Assim que o Spring Boot iniciar e conectar ao MongoDB Atlas, o menu principal será exibido diretamente no console. Utilize o teclado numérico para navegar nas opções.

---

## Autores

- [@Dazilio-Gabriel](https://github.com/Dazilio-Gabriel)
- [@Victor-Castro](https://github.com/Dazilio-Gabriel)
