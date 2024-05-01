package br.com.company.janelas;

import br.com.company.dao.PedidoDao;
import br.com.company.dao.ProdutoDao;
import br.com.company.dao.Stock_ManagerDao;
import br.com.company.entidades.Pedido;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.ImageIcon;



/**
 * JFrame principal utilizado para ser receptor de paines
 * @author Kauan
 */
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Classe responsável por inicializar a janela principal do aplicativo.
 */
public class FrameInicial extends javax.swing.JFrame {

    static JanelaMenu janelaMenu;
    static JanelaLoginEstoque janelaLoginEstoque;
    static JanelaEstoque janelaEstoque;
    static JanelaCompra janelaCompra;
    static JanelaCarrinho janelaCarrinho;
    static JanelaPagamento janelaPagamento; 
    
    static Stock_ManagerDao StockManagerDB;
    static ProdutoDao produtoDB;
    static PedidoDao pedidoDB;
    
    static ImageIcon icon;
    
    /**
     * Construtor da classe FrameInicial.
     * @throws IOException se ocorrer um erro ao carregar a imagem do ícone.
     */
    public FrameInicial() throws IOException {
        initComponents();
        // Carrega o ícone da aplicação
        icon = new ImageIcon(getClass().getResource("/images/Logo.png"));
        this.setIconImage(icon.getImage());
        
        // Inicializa a janela do menu
        janelaMenu = new JanelaMenu(); 
        
        // Define o layout e adiciona a janela do menu à janela principal
        this.setLayout(new BorderLayout());  
        this.add(janelaMenu, BorderLayout.CENTER); 
        this.pack();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(1600, 920, 1600, 920));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
