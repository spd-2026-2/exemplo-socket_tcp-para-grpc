package com.mycompany.servidortcp;
import com.google.gson.Gson;

public class Requisicao {
    private String nome;
    private double preco;
    private int quantidade;
    private double desconto;

    public Requisicao(String nome, double preco, int quantidade, double desconto) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getDesconto() {
        return desconto;
    }

    public String paraLinha() {
        return new Gson().toJson(this);
    }

    public static Requisicao deLinha(String linha) {
        return new Gson().fromJson(linha, Requisicao.class);
    }
}
