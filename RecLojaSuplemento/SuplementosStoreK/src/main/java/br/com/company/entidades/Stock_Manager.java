package br.com.company.entidades;

import br.com.company.bd.Banco;
/**
 * Classe que representa o StockManager
 * @author Kauan
 */
public class Stock_Manager {
    private int id;
    private String nome;
    private String senha;
    private Banco banco;

    public Stock_Manager(Banco banco) {
        this.banco = banco;
    }
    public Stock_Manager(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    public Stock_Manager(int id,String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
}
