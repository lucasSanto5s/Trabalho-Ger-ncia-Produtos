package br.com.company.janelas;
import br.com.company.dao.ProdutoDao;
import br.com.company.entidades.Carrinho;
import br.com.company.entidades.Produto;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
/**
 * Classe que representa a janela de compra de produtos.
 */
public class JanelaCompra extends javax.swing.JPanel {

    
    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<Produto> listaEstoqueBD;
    private Carrinho listaCarrinho;
    
    /**
     * Construtor da classe JanelaCompra.
     * 
     * @param listaCarrinho O carrinho de compras.
     * @param listaEstoqueBD A lista de produtos em estoque.
     */
    public JanelaCompra(Carrinho listaCarrinho, ArrayList<Produto> listaEstoqueBD) {
        initComponents();
        if (listaCarrinho == null || listaEstoqueBD == null) {
            this.listaCarrinho = new Carrinho();
            this.listaEstoqueBD = new ArrayList<Produto>();
        } else {
            this.listaCarrinho = listaCarrinho;
            this.listaEstoqueBD = listaEstoqueBD;
            String recebeTotal = String.valueOf(this.listaCarrinho.calcularTotal());
            this.jl_TotalCarrinho.setText(recebeTotal);
        }
        
        FrameInicial.produtoDB = new ProdutoDao();
       
        model.addColumn("Nome");
        model.addColumn("Valor");
        model.addColumn("Descricao");
        model.addColumn("Categoria");
        model.addColumn("Quantidade");
        this.jt_TabelaEstoque.setModel(model);
        this.inicializaTabela();
    }
/**
* Inicializa a tabela de produtos em estoque, os produtos do estoque tem id carrinho 1 e são retirados do banco de dados através do método: listar().
*/
    public void inicializaTabela(){
        if(this.listaEstoqueBD.isEmpty() == true){
            for (Produto p : FrameInicial.produtoDB.listar()) {
                if(p.getPedido_id()==1){
                    listaEstoqueBD.add(p);
                }
                
            }
        }
       
        if ( listaEstoqueBD.isEmpty() == false) {
            for (int i = 0; i < listaEstoqueBD.size(); i++) {
                model.addRow(new Object[]{this.listaEstoqueBD.get(i).getNome(), this.listaEstoqueBD.get(i).getPreco(),this.listaEstoqueBD.get(i).getDescricao(),this.listaEstoqueBD.get(i).getCategoria(),this.listaEstoqueBD.get(i).getQuantidadeDisponivel(),});
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bt_Carrinho = new javax.swing.JButton();
        bt_Voltar = new javax.swing.JButton();
        bt_Adicionar = new javax.swing.JButton();
        bt_MaisQuantidade = new javax.swing.JButton();
        bt_MenosQuantidade = new javax.swing.JButton();
        jl_QuantidadeAdd = new javax.swing.JLabel();
        jl_ValorProduto = new javax.swing.JLabel();
        jl_NomeProduto = new javax.swing.JLabel();
        jl_TotalCarrinho = new javax.swing.JLabel();
        jl_CategoriaProduto = new javax.swing.JLabel();
        jl_QuantidadeProduto = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ta_InfoProduto = new javax.swing.JTextArea();
        cb_FiltroCategoria = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_TabelaEstoque = new javax.swing.JTable();
        jp_JanelaFundoCompra = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_Carrinho.setBorder(null);
        bt_Carrinho.setContentAreaFilled(false);
        bt_Carrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Carrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_CarrinhoMouseClicked(evt);
            }
        });
        add(bt_Carrinho, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 580, 130, 50));

        bt_Voltar.setBorder(null);
        bt_Voltar.setContentAreaFilled(false);
        bt_Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_VoltarMouseClicked(evt);
            }
        });
        add(bt_Voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 650, 130, 50));

        bt_Adicionar.setBorder(null);
        bt_Adicionar.setContentAreaFilled(false);
        bt_Adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_Adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_AdicionarMouseClicked(evt);
            }
        });
        add(bt_Adicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 510, 120, 50));

        bt_MaisQuantidade.setBorder(null);
        bt_MaisQuantidade.setContentAreaFilled(false);
        bt_MaisQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_MaisQuantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_MaisQuantidadeMouseClicked(evt);
            }
        });
        add(bt_MaisQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 520, 40, 40));

        bt_MenosQuantidade.setBorder(null);
        bt_MenosQuantidade.setContentAreaFilled(false);
        bt_MenosQuantidade.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_MenosQuantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_MenosQuantidadeMouseClicked(evt);
            }
        });
        add(bt_MenosQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 520, 40, 40));

        jl_QuantidadeAdd.setBackground(new java.awt.Color(255, 255, 255));
        jl_QuantidadeAdd.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jl_QuantidadeAdd.setText("1");
        add(jl_QuantidadeAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 520, 70, 40));

        jl_ValorProduto.setBackground(new java.awt.Color(255, 255, 255));
        jl_ValorProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(jl_ValorProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 240, 180, 30));

        jl_NomeProduto.setBackground(new java.awt.Color(255, 255, 255));
        jl_NomeProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(jl_NomeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 180, 40));

        jl_TotalCarrinho.setBackground(new java.awt.Color(255, 255, 255));
        jl_TotalCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        add(jl_TotalCarrinho, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 100, 40));

        jl_CategoriaProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(jl_CategoriaProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 170, 20));

        jl_QuantidadeProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(jl_QuantidadeProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 240, 170, 30));

        ta_InfoProduto.setColumns(20);
        ta_InfoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ta_InfoProduto.setLineWrap(true);
        ta_InfoProduto.setRows(5);
        ta_InfoProduto.setToolTipText("");
        ta_InfoProduto.setBorder(null);
        jScrollPane3.setViewportView(ta_InfoProduto);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 380, 120));

        cb_FiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tudo", "Proteínas", "Carboidratos", "Aminoácidos", "Vitaminas" }));
        cb_FiltroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_FiltroCategoriaActionPerformed(evt);
            }
        });
        add(cb_FiltroCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, 90, 30));

        jt_TabelaEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Valor", "Descricao", "Categoria"
            }
        ));
        jt_TabelaEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt_TabelaEstoqueMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jt_TabelaEstoque);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 510, 620));

        jp_JanelaFundoCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/JanelaCompra.png"))); // NOI18N
        add(jp_JanelaFundoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void bt_VoltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_VoltarMouseClicked
FrameInicial.janelaMenu  = new JanelaMenu();
    JFrame janela = (JFrame)SwingUtilities.getWindowAncestor(this);
    janela.getContentPane().remove(FrameInicial.janelaCompra);
    janela.add(FrameInicial.janelaMenu, BorderLayout.CENTER);
    janela.pack();
    }//GEN-LAST:event_bt_VoltarMouseClicked

    private void bt_CarrinhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_CarrinhoMouseClicked
        if(this.listaCarrinho.getItens().isEmpty() == false){
            FrameInicial.janelaCarrinho = new JanelaCarrinho(this.listaCarrinho, listaEstoqueBD);
            JFrame janela = (JFrame)SwingUtilities.getWindowAncestor(this);
            janela.getContentPane().remove(FrameInicial.janelaCompra);
            janela.add(FrameInicial.janelaCarrinho, BorderLayout.CENTER);
            janela.pack();
        }else{
            JOptionPane.showMessageDialog(null, "Adicione ao menos um Produto", "Erro!", JOptionPane.ERROR_MESSAGE,FrameInicial.icon);    
        }    
    
    }//GEN-LAST:event_bt_CarrinhoMouseClicked
/**
 * Preenche os Jlabes com os devidos dados do produto selecionado da tabela.
 */
    private void jt_TabelaEstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt_TabelaEstoqueMouseClicked
        int selectedIndex = jt_TabelaEstoque.getSelectedRow();
        Produto produtoSelecionado = this.listaEstoqueBD.get(selectedIndex);
        this.jl_NomeProduto.setText(produtoSelecionado.getNome());
        this.jl_ValorProduto.setText(String.valueOf(produtoSelecionado.getPreco()));
        this.ta_InfoProduto.setText(produtoSelecionado.getDescricao());
        this.jl_CategoriaProduto.setText(produtoSelecionado.getCategoria());
        this.jl_QuantidadeProduto.setText(Integer.toString(produtoSelecionado.getQuantidadeDisponivel()));
       
    }//GEN-LAST:event_jt_TabelaEstoqueMouseClicked

    private void bt_MaisQuantidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_MaisQuantidadeMouseClicked
        int quantidadeAdicionar = Integer.parseInt(this.jl_QuantidadeAdd.getText());
        quantidadeAdicionar++;
        this.jl_QuantidadeAdd.setText(String.valueOf(quantidadeAdicionar));
    }//GEN-LAST:event_bt_MaisQuantidadeMouseClicked

    private void bt_MenosQuantidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_MenosQuantidadeMouseClicked
        int quantidadeAdicionar = Integer.parseInt(this.jl_QuantidadeAdd.getText());
        if(quantidadeAdicionar > 1){
        quantidadeAdicionar--;    
        }    
        this.jl_QuantidadeAdd.setText(String.valueOf(quantidadeAdicionar));
    }//GEN-LAST:event_bt_MenosQuantidadeMouseClicked

 /**
 * Adiciona um produto ao carrinho de compras.
 * 
 * Verifica se um produto está selecionado na tabela de estoque.
 * Obtém o produto correspondente da lista de estoque e a quantidade a ser adicionada.
 * Se a quantidade a ser adicionada for maior do que a disponível, exibe uma mensagem de erro.
 * Atualiza a quantidade disponível no carrinho se o produto já estiver presente; 
 * caso contrário, adiciona um novo item ao carrinho.
 * Atualiza a quantidade disponível na lista de estoque e a interface gráfica.
 * Exibe mensagens de sucesso ou erro conforme necessário.
 *  @param evt O evento do mouse que desencadeou a ação.
 */
    private void bt_AdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_AdicionarMouseClicked
        try {
            int selectedIndex = jt_TabelaEstoque.getSelectedRow();
            if (selectedIndex == -1) {
                throw new IllegalStateException("Nenhuma linha selecionada. Selecione um produto antes de prosseguir.");
            }

            Produto produtoSelecionado = this.listaEstoqueBD.get(selectedIndex);
            int quantidadeAdicionar = Integer.parseInt(this.jl_QuantidadeAdd.getText());

            if (quantidadeAdicionar > produtoSelecionado.getQuantidadeDisponivel()) {
                JOptionPane.showMessageDialog(null, "A quantidade a ser adicionada é maior do que a quantidade disponível.", "Erro!", JOptionPane.ERROR_MESSAGE,FrameInicial.icon);
                return; // Retornar sem fazer nenhuma alteração se a quantidade a ser adicionada for maior que a quantidade disponível
            }

            boolean produtoJaNoCarrinho = false;

            // Verificar se o produto já está no carrinho
            for (Produto prod : this.listaCarrinho.getItens()) {
                if (prod.getNome().equals(produtoSelecionado.getNome())) {
                    // Atualizar a quantidade disponível do produto no carrinho
                    prod.setQuantidadeDisponivel(prod.getQuantidadeDisponivel() + quantidadeAdicionar);
                    produtoJaNoCarrinho = true;
                    break;
                }
            }

            if (!produtoJaNoCarrinho) {
                // Adicionar o produto ao carrinho se não estiver presente
                Produto novoProduto = new Produto(produtoSelecionado.getNome(), produtoSelecionado.getPreco(), produtoSelecionado.getDescricao(), produtoSelecionado.getCategoria(), quantidadeAdicionar,0);
                this.listaCarrinho.adicionarItem(novoProduto);
            }

            // Atualizar quantidade disponível do produto selecionado
            int novaQuantidadeDisponivel = produtoSelecionado.getQuantidadeDisponivel() - quantidadeAdicionar;
            produtoSelecionado.setQuantidadeDisponivel(novaQuantidadeDisponivel);

            // Atualizar a lista de estoque com o produto modificado
            this.listaEstoqueBD.set(selectedIndex, produtoSelecionado);

            // Atualizar a interface gráfica com a nova quantidade disponível
            this.model.setValueAt(novaQuantidadeDisponivel, selectedIndex, 4);
            this.jl_QuantidadeProduto.setText(Integer.toString(novaQuantidadeDisponivel));

            // Calcular e exibir o novo total do carrinho
            String recebeTotal = String.valueOf(this.listaCarrinho.calcularTotal());
            this.jl_TotalCarrinho.setText(recebeTotal);
            
            this.jl_QuantidadeAdd.setText("1");
            JOptionPane.showMessageDialog(null, "Produto Adicionado ao Carrinho", "Sucesso!", JOptionPane.INFORMATION_MESSAGE,FrameInicial.icon);
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(null, "Nenhum Produto selecionado", "Erro!", JOptionPane.ERROR_MESSAGE,FrameInicial.icon);
        }
    }//GEN-LAST:event_bt_AdicionarMouseClicked

    private void cb_FiltroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_FiltroCategoriaActionPerformed
        this.model.setRowCount(0);
        String categoriaSelecionada = (String) this.cb_FiltroCategoria.getSelectedItem();

        if (categoriaSelecionada.equals("Tudo")) {
            for (Produto produto : this.listaEstoqueBD) {
                this.model.addRow(new Object[]{produto.getNome(), produto.getPreco(), produto.getDescricao(), produto.getCategoria(), produto.getQuantidadeDisponivel()});
            }
        } else {
            for (Produto produto : this.listaEstoqueBD) {
                if (produto.getCategoria().equals(categoriaSelecionada)) {
                    this.model.addRow(new Object[]{produto.getNome(), produto.getPreco(), produto.getDescricao(), produto.getCategoria(), produto.getQuantidadeDisponivel()});
                }
            }
        }
        
    }//GEN-LAST:event_cb_FiltroCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Adicionar;
    private javax.swing.JButton bt_Carrinho;
    private javax.swing.JButton bt_MaisQuantidade;
    private javax.swing.JButton bt_MenosQuantidade;
    private javax.swing.JButton bt_Voltar;
    private javax.swing.JComboBox<String> cb_FiltroCategoria;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jl_CategoriaProduto;
    private javax.swing.JLabel jl_NomeProduto;
    private javax.swing.JLabel jl_QuantidadeAdd;
    private javax.swing.JLabel jl_QuantidadeProduto;
    private javax.swing.JLabel jl_TotalCarrinho;
    private javax.swing.JLabel jl_ValorProduto;
    private javax.swing.JLabel jp_JanelaFundoCompra;
    private javax.swing.JTable jt_TabelaEstoque;
    private javax.swing.JTextArea ta_InfoProduto;
    // End of variables declaration//GEN-END:variables
}
