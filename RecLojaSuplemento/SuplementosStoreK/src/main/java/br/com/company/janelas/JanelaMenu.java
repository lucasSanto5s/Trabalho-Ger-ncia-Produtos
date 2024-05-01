package br.com.company.janelas;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 * Classe responsável por representar a janela de menu do aplicativo.
 */
public class JanelaMenu extends javax.swing.JPanel {
/**
* Cria uma nova instância da janela de menu.
*/
    public JanelaMenu() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_Sobre = new javax.swing.JButton();
        bt_Comprar = new javax.swing.JButton();
        bt_Estoque = new javax.swing.JButton();
        bt_Encerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_Sobre.setBorder(null);
        bt_Sobre.setBorderPainted(false);
        bt_Sobre.setContentAreaFilled(false);
        bt_Sobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Sobre.setFocusPainted(false);
        add(bt_Sobre, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 410, 200, 60));

        bt_Comprar.setBorder(null);
        bt_Comprar.setBorderPainted(false);
        bt_Comprar.setContentAreaFilled(false);
        bt_Comprar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Comprar.setFocusPainted(false);
        bt_Comprar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ComprarMouseClicked(evt);
            }
        });
        add(bt_Comprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 200, 60));

        bt_Estoque.setBorder(null);
        bt_Estoque.setBorderPainted(false);
        bt_Estoque.setContentAreaFilled(false);
        bt_Estoque.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Estoque.setFocusPainted(false);
        bt_Estoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_EstoqueMouseClicked(evt);
            }
        });
        add(bt_Estoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 190, 60));

        bt_Encerrar.setBorder(null);
        bt_Encerrar.setBorderPainted(false);
        bt_Encerrar.setContentAreaFilled(false);
        bt_Encerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Encerrar.setFocusPainted(false);
        bt_Encerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_EncerrarMouseClicked(evt);
            }
        });
        add(bt_Encerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 610, 170, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/JanelaMenu.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void bt_EncerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_EncerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_bt_EncerrarMouseClicked

    private void bt_ComprarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ComprarMouseClicked
    FrameInicial.janelaCompra = new JanelaCompra(null,null);
        JFrame janela = (JFrame)SwingUtilities.getWindowAncestor(this);
        janela.getContentPane().remove(FrameInicial.janelaMenu);
        janela.add(FrameInicial.janelaCompra, BorderLayout.CENTER);
        janela.pack();         
    }//GEN-LAST:event_bt_ComprarMouseClicked

    private void bt_EstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_EstoqueMouseClicked
    FrameInicial.janelaLoginEstoque = new JanelaLoginEstoque();
            JFrame janela = (JFrame)SwingUtilities.getWindowAncestor(this);
            janela.getContentPane().remove(FrameInicial.janelaMenu);
            janela.add(FrameInicial.janelaLoginEstoque, BorderLayout.CENTER);
            janela.pack();    
    }//GEN-LAST:event_bt_EstoqueMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Comprar;
    private javax.swing.JButton bt_Encerrar;
    private javax.swing.JButton bt_Estoque;
    private javax.swing.JButton bt_Sobre;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
