package br.com.company.entidades;
import java.util.ArrayList;
/**
 * Representa o carrinho de compras do cliente.
 * @author Kauan
 */
public class Carrinho {
    private ArrayList<Produto> itens;
   

    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    public Carrinho(ArrayList<Produto> itens) {
        this.itens = itens;
       
    }

    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    public void removerItem(Produto produto) {
        itens.remove(produto);
    }

    public void limparCarrinho() {
        itens.clear();
    }

    public ArrayList<Produto> getItens() {
        return itens;
    }
    
    public void adicionarProduto(String nome, double valor, String descricao, String categoria, int quantidade, int idCarrinho) {
        Produto produto = new Produto(nome, valor, descricao, categoria, quantidade,idCarrinho);
        itens.add(produto);
    }
 
    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : itens) {
            total += produto.getPreco() * produto.getQuantidadeDisponivel();
        }
        return total;
    }
}
