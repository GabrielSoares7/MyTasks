package gui;

import javax.swing.JOptionPane;
import modelo.Quadro;
import modelo.Usuario;
import servicos.QuadroServico;

public class JQuadros extends javax.swing.JFrame implements IAcoesTelaFilha {
    
    private final Usuario usuario;
    private final IAcoesTelaFilha iAcoesTelaFilha;
    
    public JQuadros(IAcoesTelaFilha iAcoesTelaFilha, Usuario usuario) {
        initComponents();
        setLocationRelativeTo(null);
        this.usuario = usuario;
        atualizarLista();
        jLabelBoasVindas.setText("Bem-vindx " + usuario.getNome());
        this.iAcoesTelaFilha = iAcoesTelaFilha;
    }

    @Override
    public void abrir() {
        setVisible(true);
        iAcoesTelaFilha.abrir();
    }
    
    public void atualizarLista() {
        usuario.setQuadros(QuadroServico.retornarQuadros(usuario));
        
        jListQuadros.setModel(new javax.swing.AbstractListModel<String>() {
            @Override
            public int getSize() {
                return usuario.getQuadros().size(); 
            }
            
            @Override
            public String getElementAt(int i) {
                return usuario.getQuadros().get(i).getNome(); 
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelBoasVindas = new javax.swing.JLabel();
        jLabelQuadros = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListQuadros = new javax.swing.JList<>();
        jButtonAbrir = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                onDispose(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onDispose(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelBoasVindas.setText("Bem-vindo!");

        jLabelQuadros.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabelQuadros.setText("Seus quadros:");

        jListQuadros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListQuadros);

        jButtonAbrir.setText("Abrir");
        jButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(0, 102, 102));
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDeletar.setBackground(new java.awt.Color(255, 0, 0));
        jButtonDeletar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDeletar.setText("Deletar");
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBoasVindas)
                            .addComponent(jLabelQuadros))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAbrir)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBoasVindas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelQuadros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAbrir)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonDeletar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        String nome = JOptionPane.showInputDialog("Digite o nome do seu quadro:");
        try {
            QuadroServico.salvar(new Quadro(nome), usuario);
            atualizarLista();
        }
        catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void onDispose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onDispose
        iAcoesTelaFilha.fechar();
    }//GEN-LAST:event_onDispose

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        int i = jListQuadros.getSelectedIndex();
        
        if(i >= 0) {
            QuadroServico.deletarQuadro(usuario.getQuadros().get(i));
            atualizarLista();
        }
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void jButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirActionPerformed
        int i = jListQuadros.getSelectedIndex();
        
        if(i >= 0) {
            JQuadro jQuadro = new JQuadro(this, usuario.getQuadros().get(i), usuario);
            jQuadro.abrir();
        }
    }//GEN-LAST:event_jButtonAbrirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrir;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JLabel jLabelBoasVindas;
    private javax.swing.JLabel jLabelQuadros;
    private javax.swing.JList<String> jListQuadros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void fechar() {
        atualizarLista();
    }
}
