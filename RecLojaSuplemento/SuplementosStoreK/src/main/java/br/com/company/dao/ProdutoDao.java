package br.com.company.dao;

import br.com.company.bd.Banco;
import br.com.company.entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe que gerencia a conexão entre o produto e o banco de dados
 * @author lucas
 */
public class ProdutoDao implements DaoProduto<Produto>{
    
    private Banco banco;

    public ProdutoDao() {
        this.banco = new Banco();
    }
    
    /**
     * Metodo para executar o comando INSERT, salvando no banco de dados o objeto concreto
     * @return true se realizou o insert, false do contrario
     * @author Lucas
     */
    public boolean salvar(Produto produto){
        
        Connection conexao = this.banco.getConexao();
        boolean resultado = false;
        
        String sql = "INSERT INTO Produto(nome,valor,descricao,categoria,quantidade,Pedido_id) VALUES (?,?,?,?,?,?)";
        PreparedStatement consulta;
        
        try {
            
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, produto.getNome());
            consulta.setString(2, Double.toString(produto.getPreco()));
            consulta.setString(3, produto.getDescricao());
            consulta.setString(4, produto.getCategoria());
            consulta.setString(5, Integer.toString(produto.getQuantidadeDisponivel()));
            consulta.setString(6, Integer.toString(produto.getPedido_id()));
            consulta.execute();
            resultado = true;
            
        } catch (SQLException ex) {
            resultado = false;
            System.out.println("Erro ao inserir dados do Produto: "+ex.getMessage());
        }
        
        return resultado;   
    }
    
    /**
     * Metodo para testes
     */
    public void listarTela(){
        
        Connection conexao = this.banco.getConexao();
                
        String sql = "SELECT * FROM Produto";        
        ResultSet resultados;
        try {
            
            resultados = conexao.createStatement().executeQuery(sql);
            while(resultados.next()){
              System.out.println("ID = " + resultados.getString("id") + 
                   ", Nome = " + resultados.getString("nome") +
                   ", Valor = " + resultados.getDouble("valor") + // Supondo que 'valor' seja um campo numérico
                   ", Descrição = " + resultados.getString("descricao") +
                   ", Categoria = " + resultados.getString("categoria") +
                   ", Quantidade = " + resultados.getInt("quantidade"));
            }
        
        } catch (SQLException ex) {
            System.out.println("Erro na leitura de dados do BD: "+ex.getMessage());
        }
    }
    
    /**
     * Metodo que executa o comando SELECT, tratando em objetos os registros encontrados
     * @return List <produto> uma lista contendo os registros em objetos Pessoa ou vazia se nada encontrar
     */
    public List<Produto> listar(){
        
        Connection conexao = this.banco.getConexao();
        ArrayList<Produto> lista = new ArrayList<>();
                
        String sql = "SELECT * FROM Produto";        
        ResultSet resultados;
        
        try {
            
            resultados = conexao.createStatement().executeQuery(sql);
            Produto objeto;         
            while (resultados.next()) {
                // Obtendo os valores dos campos do resultado
                int idProduto = Integer.parseInt(resultados.getString("id"));
                String nomeProduto = resultados.getString("nome");
                double valorProduto = Double.parseDouble(resultados.getString("valor"));
                String descricaoProduto = resultados.getString("descricao");
                String categoriaProduto = resultados.getString("categoria");
                int quantidadeProduto = Integer.parseInt(resultados.getString("quantidade"));
                int Pedido_id = Integer.parseInt(resultados.getString("Pedido_id"));

                // Criando o objeto Produto
                Produto produto = new Produto(idProduto,nomeProduto, valorProduto, descricaoProduto, categoriaProduto, quantidadeProduto,Pedido_id);

                // Adicionando o objeto à lista
                lista.add(produto);
            }
        
        } catch (SQLException ex) {
            System.out.println("Erro na leitura de dados do BD: "+ex.getMessage());
        }
        
        return lista;
    }
    
    /**
     * Metodo que retorna um objeto com os dados de um registro, pesquisado pelo parametro 
     * @param codigo o identificador do registro no banco de dados
     * @return Pessoa objeto contendo os dados do registro encontraddo, objeto null caso nao encontrar
     */
    public Produto get(int codigo){
        Connection conexao = this.banco.getConexao();
                
        String sql = "SELECT * FROM Produto WHERE id = ?";     
        PreparedStatement consulta;
        ResultSet resultado;
        
        Produto objeto = null;        
        try {

            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, codigo);
            resultado = consulta.executeQuery();            
            if (resultado.next()) {
                // Obtendo os valores dos campos do resultado
                int idProduto = resultado.getInt("id");
                String nomeProduto = resultado.getString("nome");
                double valorProduto = resultado.getDouble("valor");
                String descricaoProduto = resultado.getString("descricao");
                String categoriaProduto = resultado.getString("categoria");
                int quantidadeProduto = resultado.getInt("quantidade");

                // Criando o objeto Produto
                Produto produto = new Produto(idProduto, nomeProduto, valorProduto, descricaoProduto, categoriaProduto, quantidadeProduto);            
            }    
        } catch (SQLException ex) {
            System.out.println("Erro na leitura de dados do BD: "+ex.getMessage());
        }
        
        return objeto;
    }
    
    /**
     * Metodo que executa o comando UPDATE, precisa ter pesquisado previamente pelo registro 
     * @param produto  objeto a ser atualizado no BD
     * @return boolean true se atualizou ou false do contrario
     */
    public boolean atualizar(Produto produto){
        
        Connection conexao = this.banco.getConexao();
                
        String sql = "UPDATE produto SET nome = ?, valor = ?, descricao = ?, categoria = ?, quantidade = ? WHERE id = ?";   
        PreparedStatement consulta;
        boolean atualizado = false;
                
        try {
            
            consulta = conexao.prepareStatement(sql);
            consulta.setString(1, produto.getNome()); // Obtendo o novo nome do produto
            consulta.setDouble(2, produto.getPreco()); // Obtendo o novo valor do produto
            consulta.setString(3, produto.getDescricao()); // Obtendo a nova descrição do produto
            consulta.setString(4, produto.getCategoria()); // Obtendo a nova categoria do produto
            consulta.setInt(5, produto.getQuantidadeDisponivel()); // Obtendo a nova quantidade do produto
            consulta.setInt(6, produto.getId()); // Obtendo o ID do produto que você deseja atualizar


            int linhasAtualizadas = consulta.executeUpdate();


            if (linhasAtualizadas > 0) {
                System.out.println("Atualização bem-sucedida.");
                atualizado = true;
            } 
            
        } catch (SQLException ex) {
            atualizado = false;
            System.out.println("Não é possível atualizar o registro: "+ex.getMessage());
        }
        
        return atualizado;
    }
    
    /**
     * Realiza a execucao do comando DELETE, precisa ser pesquisado pelo registro anteriormente
     * @param produto objeto com dados para ser removido do BD
     * @return boolean true se excluiu ou false do contrario
     */
    public boolean excluir(Produto produto){
        
        Connection conexao = this.banco.getConexao();
                
        String sql = "DELETE FROM Produto WHERE id = ?";     
        PreparedStatement consulta;
        boolean excluido = false;
                
        try {
            
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, produto.getId());
            int linhasExcluidas = consulta.executeUpdate();
            if( linhasExcluidas > 0) excluido = true;
            
        } catch (SQLException ex) {
            excluido = false;
            System.out.println("Não é possível excluir o registro: "+ex.getMessage());
        }
        
        return excluido;        
    }
    
    /**
     * Mesmo que o metodo excluir() porem nao depende de ter pesquisado previamente o registro
     * @param codigo um inteiro identificador do registro no BD
     * @return boolean true se excluiu ou false do contrario
     */
    public boolean excluirPorId(int codigo){
        
        Connection conexao = this.banco.getConexao();
                
        String sql = "DELETE FROM produto WHERE id = ?";     
        PreparedStatement consulta;
        boolean excluido = false;
                
        try {
            
            consulta = conexao.prepareStatement(sql);
            consulta.setInt(1, codigo);
            int linhasExcluidas = consulta.executeUpdate();
            if(linhasExcluidas > 0) excluido = true;            
            
        } catch (SQLException ex) {
            excluido = false;
            System.out.println("Não é possível excluir o registro: "+ex.getMessage());
        }
        
        return excluido; 
    }
    
    
    /**
     * Este metodo e util quando for necessario saber o ultimo id inserido para a PK do registro. 
     * Pode ser utilizado individualmente ou em conjunto com outros metodos para a persistencia com objetos associados (relacoes).     
     * O ID do registro ficara na propriedad id do objeto
     * @param produto objeto a ser persistido
     * @return Pessoa objeto com a propriedade id atualizada se realizou o insert
     */
    public Produto salvarRetornandoId(Produto produto){
        Connection conexao = this.banco.getConexao();   

      
        String sql = "INSERT INTO Produto(nome,valor,descricao,categoria,quantidade,Pedido_id) VALUES (?,?,?,?,?,?)";
        PreparedStatement consulta;
        
        try {
            
            consulta = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            consulta.setString(1, produto.getNome());
            consulta.setDouble(2, produto.getPreco()); // Corrigindo para usar o valor do produto
            consulta.setString(3, produto.getDescricao());
            consulta.setString(4, produto.getCategoria());
            consulta.setInt(5, produto.getQuantidadeDisponivel());
            consulta.setInt(6, produto.getPedido_id());

            // Executando a inserção
            consulta.executeUpdate();
            
        } catch (SQLException ex) {            
            System.out.println("Erro ao inserir dados do Produto: "+ex.getMessage());
        }
        
        return produto;
    }
    
    
}