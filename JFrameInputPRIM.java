/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadevs;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author pand1
 */
public class JFrameInputPRIM extends javax.swing.JFrame {
    LinkedList<LinkedList<String>> sublist = 
			new LinkedList<LinkedList<String>>();
    JFrameList list = new JFrameList();
   
    
    /**
     * Creates new form JFrameInputPRIM
     */
    public JFrameInputPRIM() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel = new javax.swing.JLabel();
        jOK = new javax.swing.JButton();
        jPrimKey = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jOK.setText("OK");
        jOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOKActionPerformed(evt);
            }
        });
        jOK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jOKKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel)
                    .addComponent(jPrimKey, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jOK, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel)
                .addGap(32, 32, 32)
                .addComponent(jPrimKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jOK)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOKActionPerformed
        // TODO add your handling code here:
        boolean found = false;
        sublist = list.getList();
        String record = jPrimKey.getText();
        for (int i = 0 ; i < sublist.get(0).size(); i++) {
            if (record.equals(sublist.get(0).get(i)) || record.equals("")) {
                found = true;
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(null, "!! Field name cannot be null or same with previous primary key !!\n Please try again", "Error", JOptionPane.ERROR_MESSAGE);
            JFrameInputPRIM.this.setVisible(false);
            new JFrameInputPRIM().setVisible(true);
        } else {
            sublist.get(0).add(record);
            list.setList(sublist);
            if (sublist.size() <= 1){
                    JFrameInputPRIM.this.setVisible(false);
                    new JFrameMenu().setVisible(true);
                } else {
                    JFrameInputPRIM.this.setVisible(false);
                    new JFrameInput(1).setVisible(true);
                }
        }
        
    }//GEN-LAST:event_jOKActionPerformed

    private void jLabelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabelAncestorAdded
        // TODO add your handling code here:
        sublist = list.getList();
        this.jLabel.setText("Give the value of the primary field: " + sublist.get(0).get(0) );
    }//GEN-LAST:event_jLabelAncestorAdded

    private void jOKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jOKKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER){
             boolean found = false;
            sublist = list.getList();
            String record = jPrimKey.getText();
            for (int i = 0 ; i < sublist.get(0).size(); i++) {
                if (record.equals(sublist.get(0).get(i)) || record.equals("")) {
                    found = true;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(null, "!! Field name cannot be null or same with previous primary key !!\n Please try again", "Error", JOptionPane.ERROR_MESSAGE);
                JFrameInputPRIM.this.setVisible(false);
                new JFrameInputPRIM().setVisible(true);
            } else {
                sublist.get(0).add(record);
                list.setList(sublist);
                if (sublist.size() <= 1){
                    JFrameInputPRIM.this.setVisible(false);
                    new JFrameMenu().setVisible(true);
                } else {
                    JFrameInputPRIM.this.setVisible(false);
                    new JFrameInput(1).setVisible(true);
                }
            }
                
        }
    }//GEN-LAST:event_jOKKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) { 
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
                new JFrameInputPRIM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel;
    private javax.swing.JButton jOK;
    private javax.swing.JTextField jPrimKey;
    // End of variables declaration//GEN-END:variables
}