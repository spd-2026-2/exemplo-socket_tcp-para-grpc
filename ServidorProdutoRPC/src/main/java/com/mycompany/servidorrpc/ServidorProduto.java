
package com.mycompany.servidorrpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ServidorProduto {

    public static void main(String[] args) throws Exception {
        Server servidor = ServerBuilder.forPort(50051)
                .addService(new ProdutoServiceImpl())
                .build()
                .start();

        System.out.println("Servidor gRPC iniciado na porta 50051.");

        servidor.awaitTermination();
    }
}


