package br.com.company.dao;

import java.util.List;
/**
 * Interface para a classe que maneja a conexão entre o produto e o banco de dados
 * @author lucas
 */
public interface DaoProduto<T> {

    public boolean salvar(T t);
    public List<T> listar();
    public T get(int codigo);
    public boolean atualizar(T t);
    public boolean excluir(T t);
    public boolean excluirPorId(int codigo);
    public T salvarRetornandoId(T t);

}
