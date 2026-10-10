
package com.mycompany.clienteproduto;

import java.io.*;
import java.net.Socket;

public class ClienteProduto {

    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter saida;

    public void conectar() throws IOException {
        socket = new Socket("localhost", 9999);

        entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        saida = new PrintWriter(socket.getOutputStream(), true);
    }

    public String enviar(Requisicao req) throws IOException {
        // Envia o objeto convertido em JSON
        saida.println(req.paraLinha());

        if (saida.checkError()) {
            throw new IOException("Falha ao enviar requisição.");
        }

        // Aguarda a resposta do servidor (String simples)
        String resposta = entrada.readLine();

        if (resposta == null) {
            throw new IOException("Servidor encerrou a conexão.");
        }

        return resposta;
    }

    public void desconectar() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
