package br.com.adson.view;

import br.com.adson.util.*;
import br.com.adson.util.Util;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class PequisaView extends javax.swing.JFrame {

   
    public String getNomeCliente() {
        return nomeCliente;
    }

   
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    private String nomeCliente;
    private DefaultTableModel model;
    
    public PequisaView() {
        initComponents();
        
        carregarDadosTabela();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPesquisaNome = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pequisa cliente");

        jLabel1.setText("Nome:");

        btnPesquisar.setText("Pequisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Email", "Sexo", "Data de Nasci", "Fone"
            }
        ));
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar)
                .addContainerGap(333, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPesquisaNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnLimpar))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        
        model = (DefaultTableModel) tabelaClientes.getModel();
        TableRowSorter sorter = new TableRowSorter<TableModel>(model);
        tabelaClientes.setRowSorter(sorter);
        
        String nome = txtPesquisaNome.getText();
        if(nome != null) {
            sorter.setRowFilter(RowFilter.regexFilter(("(?i)" + nome)));
        }else{ 
            sorter.setRowFilter(null);
        }
        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        
        ListSelectionModel tabelaSelectionModel = tabelaClientes.getSelectionModel();
        // limpeza de cache
        tabelaClientes.setSelectionModel(tabelaSelectionModel);
        
        setNomeCliente(tabelaClientes.getValueAt(tabelaClientes.getSelectedRow(), 1).toString());
        txtPesquisaNome.setText(getNomeCliente());
        
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtPesquisaNome.setText("");
        btnPesquisarActionPerformed(evt);
    }//GEN-LAST:event_btnLimparActionPerformed

   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PequisaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtPesquisaNome;
    // End of variables declaration//GEN-END:variables

    private void carregarDadosTabela() {
       
         String sql = "select cli_cod, cli_nome, cli_cpf, cli_email, cli_sexo, "
                + "cli_dt_nasc, cli_fone  from cliente order by cli_cod";
        
        try {
            
            Connection conn = ConnectionFactory.getConexao();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            tabelaClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(180);
            tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(180);
            tabelaClientes.getColumnModel().getColumn(4).setPreferredWidth(70);
            tabelaClientes.getColumnModel().getColumn(5).setPreferredWidth(80);
            tabelaClientes.getColumnModel().getColumn(6).setPreferredWidth(100);
            
            model = (DefaultTableModel) tabelaClientes.getModel();
            
            while(rs.next()) {
                Integer rsCodigo = rs.getInt("cli_cod");
                String rsNome = rs.getString("cli_nome");
                String rsCpf = rs.getString("cli_cpf");
                String rsEmail = rs.getString("cli_email");
                String rsSexo = rs.getString("cli_sexo");
                if(rs.equals("M")) {
                    rsSexo = "Masculino";
                }else {
                    rsSexo = "Feminino";
                }
                
                Date rsNasc = rs.getDate("cli_dt_nasc");
                String rsFone = rs.getString("cli_fone");
                
                // preenche os dados na Jtable que estão retornando do banco de dados
                
                model.addRow(new Object[]{rsCodigo, rsNome,rsCpf,rsEmail,rsSexo,Util.converterToString(rsNasc),rsFone});
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela " + ex);
            ex.printStackTrace();
        }
        
    }
}
