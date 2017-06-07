package pontocristao.visao;

import java.awt.*;
import java.util.Date;
import javax.swing.JOptionPane;
import org.hibernate.Transaction;
import pontocristao.controle.*;
import pontocristao.modelo.*;
import pontocristao.util.Utilidades;

/**
 *
 * @author Marcondes
 */
public class FrmCaixaRetirada extends javax.swing.JDialog {

    private static Frame frame;
    private ControleCaixa controle;
    private Boolean modeloAtualizado = false;
    private MovimentacaoCaixaRetirada movimentacao;

    public MovimentacaoCaixaRetirada getMovimentacao() {
        return movimentacao;
    }

    public Boolean getModeloAtualizado() {
        return modeloAtualizado;
    }

    public FrmCaixaRetirada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);

        jcData.setDate(new Date());
        jcData.setEnabled(false);

        jspValor.requestFocus();

        InicializarControle();
    }

    public static FrmCaixaRetirada Mostrar(java.awt.Frame parent) {
        frame = parent;
        FrmCaixaRetirada frm = new FrmCaixaRetirada(parent, true);
        frm.setVisible(true);
        return frm;
    }

    private void InicializarControle() {
        controle = new ControleCaixa();
        movimentacao = new MovimentacaoCaixaRetirada();
        movimentacao.setFuncionario(ControleSistema.getFuncionarioLogado(controle.getSessao()));
    }

    private void AtualizarModelo() {
        movimentacao.setData(jcData.getDate());
        movimentacao.setDescricao(txtDescricao.getText());
        movimentacao.setValor((Double) jspValor.getValue());
    }

    public Boolean ValidaCampos() {
        Boolean retorno = true;

        if (txtDescricao.getText().equals("")
                || jspValor.getValue().toString().equals("")) {
            retorno = false;
            JOptionPane.showMessageDialog(null, "Todos os campos em negrito devem estar preenchidos.");
        }

        return retorno;
    }

    @Override
    public void dispose() {
        if (controle != null) {
            controle.Dispose();
        }

        super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDescricao = new javax.swing.JTextField();
        BtnCancelar = new javax.swing.JButton();
        BtnConfirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lValor = new javax.swing.JLabel();
        lDataRetirada = new javax.swing.JLabel();
        jcData = new com.toedter.calendar.JDateChooser();
        jspValor = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        BtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnCancelar.png"))); // NOI18N
        BtnCancelar.setText("Cancelar");
        BtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelarActionPerformed(evt);
            }
        });

        BtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pontocristao/icones/BtnConfirmar.png"))); // NOI18N
        BtnConfirmar.setText("Confirmar");
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Descrição*");

        lValor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lValor.setText("Valor*");

        lDataRetirada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lDataRetirada.setText("Data da Retirada*");

        jspValor.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.1d));
        jspValor.setEditor(new javax.swing.JSpinner.NumberEditor(jspValor, "R$ ###,###.##"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lValor)
                            .addComponent(jspValor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lDataRetirada)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(BtnConfirmar)
                                    .addGap(18, 18, 18)
                                    .addComponent(BtnCancelar))
                                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lValor)
                    .addComponent(lDataRetirada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jspValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnConfirmar)
                    .addComponent(BtnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelarActionPerformed
        Object[] botoes = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(null,
                "Deseja cancelar o cadastro de Retirada? ",
                "Confirmação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                botoes, botoes[0]);
        if (resposta == 0) {
            this.dispose();
        }
    }//GEN-LAST:event_BtnCancelarActionPerformed

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        if (ValidaCampos()) {
            AtualizarModelo();

            Exception erro = null;

            try {
                Transaction transacao = controle.getSessao().getTransaction();
                transacao.begin();

                controle.AdicionarMovimentacao(movimentacao);

                transacao.commit();

            } catch (Exception e) {
                erro = e;
            }

            if (erro != null) {
                Utilidades.MostrarMensagemErro(erro);
            } else {
                modeloAtualizado = true;
                this.dispose();
            }
        }
    }//GEN-LAST:event_BtnConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmCaixaRetirada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCaixaRetirada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCaixaRetirada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCaixaRetirada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCaixaRetirada dialog = new FrmCaixaRetirada(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancelar;
    private javax.swing.JButton BtnConfirmar;
    private javax.swing.JLabel jLabel1;
    private com.toedter.calendar.JDateChooser jcData;
    private javax.swing.JSpinner jspValor;
    private javax.swing.JLabel lDataRetirada;
    private javax.swing.JLabel lValor;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
