
### 📦 Sistema de Controle de Estoque

Um sistema de gerenciamento e controle de estoque desenvolvido em **Java** com **Spring Boot**, utilizando **MongoDB** como banco de dados NoSQL e **Docker** para orquestração/containerização da aplicação.

---

## 🚀 Tecnologias Utilizadas

- **Java**
- **Spring Boot**: Framework principal para construção da API REST.
- **MongoDB**: Banco de dados NoSQL para armazenamento de produtos.
- **Docker & Docker Compose**: Containerização do banco de dados e/ou aplicação.
- **Git**: Controle de versão e hospedagem do código.

---

## 📋 Funcionalidades

O sistema conta com um formulário e cadastro completo de produtos com os seguintes campos:

- **Nome do Produto** (`String`): Nome identificador do item.
- **Código** (`String` / `Long`): Código único de rastreio ou barras.
- **Fornecedor** (`String`): Nome do fornecedor responsável.
- **Preço** (`BigDecimal`): Valor unitário do produto.
- **Estoque** (`Integer`): Quantidade disponível no inventário.

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos

- Java
- Docker
- Git
- MongoDB


⚙️ Comandos úteis Docker

- Parar containers

```
docker-compose down
```

- Apenas parar sem remover

```
docker-compose stop
```

- Rebuildar somente frontend

```
docker-compose build frontend
```

- Rebuildar somente backend

```
docker-compose build backend
```

---

## ⚙️ Comandos úteis Git

- Inicialização do repositório local:

```
git init
```
- Criação nova branch:

```
git checkout -b new-branch
```
- Commits:

```
git add .
git commit -m "implementação do CRUD de estoque com MongoDB"
```
- Commits:

```
git add .
git commit -m "implementação do CRUD de estoque com MongoDB"
```

- Repositório remoto:

```
git remote add origin https://github.com/Thacianetads/aplicacao_estoque.git
```

- Envio informações repositório remoto:

```
git push origin master
```



