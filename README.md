# Lending

Este projeto possui uma API POST, onde recebe os dados da pessoa e retorna quais empréstimos ela consegue receber.

## 🚀 Starting development enviroment

Basta clonar o repositório e rodar o projeto.

## 💻 Dependencies (APIs)

Precisa ter o Java na versão 17 instalado.

## ⚙️ Testing

O projeto possui teste unitário para validar o retorno da API.

## 🔧 Exemple cURL

```
curl --location --request POST 'http://localhost:8080/lending' \
--header 'Content-Type: application/json' \
--data-raw '{
  "cliente": {
    "nome": "teste teste",
    "cpf": "123.456.789-10",
    "idade": 29,
    "uf": "SP",
    "renda_mensal": 5000
  }
}'
```

