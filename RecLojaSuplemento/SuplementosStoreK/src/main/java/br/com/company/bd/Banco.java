package br.com.company.bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Classe que inicializa a conexão com o banco de dados
 * @author lucas
 */
public class Banco {
    
    private String url;
    private String porta;
    private String banco;
    private String usuario;
    private String senha;
    private String nomeBanco;
   
    public Banco(){
        
        this.usuario = "root";
        this.senha = "";
        this.nomeBanco = "suplemento";
        this.porta = "3306";
        this.banco = "mysql";  
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }       
    
    
   /**
 * Obtém uma conexão com o banco de dados.
 * 
 * @return Uma instância de Connection representando a conexão estabelecida.
 *         Retorna null se não for possível estabelecer a conexão.
 * @author Lucas
 */
    public Connection getConexao() {    
        Connection conexao = null;              
        try {           
            this.url = "jdbc:"+this.banco+"://localhost:"+this.porta+"/"+this.nomeBanco;
            conexao = DriverManager.getConnection(this.url, this.usuario, this.senha);            
        } catch (SQLException ex) {
            System.out.println("Problemas na conexão: "+ex.getMessage());                        
        }       
        return conexao;
    }    
}