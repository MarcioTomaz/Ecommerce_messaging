# 📦 Projeto de Estudo: Mensageria com Kafka e MongoDB

Este projeto foi desenvolvido com o objetivo de estudar e praticar conceitos de **mensageria assíncrona** utilizando **Apache Kafka** e **MongoDB**. Ele faz parte de um ecossistema maior que simula um sistema de e-commerce com backend em Java (Spring Boot) e frontend em React.

## 🎯 Objetivo

O foco principal deste projeto é:

- Entender a comunicação assíncrona entre sistemas usando **Apache Kafka**
- Praticar o consumo e a persistência de mensagens usando **MongoDB**
- Estudar estratégias de **desacoplamento entre serviços**
- Criar uma estrutura de **auditoria de eventos** para pedidos.

## 🔗 Projetos Relacionados

Este projeto funciona em conjunto com:

- 🧠 **Backend (Java + Spring Boot)**  
  Repositório: [Ecommerce-estudo - Branch Messaging](https://github.com/MarcioTomaz/Ecommerce-estudo/tree/Messaging)  
  Responsável por produzir mensagens Kafka com eventos de pedidos.

- 🎨 **Frontend (React + Vite)**  
  Repositório: [Ecommerce-Frontend-React](https://github.com/MarcioTomaz/Ecommerce-Frontend-React)  
  Interface do sistema de e-commerce. Indiretamente relacionado à mensageria.

---

## 🛠 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Apache Kafka
- MongoDB
- Spring Data MongoDB
- Docker (para Kafka e MongoDB localmente)

---

## 💡 Funcionalidades

- ✅ Consumidor Kafka que escuta eventos de pedidos (`order-status`)
- ✅ Persistência dos eventos em uma coleção MongoDB
- ⏳ Simulação de logs de auditoria (ex: PEDIDO_REALIZADO, PAGO, ENVIADO)
- 🔜 Fallback e retries para mensagens que falharem

---

## 📁 Estrutura esperada dos eventos Kafka

```json
{
    _id: ObjectId('6827b99a7505ea289a66b411'),
    orderId: Long('22'),
    status: 'CANCELED',
    refuseReason: 'teste',
    userLog: {
      email: 'marcioEmail22',
      name: 'marcioEmail22',
      Id: Long('1'),
      userRole: 'ADMIN'
    },
    timestamp: ISODate('2025-05-16T22:18:01.044Z'),
    _class: 'com.example.ecommerce_messaging.model.OrderLog'
  }
