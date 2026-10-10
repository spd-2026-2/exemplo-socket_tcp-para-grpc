

package com.mycompany.servidortcp;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServidorProduto {
    public static void main(String[] args) throws Exception {

        ServerSocket servidor = new ServerSocket(9999);
        ExecutorService pool = Executors.newFixedThreadPool(5);

        System.out.println("Servidor TCP iniciado na porta 9999.");

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado.");

            pool.execute(new AtendimentoCliente(cliente));
        }
    }
}

