package gui;

import modelo.Quadro;
import modelo.Usuario;
import servicos.TarefaServico;

public class JQuadro extends javax.swing.JFrame implements IAcoesTelaFilha{

    private final Quadro quadro;
    private final IAcoesTelaFilha iAcoesTelaFilha;
    private final Usuario usuario;
    
    public JQuadro(IAcoesTelaFilha iAcoesTelaFilha, Quadro quadro, Usuario usuario) {
        initComponents();
        setLocationRelativeTo(null);
        this.iAcoesTelaFilha = iAcoesTelaFilha;
        this.quadro = quadro;
        jTextFieldQuadro.setText(quadro.getNome());
        atualizarLista();
        this.usuario = usuario;
    }
    
    @Override
    public void abrir() {
        setVisible(true);
    }
    
    @Override
    public void fechar() {
        atualizarLista();
    }

    private void atualizarLista() {
        quadro.setTarefas(TarefaServico.carregarTarefasPorQuadro(quadro));
        jList.setModel(new javax.swing.AbstractListModel<String>() {
            @Override
            public int getSize() {
                return quadro.getTarefas().size();
            }
            
            @Override
            public String getElementAt(int i) {
                return (quadro.getTarefas().get(i).isFeito() ? "☑ " : "☐ ") 
                        + quadro.getTarefas().get(i).getTitulo(); 
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldQuadro = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonDetalhes = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                onDispose(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onDispose(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jTextFieldQuadro.setText("jTextField1");

        jButtonAdd.setBackground(new java.awt.Color(0, 102, 0));
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDetalhes.setText("Detalhes");
        jButtonDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDetalhesActionPerformed(evt);
            }
        });

        jList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList);

        jButton1.setBackground(new java.awt.Color(204, 51, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Deletar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDetalhes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuadro, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldQuadro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonDetalhes)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onDispose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onDispose
        try {
            iAcoesTelaFilha.fechar();
            quadro.setNome(jTextFieldQuadro.getText());
            servicos.QuadroServico.salvar(quadro, usuario);
        }
        catch (RuntimeException ex) {}
    }//GEN-LAST:event_onDispose

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        JTarefa jTarefa = new JTarefa(this, quadro);
        jTarefa.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDetalhesActionPerformed
        int i = jList.getSelectedIndex();
        
        if(i >= 0) {
            JTarefa jTarefa = new JTarefa (this, quadro.getTarefas().get(i), quadro);
            jTarefa.setVisible(true);
        }
    }//GEN-LAST:event_jButtonDetalhesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = jList.getSelectedIndex();
        
        if(i >= 0) {
            TarefaServico.delete(quadro.getTarefas().get(i));
            atualizarLista();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMouseClicked
        int i = jList.getSelectedIndex();
        
        if(i >= 0) {
            quadro.getTarefas().get(i).setFeito();
            TarefaServico.salvar(quadro.getTarefas().get(i), quadro);
            atualizarLista();
            jList.setSelectedIndex(i);
        }
    }//GEN-LAST:event_jListMouseClicked
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDetalhes;
    private javax.swing.JList<String> jList;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldQuadro;
    // End of variables declaration//GEN-END:variables

}
