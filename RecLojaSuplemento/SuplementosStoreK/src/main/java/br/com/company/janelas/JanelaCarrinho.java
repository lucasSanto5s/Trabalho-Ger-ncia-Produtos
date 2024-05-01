package br.com.company.janelas;
import br.com.company.entidades.Carrinho;
import br.com.company.entidades.Pedido;
import br.com.company.entidades.Produto;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
/**
* Classe que representa a janela do carrinho de compras.
*/
public class JanelaCarrinho extends javax.swing.JPanel {
    
    private DefaultTableModel model = new DefaultTableModel();
    private Carrinho listaCarrinho = new Carrinho();
    private Pedido listaPedido = new Pedido();
    private ArrayList<Produto> listaEstoqueBD = new ArrayList();
/**
* Construtor da classe JanelaCarrinho.
* 
* @param listaCarrinho O carrinho de compras.
* @param listaEstoqueBD A lista de produtos em estoque.
*/    
    public JanelaCarrinho(Carrinho listaCarrinho,ArrayList<Produto> listaEstoqueBD) {
        initComponents();
        
        model.addColumn("Nome");
        model.addColumn("Valor");
        model.addColumn("Descricao");
        model.addColumn("Categoria");
        model.addColumn("Quantidade");    

        this.listaEstoqueBD= listaEstoqueBD;
        this.listaCarrinho = listaCarrinho;
        this.jt_TabelaCarrinho.setModel(model);
        this.inicializaTabela();
    }
/**
* Inicializa a tabela do carrinho de compras.
*/
    public void inicializaTabela(){
        if ( listaCarrinho.getItens().isEmpty() == false) {
            for (int i = 0; i < listaCarrinho.getItens().size(); i++) {
                model.addRow(new Object[]{this.listaCarrinho.getItens().get(i).getNome(), this.listaCarrinho.getItens().get(i).getPreco(),this.listaCarrinho.getItens().get(i).getDescricao(),this.listaCarrinho.getItens().get(i).getCategoria(),this.listaCarrinho.getItens().get(i).getQuantidadeDisponivel(),});
            }
        }
        this.jl_TotalCarrinho.setText(String.valueOf(listaCarrinho.calcularTotal()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_MaisQuantidade = new javax.swing.JButton();
        jl_QuantidadeRemove = new javax.swing.JLabel();
        bt_MenosQuantidade = new javax.swing.JButton();
        bt_ContinuarCompra = new javax.swing.JButton();
        bt_RealizarPagamento = new javax.swing.JButton();
        bt_RemoveAll = new javax.swing.JButton();
        bt_Remove = new javax.swing.JButton();
        jl_ValorProduto = new javax.swing.JLabel();
        jl_QuantidadeProduto = new javax.swing.JLabel();
        jl_TotalCarrinho = new javax.swing.JLabel();
        jl_NomeProduto = new javax.swing.JLabel();
        jl_CategoriaProduto = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_InfoProduto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_TabelaCarrinho = new javax.swing.JTable();
        jl_JanelaFundoCarrinho = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_MaisQuantidade.setBorder(null);
        bt_MaisQuantidade.setContentAreaFilled(false);
        bt_MaisQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_MaisQuantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_MaisQuantidadeMouseClicked(evt);
            }
        });
        add(bt_MaisQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 640, 40, 50));

        jl_QuantidadeRemove.setBackground(new java.awt.Color(255, 255, 255));
        jl_QuantidadeRemove.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jl_QuantidadeRemove.setText("1");
        add(jl_QuantidadeRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 20, 40));

        bt_MenosQuantidade.setBorder(null);
        bt_MenosQuantidade.setContentAreaFilled(false);
        bt_MenosQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_MenosQuantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_MenosQuantidadeMouseClicked(evt);
            }
        });
        add(bt_MenosQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 40, 50));

        bt_ContinuarCompra.setBorder(null);
        bt_ContinuarCompra.setContentAreaFilled(false);
        bt_ContinuarCompra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_ContinuarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ContinuarCompraMouseClicked(evt);
            }
        });
        add(bt_ContinuarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 560, 260, 60));

        bt_RealizarPagamento.setBorder(null);
        bt_RealizarPagamento.setContentAreaFilled(false);
        bt_RealizarPagamento.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_RealizarPagamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_RealizarPagamentoMouseClicked(evt);
            }
        });
        add(bt_RealizarPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 630, 260, 60));

        bt_RemoveAll.setBorder(null);
        bt_RemoveAll.setContentAreaFilled(false);
        bt_RemoveAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_RemoveAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_RemoveAllMouseClicked(evt);
            }
        });
        add(bt_RemoveAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 640, 160, 60));

        bt_Remove.setBorder(null);
        bt_Remove.setContentAreaFilled(false);
        bt_Remove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_RemoveMouseClicked(evt);
            }
        });
        add(bt_Remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 640, 130, 50));

        jl_ValorProduto.setBackground(new java.awt.Color(255, 255, 255));
        jl_ValorProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(jl_ValorProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 180, 30));

        jl_QuantidadeProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(jl_QuantidadeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 170, 30));

        jl_TotalCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        jl_TotalCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jl_TotalCarrinho.setText("0.00");
        add(jl_TotalCarrinho, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 100, 40));

        jl_NomeProduto.setBackground(new java.awt.Color(255, 255, 255));
        jl_NomeProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(jl_NomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 180, 40));

        jl_CategoriaProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(jl_CategoriaProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 160, 170, 40));

        ta_InfoProduto.setColumns(20);
        ta_InfoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ta_InfoProduto.setLineWrap(true);
        ta_InfoProduto.setRows(5);
        ta_InfoProduto.setToolTipText("");
        ta_InfoProduto.setBorder(null);
        jScrollPane3.setViewportView(ta_InfoProduto);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 380, 120));

        jt_TabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Valor", "Descricao", "Categoria", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jt_TabelaCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_TabelaCarrinhoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jt_TabelaCarrinho);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 470, 510));

        jl_JanelaFundoCarrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/JanelaCarrinho.png"))); // NOI18N
        add(jl_JanelaFundoCarrinho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void bt_ContinuarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ContinuarCompraMouseClicked
    FrameInicial.janelaCompra  = new JanelaCompra (this.listaCarrinho, this.listaEstoqueBD);
    JFrame janela = (JFrame)SwingUtilities.getWindowAncestor(this);
    janela.getContentPane().remove(FrameInicial.janelaCarrinho);
    janela.add(FrameInicial.janelaCompra, BorderLayout.CENTER);
    janela.pack();
    }//GEN-LAST:event_bt_ContinuarCompraMouseClicked
/**
 * Preenche os Jlabes com os devidos dados do produto selecionado da tabela.
 */
    private void jt_TabelaCarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_TabelaCarrinhoMouseClicked
        int selectedIndex = jt_TabelaCarrinho.getSelectedRow();
        Produto produtoSelecionado = this.listaCarrinho.getItens().get(selectedIndex);
        this.jl_NomeProduto.setText(produtoSelecionado.getNome());
        this.jl_ValorProduto.setText(String.valueOf(produtoSelecionado.getPreco()));
        this.ta_InfoProduto.setText(produtoSelecionado.getDescricao());
        this.jl_CategoriaProduto.setText(produtoSelecionado.getCategoria());
        this.jl_QuantidadeProduto.setText(Integer.toString(produtoSelecionado.getQuantidadeDisponivel()));
    }//GEN-LAST:event_jt_TabelaCarrinhoMouseClicked
/**
 * Remove um produto do carrinho de compras.
 * 
 * Verifica se um produto está selecionado na tabela do carrinho.
 * Se sim, obtém o produto selecionado e a quantidade a ser removida.
 * Se a quantidade a ser removida for maior ou igual à quantidade disponível, 
 * exibe uma confirmação para remover completamente o produto.
 * Caso contrário, atualiza a quantidade disponível do produto no estoque e no carrinho.
 * Atualiza a interface gráfica e recalcula o total do carrinho.
 * Exibe mensagens de sucesso ou erro conforme necessário.
 */
    private void bt_RemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_RemoveMouseClicked
        try {
            int selectedIndex = jt_TabelaCarrinho.getSelectedRow();
            if (selectedIndex == -1) {
                throw new IllegalStateException("Nenhuma linha selecionada. Selecione um produto antes de prosseguir.");
            }
          
            Produto produtoSelecionado = this.listaCarrinho.getItens().get(selectedIndex);
            int quantidadeRemover = Integer.parseInt(this.jl_QuantidadeRemove.getText());
            
            if(quantidadeRemover >= produtoSelecionado.getQuantidadeDisponivel()){
                int index = 0;

                for (Produto prod : this.listaEstoqueBD) {
                    if (prod.getNome().equals(produtoSelecionado.getNome())) {
                        int resposta = JOptionPane.showConfirmDialog(null, "A quantidade a ser removida é maior ou igual à quantidade disponível.\nDeseja remover o produto completamente?", "Remover Produto", JOptionPane.YES_NO_OPTION);
                        if (resposta == JOptionPane.YES_OPTION) {
                            // Atualizar a quantidade disponível do produto no carrinho
                            prod.setQuantidadeDisponivel(prod.getQuantidadeDisponivel() + quantidadeRemover);
                            this.listaEstoqueBD.set(index, prod);
                            this.listaCarrinho.removerItem(produtoSelecionado);
                            this.model.removeRow(selectedIndex);
                        }
                        break;
                    }
                    index++;
                }
                String recebeTotal = String.valueOf(this.listaCarrinho.calcularTotal());
                this.jl_TotalCarrinho.setText(recebeTotal);
               
            }else{
                Produto p ;
                
                int index = 0;
                for (Produto prod : listaEstoqueBD) {
                    if (prod.getNome().equals(produtoSelecionado.getNome())) {    
                        p = new Produto(prod.getNome(), prod.getPreco(), prod.getDescricao(), prod.getCategoria(), prod.getQuantidadeDisponivel()+quantidadeRemover ,0);
                        listaEstoqueBD.set(index, p);
                        break;
                    }
                    index++;
                }
               
                // Atualizar quantidade disponível do produto selecionado
                int novaQuantidadeDisponivel = produtoSelecionado.getQuantidadeDisponivel() - quantidadeRemover;
                produtoSelecionado.setQuantidadeDisponivel(novaQuantidadeDisponivel);

                // Atualizar a lista de estoque com o produto modificado
                this.listaCarrinho.getItens().set(selectedIndex, produtoSelecionado);

                // Atualizar a interface gráfica com a nova quantidade disponível
                this.model.setValueAt(novaQuantidadeDisponivel, selectedIndex, 4);
                this.jl_QuantidadeProduto.setText(Integer.toString(novaQuantidadeDisponivel));

                // Calcular e exibir o novo total do carrinho
                String recebeTotal = String.valueOf(this.listaCarrinho.calcularTotal());
                this.jl_TotalCarrinho.setText(recebeTotal);

                JOptionPane.showMessageDialog(null, "Quantidade do Produto Removida do Carrinho", "Sucesso!", JOptionPane.INFORMATION_MESSAGE,FrameInicial.icon);
                
            }
           this.jl_QuantidadeRemove.setText("1");
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(null, "Nenhum Produto selecionado", "Erro!", JOptionPane.ERROR_MESSAGE,FrameInicial.icon);
        }
    }//GEN-LAST:event_bt_RemoveMouseClicked

    private void bt_MenosQuantidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_MenosQuantidadeMouseClicked
        int quantidadeAdicionar = Integer.parseInt(this.jl_QuantidadeRemove.getText());
        if (quantidadeAdicionar > 1) {
            quantidadeAdicionar--;
        }
        this.jl_QuantidadeRemove.setText(String.valueOf(quantidadeAdicionar));
    }//GEN-LAST:event_bt_MenosQuantidadeMouseClicked

    private void bt_MaisQuantidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_MaisQuantidadeMouseClicked
        int quantidadeAdicionar = Integer.parseInt(this.jl_QuantidadeRemove.getText());
       
            quantidadeAdicionar++;
        
        this.jl_QuantidadeRemove.setText(String.valueOf(quantidadeAdicionar));
    }//GEN-LAST:event_bt_MaisQuantidadeMouseClicked

    private void bt_RemoveAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_RemoveAllMouseClicked
        for (Produto produtoCarrinho : this.listaCarrinho.getItens()) {
            for (Produto produtoEstoque : this.listaEstoqueBD) {
                if (produtoCarrinho.getNome().equals(produtoEstoque.getNome())) {
                    int novaQuantidadeEstoque = produtoEstoque.getQuantidadeDisponivel() + produtoCarrinho.getQuantidadeDisponivel();
                    produtoEstoque.setQuantidadeDisponivel(novaQuantidadeEstoque);
                    break; // Não é necessário continuar procurando pelo mesmo produto na lista de estoque
                }
            }
        }
        model.setRowCount(0);
        // Limpar a lista de compras
        this.listaCarrinho.limparCarrinho();
    }//GEN-LAST:event_bt_RemoveAllMouseClicked

    private void bt_RealizarPagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_RealizarPagamentoMouseClicked
        if(this.listaCarrinho.getItens().isEmpty()== true){
            JOptionPane.showMessageDialog(null, "Volte para Tela de Compras e adicione ao menos 1 produto", "Erro!", JOptionPane.ERROR_MESSAGE, FrameInicial.icon);
        }else{
            this.listaPedido.setItens(this.listaCarrinho.getItens()); 
            FrameInicial.janelaPagamento = new JanelaPagamento(listaPedido);
            JFrame janela = (JFrame) SwingUtilities.getWindowAncestor(this);
            janela.getContentPane().remove(FrameInicial.janelaCarrinho);
            janela.add(FrameInicial.janelaPagamento, BorderLayout.CENTER);
            janela.pack();           
        }     
    }//GEN-LAST:event_bt_RealizarPagamentoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ContinuarCompra;
    private javax.swing.JButton bt_MaisQuantidade;
    private javax.swing.JButton bt_MenosQuantidade;
    private javax.swing.JButton bt_RealizarPagamento;
    private javax.swing.JButton bt_Remove;
    private javax.swing.JButton bt_RemoveAll;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jl_CategoriaProduto;
    private javax.swing.JLabel jl_JanelaFundoCarrinho;
    private javax.swing.JLabel jl_NomeProduto;
    private javax.swing.JLabel jl_QuantidadeProduto;
    private javax.swing.JLabel jl_QuantidadeRemove;
    private javax.swing.JLabel jl_TotalCarrinho;
    private javax.swing.JLabel jl_ValorProduto;
    private javax.swing.JTable jt_TabelaCarrinho;
    private javax.swing.JTextArea ta_InfoProduto;
    // End of variables declaration//GEN-END:variables
}
