package view;

import dao.EditoraDAO;
import dao.LivroDAO;
import entity.Livro;
import entity.Editora;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import main.Main;

public class CadastrarLivro extends javax.swing.JFrame {

    public CadastrarLivro() {
        initComponents();
        textFieldPrice.setDocument(new numerosPermitidos());
        setLocationRelativeTo(null);
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter(tabela));

        listarTabela();
    }

    public void listarTabela() {
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        tabela.setNumRows(0);
        LivroDAO livroDAO = new LivroDAO();

        for (Livro livro : livroDAO.listarLivro()) {
            tabela.addRow(new Object[]{
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                livro.getPublisher_id().getName(),
                livro.getPrice()
            });
        }
    }

    public void pesquisarTabela(String descricao, String de) {
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        tabela.setNumRows(0);
        LivroDAO livroDAO = new LivroDAO();

        for (Livro livro : livroDAO.pesquisarLivro(descricao, de)) {
            tabela.addRow(new Object[]{
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textFieldTitulo = new javax.swing.JTextField();
        textFieldIsbn = new javax.swing.JTextField();
        comboBoxEditora = new javax.swing.JComboBox();
        textFieldPrice = new javax.swing.JTextField();
        buttonCadastrar = new javax.swing.JButton();
        buttonPesquisar = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonExcluir = new javax.swing.JButton();
        buttonLimpar = new javax.swing.JButton();
        buttonVoltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Titulo");

        jLabel2.setText("ISBN");

        jLabel3.setText("Editora");

        jLabel4.setText("Cadastro de livros");

        jLabel5.setText("Preço");

        textFieldTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTituloActionPerformed(evt);
            }
        });

        comboBoxEditora.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                comboBoxEditoraAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        textFieldPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPriceActionPerformed(evt);
            }
        });

        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        buttonPesquisar.setText("Pesquisar");
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        buttonExcluir.setText("Excluir");
        buttonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirActionPerformed(evt);
            }
        });

        buttonLimpar.setText("Limpar");
        buttonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparActionPerformed(evt);
            }
        });

        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "TITULO", "ISBN", "EDITORA", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(buttonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(textFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCadastrar)
                    .addComponent(buttonPesquisar)
                    .addComponent(buttonEditar)
                    .addComponent(buttonExcluir)
                    .addComponent(buttonLimpar)
                    .addComponent(buttonVoltar))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 142, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTituloActionPerformed

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        // TODO add your handling code here:
        if (textFieldTitulo.getText().equals("") || textFieldIsbn.getText().equals("") || textFieldPrice.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Os campos são obrigatórios", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Livro livro = new Livro();
        Editora editora = new Editora();
        LivroDAO livroDAO = new LivroDAO();

        livro.setTitulo(textFieldTitulo.getText());
        livro.setIsbn(textFieldIsbn.getText());
        editora = (Editora) comboBoxEditora.getSelectedItem();
        livro.setPublisher_id(editora);
        livro.setPrice(Float.parseFloat(textFieldPrice.getText()));
        livroDAO.inserirLivro(livro);

        textFieldTitulo.setText("");
        textFieldIsbn.setText("");
        textFieldPrice.setText("");

        listarTabela();
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void buttonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparActionPerformed
        // TODO add your handling code here:
        textFieldTitulo.setText("");
        textFieldIsbn.setText("");
        textFieldPrice.setText("");
    }//GEN-LAST:event_buttonLimparActionPerformed

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        // TODO add your handling code here:
        pesquisarTabela(textFieldTitulo.getText(), textFieldIsbn.getText());
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private void buttonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            Livro livro = new Livro();
            LivroDAO livroDAO = new LivroDAO();
            
            livro.setId((int)jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            livroDAO.excluirLivro(livro);
            
            textFieldTitulo.setText("");
            textFieldIsbn.setText("");
            textFieldPrice.setText("");
            
            listarTabela();
        }
    }//GEN-LAST:event_buttonExcluirActionPerformed

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        // TODO add your handling code here:
        dispose();
        Main main = new Main();
        main.setVisible(true);
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow() != -1) {
            Livro livro = new Livro();
            Editora editora = new Editora();
            LivroDAO livroDAO = new LivroDAO();

            livro.setTitulo(textFieldTitulo.getText());
            livro.setIsbn(textFieldTitulo.getText());
            editora = (Editora) comboBoxEditora.getSelectedItem();
            livro.setPublisher_id(editora);
            livro.setPrice(Float.parseFloat(textFieldPrice.getText()));
            livro.setId((int) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
            livroDAO.editarLivro(livro);

            textFieldTitulo.setText("");
            textFieldIsbn.setText("");
            textFieldPrice.setText("");

            listarTabela();
        }
    }//GEN-LAST:event_buttonEditarActionPerformed


    private void textFieldPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldPriceActionPerformed

    private void comboBoxEditoraAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_comboBoxEditoraAncestorAdded
        // TODO add your handling code here:
        EditoraDAO editoraDAO = new EditoraDAO();
        List<Editora> listaEditora = editoraDAO.listarEditora();

        comboBoxEditora.removeAll();

        for (Editora editora : listaEditora) {
            comboBoxEditora.addItem(editora);
        }
    }//GEN-LAST:event_comboBoxEditoraAncestorAdded

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        listarTabela();
    }//GEN-LAST:event_formWindowActivated

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectRow = jTable1.getSelectedRow();

        textFieldTitulo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        textFieldIsbn.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());

        String comoBox = jTable1.getValueAt(selectRow, 3).toString();
        for (int i = 0; i < comboBoxEditora.getItemCount(); i++) {
            if (comboBoxEditora.getItemAt(i).toString().equalsIgnoreCase(comoBox)) {
                comboBoxEditora.setSelectedIndex(i);
            }
        }
        textFieldPrice.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonExcluir;
    private javax.swing.JButton buttonLimpar;
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JComboBox comboBoxEditora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textFieldIsbn;
    private javax.swing.JTextField textFieldPrice;
    private javax.swing.JTextField textFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
