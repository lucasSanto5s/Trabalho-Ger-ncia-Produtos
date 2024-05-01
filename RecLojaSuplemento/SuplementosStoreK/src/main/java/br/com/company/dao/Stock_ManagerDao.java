package br.com.company.dao;
import br.com.company.bd.Banco;
import br.com.company.entidades.Stock_Manager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe que maneja a conexão entre o produto e o banco de dados
 * @author Lucas
 */
public class Stock_ManagerDao implements DaoStM <Stock_Manager>{
    
    private Banco banco;

    public Stock_ManagerDao() {
        this.banco = new Banco();
    }
    
/**
* Metodo de teste que retorna por System.out.println os dados do StockManager
* @author Lucas
*/
    public void listarTela(){
        
        Connection conexao = this.banco.getConexao();
                
        String sql = "SELECT * FROM stockmanager";        
        ResultSet resultados;
        try {
                       
        resultados = conexao.createStatement().executeQuery(sql);
            while (resultados.next()) {
                System.out.println("ID = " + resultados.getInt("id")
                        + ", Nome = " + resultados.getString("nome")
                        + ", Senha = " + resultados.getString("senha"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro na leitura de dados do BD: "+ex.getMessage());
        }
    }
    
    /**
     * Metodo que executa o comando SELECT, tratando em objetos os registros encontrados
     * @return List <produto> uma lista contendo os registros em objetos Pessoa ou vazia se nada encontrar
     */
    public List<Stock_Manager> listar(){
        
        Connection conexao = this.banco.getConexao();
        ArrayList<Stock_Manager> lista = new ArrayList<>();
                
        String sql = "SELECT * FROM stockmanager";        
        ResultSet resultados;
        
        try {
            
            resultados = conexao.createStatement().executeQuery(sql);
            Stock_Manager objeto;         
            while (resultados.next()) {
                // Obtendo os valores dos campos do resultado
                int idStockManager = resultados.getInt("id");
                String nomeStockManager = resultados.getString("nome");
                String senhaStockManager = resultados.getString("senha");

                // Criando o objeto StockManager
                Stock_Manager stockManager = new Stock_Manager(idStockManager, nomeStockManager, senhaStockManager);

                // Adicionando o objeto à lista
                lista.add(stockManager);
            }
        
        } catch (SQLException ex) {
            System.out.println("Erro na leitura de dados do BD: "+ex.getMessage());
        }
        
        return lista;
    }
    
   
}
