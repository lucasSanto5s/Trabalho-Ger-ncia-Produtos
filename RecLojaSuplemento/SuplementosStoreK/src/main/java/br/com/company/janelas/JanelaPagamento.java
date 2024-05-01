package br.com.company.janelas;

import br.com.company.dao.PedidoDao;
import br.com.company.dao.ProdutoDao;
import br.com.company.entidades.MetodoPagamento;
import br.com.company.entidades.Pedido;
import br.com.company.entidades.Produto;
import javax.swing.JOptionPane;
/**
 * Classe que representa a janela de pagamento.
 */
public class JanelaPagamento extends javax.swing.JPanel {
    
    Pedido pedido;
    
/**
* Construtor da classe JanelaPagamento.
* 
* @param pedido O pedido das compras recebido da JanelaCarrinho.
*/    
    public JanelaPagamento(Pedido pedido) {       
        initComponents();
        this.pedido= pedido;
        FrameInicial.pedidoDB = new PedidoDao();
        FrameInicial.produtoDB = new ProdutoDao();
        
        this.jL_TotalCompra.setText(String.valueOf(this.pedido.calcularTotal()));
    }
/**
* Método para aplicar desconto de 10% no valor total da compra.
*/   
    public void   metodosComDesconto(){
       JOptionPane.showMessageDialog(null, "Método com desconto selecionado",
       "Selecionado", JOptionPane.INFORMATION_MESSAGE, FrameInicial.icon);
       double totalFinal= this.pedido.calcularTotal()*0.9;
       String descontoFormatado = String.format("%.3f", this.pedido.calcularTotal()*0.1);
       this.jL_descontos.setText(descontoFormatado);
       String totalFinalFormatado = String.format("%.3f", totalFinal);
       this.jL_ValorFinal.setText(totalFinalFormatado);
       
    }
/**
* Torna o combo box invisível.
*/    
    public void comboBoxInvisivel(){
        this.cb_Parcelas.setVisible(false);
       this.jL_ComboBox.setVisible(false);
       jl_TextoParcelas.setVisible(false);
    }
/**
 * Configura o carrinho atual, atualiza o estoqueBD com as quantidades corretas após a compra sendo (quantidade do estoque - quantidade do Carrinho)
 * salva as informações tanto do carrinho quanto dos produtos caso tenham o mesmo nome no banco de dados.
 */  
    public void setarCarrinhoERemoveroBD(){
        int pedidoIDAtual = FrameInicial.pedidoDB.obterProximoIdPedido();
        this.pedido.setId(pedidoIDAtual);
        FrameInicial.pedidoDB.salvar(pedido);
        
        for (Produto produtoCarrinho : pedido.getItens()) {
            for (Produto produtoEstoque : FrameInicial.produtoDB.listar() ) {
                if (produtoCarrinho.getNome().equals(produtoEstoque.getNome())) {
                    // Se os nomes dos produtos são iguais, atualize o estoque
                    int novaQuantidade = produtoEstoque.getQuantidadeDisponivel() - produtoCarrinho.getQuantidadeDisponivel();
                
                       produtoEstoque.setQuantidadeDisponivel(novaQuantidade);
                       FrameInicial.produtoDB.atualizar(produtoEstoque);
                       produtoCarrinho.setPedido_id(pedidoIDAtual);                
                 
                }
            }
            FrameInicial.produtoDB.salvar(produtoCarrinho);
        }  
       
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_TextoParcelas = new javax.swing.JLabel();
        cb_Parcelas = new javax.swing.JComboBox<>();
        jL_ComboBox = new javax.swing.JLabel();
        jL_TotalCompra = new javax.swing.JLabel();
        jL_ValorFinal = new javax.swing.JLabel();
        jL_descontos = new javax.swing.JLabel();
        jB_FinalizarCompra = new javax.swing.JButton();
        jB_CartaoCred = new javax.swing.JButton();
        jB_CartaoDebt = new javax.swing.JButton();
        jB_Dinheiro = new javax.swing.JButton();
        jB_Pix = new javax.swing.JButton();
        jL_FundoIMG = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_TextoParcelas.setBackground(new java.awt.Color(0, 0, 0));
        jl_TextoParcelas.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jl_TextoParcelas.setForeground(new java.awt.Color(255, 255, 255));
        jl_TextoParcelas.setVisible(false);
        jl_TextoParcelas.setText("   Parcelas :");
        jl_TextoParcelas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jl_TextoParcelas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jl_TextoParcelas.setOpaque(true);
        add(jl_TextoParcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 250, 90, 50));

        cb_Parcelas.setVisible(false);
        cb_Parcelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        add(cb_Parcelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 320, 40, -1));

        jL_ComboBox.setVisible(false);
        jL_ComboBox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cb.png"))); // NOI18N
        add(jL_ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 240, 100, 320));

        jL_TotalCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(jL_TotalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 70, 40));
        add(jL_ValorFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 446, 80, 40));
        add(jL_descontos, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 350, 80, 40));

        jB_FinalizarCompra.setBorderPainted(false);
        jB_FinalizarCompra.setContentAreaFilled(false);
        jB_FinalizarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_FinalizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_FinalizarCompraMouseClicked(evt);
            }
        });
        add(jB_FinalizarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 603, 220, 60));

        jB_CartaoCred.setBorder(null);
        jB_CartaoCred.setContentAreaFilled(false);
        jB_CartaoCred.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_CartaoCred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_CartaoCredMouseClicked(evt);
            }
        });
        add(jB_CartaoCred, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 180, 50));

        jB_CartaoDebt.setBorder(null);
        jB_CartaoDebt.setBorderPainted(false);
        jB_CartaoDebt.setContentAreaFilled(false);
        jB_CartaoDebt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_CartaoDebt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_CartaoDebtMouseClicked(evt);
            }
        });
        add(jB_CartaoDebt, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 363, 180, 40));

        jB_Dinheiro.setBorder(null);
        jB_Dinheiro.setContentAreaFilled(false);
        jB_Dinheiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Dinheiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_DinheiroMouseClicked(evt);
            }
        });
        jB_Dinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_DinheiroActionPerformed(evt);
            }
        });
        add(jB_Dinheiro, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 413, 100, 40));

        jB_Pix.setBorder(null);
        jB_Pix.setContentAreaFilled(false);
        jB_Pix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jB_Pix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jB_PixMouseClicked(evt);
            }
        });
        add(jB_Pix, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 463, 50, 40));

        jL_FundoIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/JanelaPagamento.png"))); // NOI18N
        add(jL_FundoIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void jB_DinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_DinheiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_DinheiroActionPerformed

    private void jB_CartaoDebtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_CartaoDebtMouseClicked
        comboBoxInvisivel();
        metodosComDesconto();
        this.pedido.getmetodoPagamento().setMetodoPagamentoCartaoDebito(); 
        
    }//GEN-LAST:event_jB_CartaoDebtMouseClicked

    private void jB_DinheiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_DinheiroMouseClicked
        comboBoxInvisivel(); 
        metodosComDesconto();
         this.pedido.getmetodoPagamento().setMetodoPagamentoDinheiro();
           comboBoxInvisivel();
    }//GEN-LAST:event_jB_DinheiroMouseClicked

    private void jB_PixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_PixMouseClicked
       comboBoxInvisivel();
        metodosComDesconto();
         this.pedido.getmetodoPagamento().setMetodoPagamentoPix();
           comboBoxInvisivel();
    }//GEN-LAST:event_jB_PixMouseClicked

    private void jB_CartaoCredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_CartaoCredMouseClicked
        this.pedido.getmetodoPagamento().setMetodoPagamentoCartaoCredito();
        double totalFinal= this.pedido.calcularTotal();
       this.jL_descontos.setText("0.00");
       this.jL_ValorFinal.setText(String.valueOf(totalFinal));
       this.cb_Parcelas.setVisible(true);
       this.jL_ComboBox.setVisible(true);
       this.jl_TextoParcelas.setVisible(true);
      
    }//GEN-LAST:event_jB_CartaoCredMouseClicked
/**
 * Este método é chamado para processar o pagamento de acordo com o método selecionado.
 * Se o método de pagamento não for "Cartão de Crédito", o pagamento é processado diretamente,
 * o carrinho é atualizado e os produtos são removidos do banco de dados. O programa é encerrado após o pagamento.
 * Se o método de pagamento for "Cartão de Crédito", o número de parcelas é obtido e o valor total é dividido
 * pelo número de parcelas. Em seguida, exibe uma mensagem de confirmação do pagamento com os detalhes,
 * atualiza o carrinho e remove os produtos do banco de dados. O programa é encerrado após o pagamento.
 */
    private void jB_FinalizarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jB_FinalizarCompraMouseClicked
        if ( this.pedido.getmetodoPagamento().getNome().equalsIgnoreCase("Cartão de Crédito") == false) {
            JOptionPane.showMessageDialog(null, "Pagamento realizado em " +  this.pedido.getmetodoPagamento().getNome(),
                    "Pagamento Efetuado", JOptionPane.INFORMATION_MESSAGE, FrameInicial.icon);
               setarCarrinhoERemoveroBD();
               System.exit(0);
 
        } else {
            int numeroParcelas = this.cb_Parcelas.getSelectedIndex() + 1;
            double parcela = this.pedido.calcularTotal() / numeroParcelas;

            JOptionPane.showMessageDialog(null, "Pagamento realizado em " +  this.pedido.getmetodoPagamento().getNome()
                    + " com " + numeroParcelas + " parcelas de R$" + parcela,
                    "Pagamento Efetuado", JOptionPane.INFORMATION_MESSAGE, FrameInicial.icon);
            setarCarrinhoERemoveroBD();
            System.exit(0);
          
        }
    }//GEN-LAST:event_jB_FinalizarCompraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_Parcelas;
    private javax.swing.JButton jB_CartaoCred;
    private javax.swing.JButton jB_CartaoDebt;
    private javax.swing.JButton jB_Dinheiro;
    private javax.swing.JButton jB_FinalizarCompra;
    private javax.swing.JButton jB_Pix;
    private javax.swing.JLabel jL_ComboBox;
    private javax.swing.JLabel jL_FundoIMG;
    private javax.swing.JLabel jL_TotalCompra;
    private javax.swing.JLabel jL_ValorFinal;
    private javax.swing.JLabel jL_descontos;
    private javax.swing.JLabel jl_TextoParcelas;
    // End of variables declaration//GEN-END:variables
}
