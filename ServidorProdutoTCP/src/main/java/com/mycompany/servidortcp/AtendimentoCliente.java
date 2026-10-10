
package com.mycompany.servidortcp;


import java.io.*;
import java.net.Socket;
import java.util.Locale;

public class AtendimentoCliente implements Runnable {

    private Socket cliente;

    public AtendimentoCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try (
            Socket socket = cliente;
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter saida = new PrintWriter(
                    socket.getOutputStream(), true)
        ) {
            String linha;

            while ((linha = entrada.readLine()) != null) {

                Requisicao req = Requisicao.deLinha(linha);

                double total = req.getPreco() * req.getQuantidade();
                total = total * (1 - req.getDesconto() / 100);

                String mensagem = String.format(
                        Locale.forLanguageTag("pt-BR"),
                        "Produto: %s | Total com desconto: R$ %.2f",
                        req.getNome(), total);

                saida.println(mensagem);

            }

        } catch (IOException e) {
            System.out.println("Erro na comunicação: " + e.getMessage());
        }

        System.out.println("Atendimento encerrado.");
    }
}
