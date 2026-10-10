# Exemplo – do Socket TCP ao gRPC

Mesmo sistema (cálculo do total de um produto com desconto) em duas versões, para comparar a comunicação por Socket TCP com a chamada remota via gRPC.

| Projeto | Descrição | Porta |
|---|---|---|
| ServidorProdutoTCP | Servidor com ServerSocket, pool de threads e JSON (Gson) | 9999 |
| ClienteProdutoTCP | Cliente Swing via Socket | 9999 |
| ServidorProdutoRPC | Servidor gRPC (contrato em `src/main/proto/produto.proto`) | 50051 |
| ClienteProdutoRPC | Cliente Swing via stub gRPC | 50051 |

## Como executar
1. Abra o projeto no NetBeans (Maven).
2. Nos projetos RPC, rode **Clean and Build** antes de executar, para gerar as classes a partir do `.proto`.
3. Execute primeiro o servidor e depois o cliente da mesma versão (TCP com TCP, RPC com RPC).

## Principais substituições
| Socket TCP | gRPC |
|---|---|
| Requisicao.java e Gson | RequisicaoProduto gerada do .proto |
| paraLinha() / deLinha() | serialização automática |
| ServerSocket / accept() | ServerBuilder e serviço registrado |
| AtendimentoCliente | ProdutoServiceImpl |
| saida.println(mensagem) | observador.onNext(resposta) |
| Socket | ManagedChannel + stub |
