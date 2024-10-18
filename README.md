# Microserviço de Usuários

Este microserviço é responsável por salvar usuários em um banco de dados PostgreSQL. Quando um novo usuário é salvo, uma mensagem é enviada para uma fila do RabbitMQ, que será processada por outro microserviço.

## Tecnologias Utilizadas

- **Java**: 17
- **Spring Boot**: Última versão
- **PostgreSQL**: 17
- **RabbitMQ**: Utiliza CloudAMQP
- **Gmail SMTP**: Para envio de e-mails

## Pré-requisitos

1. **Java 17**: Certifique-se de que o Java 17 está instalado em sua máquina.
2. **PostgreSQL 17**: Você precisa ter o PostgreSQL instalado e em execução.
3. **Conta no CloudAMQP**: Crie uma conta e configure seu RabbitMQ na [CloudAMQP](https://www.cloudamqp.com/).
4. **Configuração do Gmail**: Para enviar e-mails, você precisará configurar a senha de aplicativo. Consulte as instruções [aqui](https://support.google.com/accounts/answer/185833?hl=pt-BR).

## Configuração do Banco de Dados

No arquivo `src/main/resources/application.properties`, atualize as seguintes configurações:

```properties
# URL do banco de dados
spring.datasource.url=jdbc:postgresql://localhost/Nome_Do_Banco_De_Dados
spring.datasource.username=Seu_Usuario_Do_Banco
spring.datasource.password=Sua_Senha_Do_Banco
```

## Contribuições
Sinta-se à vontade para contribuir para o projeto! Qualquer feedback é bem-vindo.
