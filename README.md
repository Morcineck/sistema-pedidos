# Sistema de Pedidos

API simples para gerenciamento de pedidos, desenvolvida como desafio.

---

## Tecnologias

- Java 17
- Spring Boot
- Maven
- Spring Data JPA
- H2 Database
- Bean Validation

## Funcionalidades

- Criar pedido
- Listar pedidos
- Consultar pedido por ID
- Alterar status do pedido

## Endpoints

### Criar pedido

`POST /pedidos`

Exemplo de requisição:

```json
{
  "cliente": "Robson",
  "itens": [
    {
      "nome": "Notebook Acer",
      "quantidade": 1,
      "valorUnitario": 5600.00
    },
    {
      "nome": "Mouse Gamer",
      "quantidade": 1,
      "valorUnitario": 300.00
    }
  ]
}
```

### Listar pedidos

`GET /pedidos`

### Consultar pedido por ID

`GET /pedidos/{id}`

### Alterar status do pedido

`PATCH /pedidos/{id}/status`

Exemplo de requisição:

```json
{
  "status": "CONFIRMADO"
}
```

## Como executar

Clone o repositório e acesse a pasta do projeto.

Execute os testes:

```bash
./mvnw clean test
```

No Windows PowerShell:

```powershell
.\mvnw clean test
```

Para iniciar a aplicação:

```bash
./mvnw spring-boot:run
```

No Windows PowerShell:

```powershell
.\mvnw spring-boot:run
```

A API ficará disponível em:

`http://localhost:8080`

## Estrutura do projeto

O projeto foi organizado separando as responsabilidades em camadas:

- `controller` - recebe as requisições HTTP
- `dto` - define os dados de entrada da API
- `service` - concentra as regras de negócio
- `repository` - realiza o acesso aos dados
- `entity` - representa os dados persistidos
- `exception` - realiza o tratamento de erros

Fluxo simplificado:

```text
Cliente / Postman
       ↓
Controller
       ↓
Service
       ↓
Repository
       ↓
H2
```

## Decisões técnicas

Foi utilizado o H2 como banco de dados por ser uma solução simples e suficiente para o escopo do desafio, permitindo executar e testar a aplicação sem depender de configuração externa de banco de dados.

Como o acesso aos dados é feito através do Spring Data JPA, a estrutura também permite uma futura troca de banco com pouco impacto na aplicação.

O valor total do pedido não é informado diretamente pelo cliente. Ele é calculado pelo backend a partir da quantidade e do valor unitário de cada item.

O status inicial também é definido automaticamente pela aplicação como `CRIADO`.

Dessa forma, campos que fazem parte das regras de negócio permanecem sob controle do backend.

## Arquitetura

O desenho da arquitetura do sistema está disponível junto à entrega do projeto.

## Escalabilidade

Se o sistema começasse a receber milhares de pedidos por minuto, um dos primeiros pontos de atenção seria o banco de dados e a quantidade de operações realizadas de forma síncrona.

Com o aumento do volume, poderiam surgir problemas relacionados à quantidade de conexões disponíveis, concorrência entre requisições, tempo de resposta e capacidade de processamento da aplicação.

Nesse cenário, seria necessário medir onde estão os principais gargalos e avaliar estratégias como escalabilidade horizontal, utilização de um banco adequado para produção, otimização das consultas e processamento assíncrono para operações que não precisem ser concluídas imediatamente.