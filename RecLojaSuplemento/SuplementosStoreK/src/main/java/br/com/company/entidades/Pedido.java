/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.company.entidades;

import java.util.ArrayList;

/**
 * Representa o pedido efetuado pelo cliente 
 * @author lucas
 */
public class Pedido {
    private int id;
    private ArrayList<Produto> itens;
    private MetodoPagamento metodoPagamento;

    public Pedido() {
        this.itens = new ArrayList<>();
        metodoPagamento = new MetodoPagamento();
    }
    
    public Pedido(ArrayList<Produto> itens) {
        this.itens = itens;
        metodoPagamento = new MetodoPagamento();
    }
    
    public MetodoPagamento getmetodoPagamento() {
        return metodoPagamento;
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }
    
    public void setItens( ArrayList<Produto> pedido) {
        this.itens = pedido;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   
    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : itens) {
            total += produto.getPreco() * produto.getQuantidadeDisponivel();
        }
        return total;
    }
    
}
