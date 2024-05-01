package br.com.company.entidades;

import br.com.company.bd.Banco;
import javax.swing.JOptionPane;

/**
 * Classe que representa o Produto
 * @author Kauan
 */
public class Produto {
    
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeDisponivel;
    private String categoria;
    private int Pedido_id;
    private Banco banco;
/**
 * Cria um novo objeto Produto com os dados fornecidos sem o id, Caso seja necessário setar o id carrinho.
 * 
 */
    public Produto( String nome, double preco, String descricao,  String categoria,int  quantidadeDisponivel, int carrinhoID) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.categoria= categoria;
        this.Pedido_id = carrinhoID;
    }
/**
 * Cria um novo objeto Produto com os dados fornecidos, com o id.
 * 
 */  
    public Produto(int id,  String nome, double preco, String descricao,  String categoria,int  quantidadeDisponivel,int pedido_id) {
        this.id= id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.categoria= categoria;
        this.Pedido_id = pedido_id;
    }
/**
 * Cria um novo objeto Produto com os dados fornecidos, sem o id_Pedido.
 * 
 */      
    public Produto(int id,  String nome, double preco, String descricao,  String categoria,int  quantidadeDisponivel) {
        this.id= id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.categoria= categoria;
   
    }
  
    public Produto() {
        this.banco = new Banco();
    }

    public int getPedido_id() {
        return Pedido_id;
    }

    public void setPedido_id(int Pedido_id) {
        this.Pedido_id = Pedido_id;
    }
             
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
     
/**
 * Verifica se o nome, valor e quantidade fornecidos são válidos.
 * 
 * @param nome O nome a ser verificado.
 * @param valor O valor a ser verificado.
 * @param quantidade A quantidade a ser verificada.
 * @return true se o nome, valor e quantidade forem válidos; false caso contrário.
 */
    public boolean verificarValorNome(String nome, String valor, String quantidade) {
        // Verifica se o nome contém apenas letras do alfabeto
        if (!contemApenasLetras(nome)) {
            JOptionPane.showMessageDialog(null, "Somente letras são permitidas no nome", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Tenta converter o valor para um número
        try {
            double numero = Double.parseDouble(valor);
            // Tenta converter a quantidade para um número inteiro
            try {
                int numeroQ = Integer.parseInt(quantidade);
                return true; // Se todas as verificações passarem, retorna verdadeiro
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Somente números inteiros são permitidos na quantidade", "Erro!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Somente números são permitidos no valor", "Erro!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private boolean contemApenasLetras(String str) {
        String alfabeto = "abcdefghijklmnopqrstuvwxyz ";
        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            if (!alfabeto.contains(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }
}
