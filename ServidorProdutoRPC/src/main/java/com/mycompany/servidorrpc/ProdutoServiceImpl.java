
package com.mycompany.servidorrpc;

import com.mycompany.produtorpc.ProdutoServiceGrpc;
import com.mycompany.produtorpc.RequisicaoProduto;
import com.mycompany.produtorpc.RespostaProduto;
import io.grpc.stub.StreamObserver;
import java.util.Locale;

public class ProdutoServiceImpl extends ProdutoServiceGrpc.ProdutoServiceImplBase {

    @Override
    public void calcularProduto(RequisicaoProduto req,
            StreamObserver<RespostaProduto> observador) {

        double total = req.getPreco() * req.getQuantidade();
        total = total * (1 - req.getDesconto() / 100);

        String mensagem = String.format(
                Locale.forLanguageTag("pt-BR"),
                "Produto: %s | Total com desconto: R$ %.2f",
                req.getNome(), total);

        RespostaProduto resposta = RespostaProduto.newBuilder()
                .setMensagem(mensagem)
                .build();

        observador.onNext(resposta);
        observador.onCompleted();
    }
}
