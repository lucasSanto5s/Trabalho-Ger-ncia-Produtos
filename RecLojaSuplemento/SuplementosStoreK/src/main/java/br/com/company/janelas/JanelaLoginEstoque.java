package br.com.company.janelas;

import br.com.company.dao.Stock_ManagerDao;
import br.com.company.entidades.Stock_Manager;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 * Classe responsável por representar a janela de login do estoque do aplicativo.
 */
public class JanelaLoginEstoque extends javax.swing.JPanel {
/**
* Cria uma nova instância da janela de login do estoque.
*/
    public JanelaLoginEstoque() {
        initComponents();
        FrameInicial.StockManagerDB = new Stock_ManagerDao();
    }
/**
* Verifica se o login e a senha fornecidos correspondem a um gerente de estoque válido.
* 
* @param login O login inserido pelo usuário.
* @param senha A senha inserida pelo usuário.
* @return true se o login for encontrado na consulta ao banco de dados, false caso contrário.
*/
    public boolean verificarLogin(String login, String senha) {
        for (Stock_Manager stockManager : FrameInicial.StockManagerDB.listar()) {
            if (login.equals(stockManager.getNome()) && senha.equals(stockManager.getSenha())) {
                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_Login = new javax.swing.JTextField();
        bt_Logar = new javax.swing.JButton();
        bt_Voltar = new javax.swing.JButton();
        tf_Senha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tf_Login.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tf_Login.setBorder(null);
        tf_Login.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tf_Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 297, 190, 30));

        bt_Logar.setBorderPainted(false);
        bt_Logar.setContentAreaFilled(false);
        bt_Logar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Logar.setFocusPainted(false);
        bt_Logar.setFocusable(false);
        bt_Logar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_LogarMouseClicked(evt);
            }
        });
        add(bt_Logar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 450, 170, 60));

        bt_Voltar.setBorder(null);
        bt_Voltar.setBorderPainted(false);
        bt_Voltar.setContentAreaFilled(false);
        bt_Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Voltar.setFocusPainted(false);
        bt_Voltar.setFocusable(false);
        bt_Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_VoltarMouseClicked(evt);
            }
        });
        add(bt_Voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 620, 160, 50));

        tf_Senha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tf_Senha.setBorder(null);
        add(tf_Senha, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 354, 190, 27));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/JanelaLoginEstoque.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void bt_LogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_LogarMouseClicked
    try{
        if(verificarLogin(this.tf_Login.getText() ,this.tf_Senha.getText()) == false){
            throw new Exception();
        }
        FrameInicial.janelaEstoque = new JanelaEstoque();
            JFrame janela = (JFrame)SwingUtilities.getWindowAncestor(this);
            janela.getContentPane().remove(FrameInicial.janelaLoginEstoque);
            janela.add(FrameInicial.janelaEstoque, BorderLayout.CENTER);
            janela.pack();
    }    
    catch(Exception e){    
        JOptionPane.showMessageDialog(null,"Senha inválida","INVÁLIDO", JOptionPane.ERROR_MESSAGE,FrameInicial.icon);
    }
    }//GEN-LAST:event_bt_LogarMouseClicked

    private void bt_VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_VoltarMouseClicked
FrameInicial.janelaMenu  = new JanelaMenu();
    JFrame janela = (JFrame)SwingUtilities.getWindowAncestor(this);
    janela.getContentPane().remove(FrameInicial.janelaLoginEstoque);
    janela.add(FrameInicial.janelaMenu, BorderLayout.CENTER);
    janela.pack();
    }//GEN-LAST:event_bt_VoltarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Logar;
    private javax.swing.JButton bt_Voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tf_Login;
    private javax.swing.JTextField tf_Senha;
    // End of variables declaration//GEN-END:variables
}
