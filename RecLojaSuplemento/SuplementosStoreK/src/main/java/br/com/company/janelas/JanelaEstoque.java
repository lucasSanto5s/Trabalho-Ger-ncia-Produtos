package br.com.company.janelas;
import br.com.company.dao.ProdutoDao;
import br.com.company.entidades.Produto;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
/**
 * Classe responsável por representar a janela de estoque do aplicativo.
 */
public class JanelaEstoque extends javax.swing.JPanel {

    private DefaultListModel <String> modelEstoque;
    private ArrayList<Produto> listaEstoqueBD;
    
    public JanelaEstoque() {
        initComponents();
        FrameInicial.produtoDB = new ProdutoDao();
        listaEstoqueBD = new ArrayList<Produto>();
        this.modelEstoque = new DefaultListModel();    
        this.inicializarLista();

    }
/**
* Inicializa a lista de produtos no estoque, os produtos do estoque tem id carrinho 1 e são retirados do banco de dados através do método: listar().
*/    
    public void inicializarLista(){
        for (Produto p :  FrameInicial.produtoDB.listar() ) {
            if(p.getPedido_id()== 1){
                 listaEstoqueBD.add(p);
            }
        }
    
         if (  listaEstoqueBD.isEmpty() == false) {
            for (int i = 0; i < listaEstoqueBD.size(); i++) {  //Percorre a lista de produtos adicionando os elementos ao modelo.
               
                    this.modelEstoque.addElement(listaEstoqueBD.get(i).getNome());
                
               
            }
        }
        //Seta o modelo utilizado pelos JList para os modelos criados.
        this.jl_ListaEstoqueCategoriasProdutos.setModel(this.modelEstoque);
}
/**
* Fecha e limpa as sub-janelas.
* 
* @param x O caractere que indica qual sub-janela deve ser fechada e limpa ('a' para adição, 'e' para edição).
*/  
    public void fecharELimparSubjanelas(char x){
        if(x == 'a'){
            tf_NomeProduto.setText("");
            tf_ValorProduto.setText("");
            ta_InfoProduto.setText("");
            tf_quantidade.setText("");
            cb_FiltroCategoria.setSelectedIndex(0);
            this.jp_ADD.setVisible(false);
        }else if(x == 'e'){
            tf_NomeProdutoE.setText("");
            tf_ValorProdutoE.setText("");
            ta_InfoProdutoE.setText("");
            tf_quantidadeE.setText("");
            cb_FiltroCategoriaE.setSelectedIndex(0);
            this.jp_EDIT.setVisible(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jl_ListaEstoqueCategoriasProdutos = new javax.swing.JList<>();
        bt_REMOVE = new javax.swing.JButton();
        bt_EDIT = new javax.swing.JButton();
        jp_ADD = new javax.swing.JPanel();
        cb_FiltroCategoria = new javax.swing.JComboBox<>();
        tf_NomeProduto = new javax.swing.JTextField();
        tf_ValorProduto = new javax.swing.JTextField();
        tf_quantidade = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_InfoProduto = new javax.swing.JTextArea();
        bt_Confirmar = new javax.swing.JButton();
        lb_fotoProduto = new javax.swing.JLabel();
        jl_FundoProdutoADD = new javax.swing.JLabel();
        bt_ADD = new javax.swing.JButton();
        jp_EDIT = new javax.swing.JPanel();
        cb_FiltroCategoriaE = new javax.swing.JComboBox<>();
        tf_NomeProdutoE = new javax.swing.JTextField();
        tf_ValorProdutoE = new javax.swing.JTextField();
        tf_quantidadeE = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_InfoProdutoE = new javax.swing.JTextArea();
        bt_ConfirmarE = new javax.swing.JButton();
        lb_fotoProduto1 = new javax.swing.JLabel();
        jl_FundoProdutoEDIT = new javax.swing.JLabel();
        bt_Voltar = new javax.swing.JButton();
        jl_FundoEstoque = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setRequestFocusEnabled(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jl_ListaEstoqueCategoriasProdutos.setBackground(new java.awt.Color(213, 63, 45));
        jl_ListaEstoqueCategoriasProdutos.setBorder(null);
        jl_ListaEstoqueCategoriasProdutos.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jl_ListaEstoqueCategoriasProdutos.setForeground(new java.awt.Color(255, 255, 255));
        jl_ListaEstoqueCategoriasProdutos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jl_ListaEstoqueCategoriasProdutos.setToolTipText("");
        jScrollPane1.setViewportView(jl_ListaEstoqueCategoriasProdutos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 540, 600));

        bt_REMOVE.setBorder(null);
        bt_REMOVE.setContentAreaFilled(false);
        bt_REMOVE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_REMOVE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_REMOVEMouseClicked(evt);
            }
        });
        add(bt_REMOVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 630, 170, 60));

        bt_EDIT.setBorder(null);
        bt_EDIT.setContentAreaFilled(false);
        bt_EDIT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_EDIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_EDITMouseClicked(evt);
            }
        });
        bt_EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_EDITActionPerformed(evt);
            }
        });
        add(bt_EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 130, 60));

        this.jp_ADD.setVisible(false);
        jp_ADD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jp_ADD.setMaximumSize(new java.awt.Dimension(415, 350));
        jp_ADD.setMinimumSize(new java.awt.Dimension(415, 350));
        jp_ADD.setPreferredSize(new java.awt.Dimension(415, 350));
        jp_ADD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_FiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proteina", "Carboidrato", "Aminoacidos", "Vitaminas" }));
        cb_FiltroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_FiltroCategoriaActionPerformed(evt);
            }
        });
        jp_ADD.add(cb_FiltroCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 90, 30));

        tf_NomeProduto.setBorder(null);
        jp_ADD.add(tf_NomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 43, 150, 30));

        tf_ValorProduto.setBorder(null);
        jp_ADD.add(tf_ValorProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 118, 150, 26));

        tf_quantidade.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tf_quantidade.setBorder(null);
        jp_ADD.add(tf_quantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 100, 20));

        ta_InfoProduto.setColumns(20);
        ta_InfoProduto.setLineWrap(true);
        ta_InfoProduto.setRows(5);
        ta_InfoProduto.setToolTipText("");
        ta_InfoProduto.setBorder(null);
        jScrollPane2.setViewportView(ta_InfoProduto);

        jp_ADD.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 170, 110));

        bt_Confirmar.setBorder(null);
        bt_Confirmar.setContentAreaFilled(false);
        bt_Confirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ConfirmarMouseClicked(evt);
            }
        });
        jp_ADD.add(bt_Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 60, 30));
        jp_ADD.add(lb_fotoProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 160, 160));

        jl_FundoProdutoADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundoProduto_415_350.png"))); // NOI18N
        jp_ADD.add(jl_FundoProdutoADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 350));

        add(jp_ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 415, 350));

        bt_ADD.setBorder(null);
        bt_ADD.setContentAreaFilled(false);
        bt_ADD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_ADD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ADDMouseClicked(evt);
            }
        });
        add(bt_ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, 60));

        this.jp_EDIT.setVisible(false);
        jp_EDIT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jp_EDIT.setMaximumSize(new java.awt.Dimension(415, 350));
        jp_EDIT.setMinimumSize(new java.awt.Dimension(415, 350));
        jp_EDIT.setPreferredSize(new java.awt.Dimension(415, 350));
        jp_EDIT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_FiltroCategoriaE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proteina", "Carboidrato", "Aminoacidos", "Vitaminas" }));
        cb_FiltroCategoriaE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_FiltroCategoriaEActionPerformed(evt);
            }
        });
        jp_EDIT.add(cb_FiltroCategoriaE, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 80, 30));

        tf_NomeProdutoE.setBorder(null);
        jp_EDIT.add(tf_NomeProdutoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 44, 150, 30));

        tf_ValorProdutoE.setBorder(null);
        jp_EDIT.add(tf_ValorProdutoE, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 117, 160, 27));

        tf_quantidadeE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tf_quantidadeE.setBorder(null);
        jp_EDIT.add(tf_quantidadeE, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 100, 20));

        ta_InfoProdutoE.setColumns(20);
        ta_InfoProdutoE.setLineWrap(true);
        ta_InfoProdutoE.setRows(5);
        ta_InfoProdutoE.setBorder(null);
        jScrollPane3.setViewportView(ta_InfoProdutoE);

        jp_EDIT.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 170, 110));

        bt_ConfirmarE.setBorder(null);
        bt_ConfirmarE.setContentAreaFilled(false);
        bt_ConfirmarE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_ConfirmarE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_ConfirmarEMouseClicked(evt);
            }
        });
        jp_EDIT.add(bt_ConfirmarE, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 60, 30));
        jp_EDIT.add(lb_fotoProduto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 160, 160));

        jl_FundoProdutoEDIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FundoProduto_415_350.png"))); // NOI18N
        jp_EDIT.add(jl_FundoProdutoEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 350));

        add(jp_EDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 415, 350));

        bt_Voltar.setBorder(null);
        bt_Voltar.setContentAreaFilled(false);
        bt_Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_VoltarMouseClicked(evt);
            }
        });
        bt_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_VoltarActionPerformed(evt);
            }
        });
        add(bt_Voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 630, 140, 60));

        jl_FundoEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/JanelaEstoque.png"))); // NOI18N
        add(jl_FundoEstoque, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void bt_VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_VoltarMouseClicked
FrameInicial.janelaMenu  = new JanelaMenu();
    JFrame janela = (JFrame)SwingUtilities.getWindowAncestor(this);
    janela.getContentPane().remove(FrameInicial.janelaEstoque);
    janela.add(FrameInicial.janelaMenu, BorderLayout.CENTER);
    janela.pack();        
    }//GEN-LAST:event_bt_VoltarMouseClicked

    private void bt_ADDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ADDMouseClicked
    this.jp_ADD.setVisible(true);
    this.jl_ListaEstoqueCategoriasProdutos.setEnabled(false);
    }//GEN-LAST:event_bt_ADDMouseClicked
/**
 * Ele verifica se um produto com o mesmo nome já existe na lista de estoque.
 * Se não existir, adiciona um novo produto à lista de estoque e o salva no banco de dados.
 * Após a operação, fecha e limpa as sub-janelas relacionadas.
 * @exception Caso um nome já exista, aparece um aviso ao usuario e o método é cancelado sem atualizar nada
 */
    private void bt_ConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ConfirmarMouseClicked
        this.jl_ListaEstoqueCategoriasProdutos.setEnabled(true);

        String nomeProduto = this.tf_NomeProduto.getText();
        String valorProdutoStr = this.tf_ValorProduto.getText();
        String descProduto = this.ta_InfoProduto.getText();
        String quantProduto = this.tf_quantidade.getText();
        String catProduto = String.valueOf(cb_FiltroCategoria.getSelectedItem());

// Verificar se já existe um produto com o mesmo nome na lista de estoque
        boolean produtoJaExiste = false;
        for (Produto produtoExistente : this.listaEstoqueBD) {
            if (produtoExistente.getNome().equals(nomeProduto)) {
                produtoJaExiste = true;
                break;
            }
        }

        if (produtoJaExiste) {
            JOptionPane.showMessageDialog(null, "Um produto com o mesmo nome já existe na lista de estoque", "Erro!", JOptionPane.ERROR_MESSAGE);
        } else {
            Produto p = new Produto();
            if (p.verificarValorNome(nomeProduto, valorProdutoStr, quantProduto)) {
                JOptionPane.showMessageDialog(null, "Adicionado", "OK!", JOptionPane.INFORMATION_MESSAGE, FrameInicial.icon);
                p = new Produto(nomeProduto, Double.parseDouble(valorProdutoStr), descProduto, catProduto, Integer.parseInt(quantProduto),0);
                this.listaEstoqueBD.add(p);
                this.modelEstoque.addElement(nomeProduto);
                FrameInicial.produtoDB.salvar(p);
            }
        }
        fecharELimparSubjanelas('a');
    }//GEN-LAST:event_bt_ConfirmarMouseClicked

    private void bt_EDITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_EDITMouseClicked
        this.jl_ListaEstoqueCategoriasProdutos.setEnabled(false);
        int selectedIndex = jl_ListaEstoqueCategoriasProdutos.getSelectedIndex();
        Produto produtoSelecionado = this.listaEstoqueBD.get(selectedIndex);
        this.tf_NomeProdutoE.setText(produtoSelecionado.getNome());
        this.tf_ValorProdutoE.setText(String.valueOf(produtoSelecionado.getPreco()));
        this.tf_quantidadeE.setText(Integer.toString(produtoSelecionado.getQuantidadeDisponivel()));
        this.ta_InfoProdutoE.setText(produtoSelecionado.getDescricao());
        String valorString =produtoSelecionado.getCategoria() ;


        for (int i = 0; i < cb_FiltroCategoriaE.getItemCount(); i++) {
           String comboBoxValue = cb_FiltroCategoriaE.getItemAt(i);
           if(valorString.equals(comboBoxValue)){
               cb_FiltroCategoriaE.setSelectedIndex(i);
           }
        }
        this.jp_EDIT.setVisible(true);
    }//GEN-LAST:event_bt_EDITMouseClicked
/**
 * Ele atualiza as informações do produto selecionado com base nos valores inseridos nos campos de edição.
 * Após a atualização, as mudanças são refletidas na lista de estoque e no banco de dados.
 * Também exibe uma mensagem de sucesso se a atualização for bem-sucedida, ou uma mensagem de aviso se nenhum produto for selecionado.
 */
    private void bt_ConfirmarEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_ConfirmarEMouseClicked
    this.jl_ListaEstoqueCategoriasProdutos.setEnabled(true);
    int selectedIndex = jl_ListaEstoqueCategoriasProdutos.getSelectedIndex();        
    if (selectedIndex != -1) {
    
    Produto produtoSelecionado = this.listaEstoqueBD.get(selectedIndex);

    
    produtoSelecionado.setNome(this.tf_NomeProdutoE.getText());
    produtoSelecionado.setPreco(Double.parseDouble(this.tf_ValorProdutoE.getText()));
    produtoSelecionado.setDescricao(this.ta_InfoProdutoE.getText());
    produtoSelecionado.setCategoria(String.valueOf(this.cb_FiltroCategoriaE.getSelectedItem()));
    produtoSelecionado.setQuantidadeDisponivel(Integer.parseInt(this.tf_quantidadeE.getText()));

    
    this.listaEstoqueBD.set(selectedIndex, produtoSelecionado);

    
    this.modelEstoque.setElementAt(produtoSelecionado.getNome(), selectedIndex);

    // Atualiza no banco de dados
    FrameInicial.produtoDB.atualizar(produtoSelecionado);

    JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!", "OK!", JOptionPane.INFORMATION_MESSAGE,FrameInicial.icon);
} else {
    JOptionPane.showMessageDialog(null, "Selecione um produto para atualizar!", "Aviso", JOptionPane.WARNING_MESSAGE,FrameInicial.icon);
}
           
        fecharELimparSubjanelas('e');
    }//GEN-LAST:event_bt_ConfirmarEMouseClicked

    private void bt_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_VoltarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_VoltarActionPerformed
/**
 * Ele remove o produto selecionado da lista de estoque e do banco de dados, se confirmado pelo usuário.
 * Exibe uma mensagem de confirmação antes de remover o produto e uma mensagem de sucesso após a remoção.
 * Se nenhum produto estiver selecionado, exibe uma mensagem de erro.
 */
    private void bt_REMOVEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_REMOVEMouseClicked
          try {
            String ProdutoSelecionado = this.jl_ListaEstoqueCategoriasProdutos.getSelectedValue();
            if (ProdutoSelecionado == null) {
                throw new NullPointerException();
            } else {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente remover o produto " + ProdutoSelecionado + "?", "Confirmação de remoção", JOptionPane.YES_NO_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    for (Produto produto : this.listaEstoqueBD) {
                        if (produto.getNome().equals(ProdutoSelecionado)) {
                            this.listaEstoqueBD.remove(produto);
                            this.modelEstoque.removeElement(ProdutoSelecionado);
                            FrameInicial.produtoDB.excluir(produto);
                            JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Remoção cancelada pelo usuário.");
                }
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Selecione o produto a ser removido", "Erro!", JOptionPane.ERROR_MESSAGE,FrameInicial.icon);
        }
    }//GEN-LAST:event_bt_REMOVEMouseClicked

    private void bt_EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EDITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_EDITActionPerformed

    private void cb_FiltroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_FiltroCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_FiltroCategoriaActionPerformed

    private void cb_FiltroCategoriaEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_FiltroCategoriaEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_FiltroCategoriaEActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_ADD;
    private javax.swing.JButton bt_Confirmar;
    private javax.swing.JButton bt_ConfirmarE;
    private javax.swing.JButton bt_EDIT;
    private javax.swing.JButton bt_REMOVE;
    private javax.swing.JButton bt_Voltar;
    private javax.swing.JComboBox<String> cb_FiltroCategoria;
    private javax.swing.JComboBox<String> cb_FiltroCategoriaE;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jl_FundoEstoque;
    private javax.swing.JLabel jl_FundoProdutoADD;
    private javax.swing.JLabel jl_FundoProdutoEDIT;
    private javax.swing.JList<String> jl_ListaEstoqueCategoriasProdutos;
    private javax.swing.JPanel jp_ADD;
    private javax.swing.JPanel jp_EDIT;
    private javax.swing.JLabel lb_fotoProduto;
    private javax.swing.JLabel lb_fotoProduto1;
    private javax.swing.JTextArea ta_InfoProduto;
    private javax.swing.JTextArea ta_InfoProdutoE;
    private javax.swing.JTextField tf_NomeProduto;
    private javax.swing.JTextField tf_NomeProdutoE;
    private javax.swing.JTextField tf_ValorProduto;
    private javax.swing.JTextField tf_ValorProdutoE;
    private javax.swing.JTextField tf_quantidade;
    private javax.swing.JTextField tf_quantidadeE;
    // End of variables declaration//GEN-END:variables
}
