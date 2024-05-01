package br.com.company.dao;
import java.util.List;
/**
 * Interface para a classe que maneja a conexão entre StockManager e o banco de dados
 * @author lucas
 */
public interface DaoStM <T> {
    public List<T> listar();
}