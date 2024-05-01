
package br.com.company.entidades;

/**
 * Classe que representa o método de pagamento
 * @author lucas
 */
public class MetodoPagamento {
    private String nome;
    
    public void setMetodoPagamentoCartaoCredito() {
        this.nome = "Cartão de Crédito";
    }

    public void setMetodoPagamentoCartaoDebito() {
        this.nome = "Cartão de Débito";
    }

    public void setMetodoPagamentoPix() {
        this.nome = "Pix";
    }

    public void setMetodoPagamentoDinheiro() {
        this.nome = "Dinheiro";
    }
    
    public String getNome(){
        return nome;
    }
    
}
