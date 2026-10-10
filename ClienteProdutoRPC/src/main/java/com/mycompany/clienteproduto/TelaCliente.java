package com.mycompany.clienteproduto;

public class TelaCliente extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TelaCliente.class.getName());
    private final ClienteProduto cliente = new ClienteProduto();
    private boolean conectado = false;

    public TelaCliente() {
        initComponents();
        setLocationRelativeTo(null);
        atualizarBotoes();
    }

    private void atualizarBotoes() {
        btnConectar.setEnabled(!conectado);
        btnEnviar.setEnabled(conectado);
        btnDesconectar.setEnabled(conectado);
    }
    
    private void limpar() {
        tfNome.setText("");
        tfPreco.setText("");
        tfQuantidade.setText("");
        tfDesconto.setText("");
        tfNome.requestFocus();
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        lblDesconto = new javax.swing.JLabel();
        tfNome = new javax.swing.JTextField();
        tfPreco = new javax.swing.JTextField();
        tfQuantidade = new javax.swing.JTextField();
        tfDesconto = new javax.swing.JTextField();
        lblRespostas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSaida = new javax.swing.JTextArea();
        btnConectar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        btnDesconectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente TCP - Produto");

        lblNome.setText("Nome:");

        lblPreco.setText("Preço:");

        lblQuantidade.setText("Quantidade:");

        lblDesconto.setText("Desconto (%):");

        tfNome.addActionListener(this::tfNomeActionPerformed);

        lblRespostas.setText("Respostas do servidor:");

        taSaida.setEditable(false);
        taSaida.setColumns(20);
        taSaida.setRows(6);
        jScrollPane1.setViewportView(taSaida);

        btnConectar.setText("Conectar");
        btnConectar.addActionListener(this::btnConectarActionPerformed);

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(this::btnEnviarActionPerformed);

        btnDesconectar.setText("Desconectar");
        btnDesconectar.addActionListener(this::btnDesconectarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConectar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDesconectar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome)
                                    .addComponent(lblPreco)
                                    .addComponent(lblQuantidade)
                                    .addComponent(lblDesconto))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfNome)
                                    .addComponent(tfPreco)
                                    .addComponent(tfQuantidade)
                                    .addComponent(tfDesconto)))
                            .addComponent(lblRespostas)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(tfNome))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPreco)
                    .addComponent(tfPreco))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblQuantidade)
                    .addComponent(tfQuantidade))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesconto)
                    .addComponent(tfDesconto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConectar)
                    .addComponent(btnEnviar)
                    .addComponent(btnDesconectar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRespostas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        try {
            cliente.conectar();
            conectado = true;
            atualizarBotoes();
            taSaida.append("Conectado ao servidor.\n");
        } catch (Exception e) {
            taSaida.append("Erro: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        try {
            cliente.desconectar();
            conectado = false;
            atualizarBotoes();
            taSaida.append("Desconectado do servidor.\n");
        } catch (Exception e) {
            taSaida.append("Erro: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnDesconectarActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        try {
            String nome = tfNome.getText();
            double preco = Double.parseDouble(tfPreco.getText());
            int quantidade = Integer.parseInt(tfQuantidade.getText());
            double desconto = Double.parseDouble(tfDesconto.getText());

            String resposta = cliente.enviar(nome, preco, quantidade, desconto);

            taSaida.append(resposta + "\n");
            limpar();

        } catch (Exception e) {
            taSaida.append("Erro: " + e.getMessage() + "\n");
        }
    }//GEN-LAST:event_btnEnviarActionPerformed
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new TelaCliente().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblRespostas;
    private javax.swing.JTextArea taSaida;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPreco;
    private javax.swing.JTextField tfQuantidade;
    // End of variables declaration//GEN-END:variables
}
