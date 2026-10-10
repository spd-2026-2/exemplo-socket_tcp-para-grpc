
package com.mycompany.clienteproduto;

import com.mycompany.produtorpc.ProdutoServiceGrpc;
import com.mycompany.produtorpc.RequisicaoProduto;
import com.mycompany.produtorpc.RespostaProduto; 
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.concurrent.TimeUnit;

public class ClienteProduto {

    private ManagedChannel canal;
    private ProdutoServiceGrpc.ProdutoServiceBlockingStub stub;

    public void conectar() {
        canal = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        stub = ProdutoServiceGrpc.newBlockingStub(canal);
    }

    public String enviar(String nome, double preco,
            int quantidade, double desconto) {

        RequisicaoProduto req = RequisicaoProduto.newBuilder()
                .setNome(nome)
                .setPreco(preco)
                .setQuantidade(quantidade)
                .setDesconto(desconto)
                .build();

        RespostaProduto resposta = stub
                .withDeadlineAfter(5, TimeUnit.SECONDS)
                .calcularProduto(req);

        return resposta.getMensagem();
    }

    public void desconectar() {
        if (canal != null) {
            canal.shutdown();
        }
    }
}
