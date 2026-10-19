/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package atividadeistemasdistribuidos.view;

import atividadeistemasdistribuidos.controller.ServidorController;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ServidorGUI extends javax.swing.JFrame {

    private final ServidorController controller;
    private final DefaultTableModel tableModel;

    public ServidorGUI() {
        initComponents();
        
        tableModel = new DefaultTableModel(new Object[]{"Nome", "E-mail", "Data Nascimento"}, 0);
        TblPessoas.setModel(tableModel);

        this.controller = new ServidorController();
        this.controller.iniciarServidor(
            mensagemLog -> SwingUtilities.invokeLater(() -> TextAreaLog.append(mensagemLog + "\n")),
            novaPessoa -> SwingUtilities.invokeLater(() -> 
                tableModel.addRow(new Object[]{novaPessoa.getNome(), novaPessoa.getEmail(), novaPessoa.getDataNasc()})
            )
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaLog = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblPessoas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Acadêmico - Servidor");

        TextAreaLog.setEditable(false);
        TextAreaLog.setColumns(20);
        TextAreaLog.setRows(5);
        jScrollPane1.setViewportView(TextAreaLog);

        TblPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Nome", "E-mail", "Data Nascimento"
            }
        ));
        jScrollPane2.setViewportView(TblPessoas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new ServidorGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TblPessoas;
    private javax.swing.JTextArea TextAreaLog;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}