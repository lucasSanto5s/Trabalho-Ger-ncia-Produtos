package br.com.company.dao;
/**
 * Interface para a classe que maneja a conexão entre pedido e o banco de dados
 * @author lucas
 */
public interface DaoPedido <T>{
        public boolean salvar(T t);
}
