package br.com.company.dao;

import br.com.company.bd.Banco;
import br.com.company.entidades.Carrinho;
import br.com.company.entidades.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class PedidoDao implements DaoPedido<Pedido>{
    
    private Banco banco;

    public PedidoDao() {
        this.banco = new Banco();
    }
    
    /**
 * Salva os dados de um pedido no banco de dados.
 * 
 * @param pedido O objeto Pedido contendo os dados a serem salvos.
 * @return true se os dados foram salvos com sucesso, false caso contrário.
 * @author Lucas
 */
    public boolean salvar(Pedido pedido) {

        Connection conexao = this.banco.getConexao();
        boolean resultado = false;

        String sql = "INSERT INTO Pedido(metodoPagamento) VALUES (?)";
        PreparedStatement consulta;

        try {

            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, pedido.getmetodoPagamento().getNome());
            
            consulta.execute();
            resultado = true;

        } catch (SQLException ex) {
            resultado = false;
            System.out.println("Erro ao inserir dados do Pedido: " + ex.getMessage());
        }

        return resultado;
    }
    
/**
 * Obtém o último id do banco de dados (+ 1) para setar o id do pedido atual
 * 
 * @return O próximo ID disponível para um novo pedido.
 * @author Lucas
 */
    public int obterProximoIdPedido() {
        Connection conexao = this.banco.getConexao();
        int proximoId = 0;

        String sql = "SELECT MAX(id) FROM Pedido";
        try (Statement statement = conexao.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                proximoId = resultSet.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao obter próximo ID do pedido: " + ex.getMessage());
        }

        return proximoId;
    }
}
