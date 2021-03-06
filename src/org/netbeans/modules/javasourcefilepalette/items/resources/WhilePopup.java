/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette.items.resources;

import edu.mass.qcc.qcccodewizard.CheckVariableName;
import edu.mass.qcc.qcccodewizard.CodeDrop;
import edu.mass.qcc.qcccodewizard.GroupButtonUtils;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.modules.javasourcefilepalette.OpenHelpUrl;
import org.netbeans.modules.javasourcefilepalette.items.While;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

/**
 *
 * @author Ian
 * @author Dale Diaz
 */
public class WhilePopup extends javax.swing.JPanel {

    private Dialog dialog = null;
    private DialogDescriptor descriptor = null;
    private boolean dialogOK = false;
    While ifitem;
    JTextComponent target;

    /**
     * Creates new Popup form
     * @param item
     * @param target  
     */
    public WhilePopup(While item, JTextComponent target) {
        this.ifitem = item;
        this.target = target;
        initComponents();

    }

    /**
     *
     * @return
     */
    public boolean showDialog() {
        addWhileButton.setVisible(false);
        dialogOK = false;

        String displayName = "";
        try {
            displayName = NbBundle.getBundle("org.netbeans.modules.javasourcefilepalette.items.resources.Bundle").getString("NAME_html-while");
        } catch (Exception e) {
        }

        descriptor = new DialogDescriptor(this, NbBundle.getMessage(NewObjectPopup.class, "LBL_Customizer_InsertPrefix") + " " + displayName, true,
                DialogDescriptor.OK_CANCEL_OPTION, DialogDescriptor.CANCEL_OPTION,
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!descriptor.getValue().equals(DialogDescriptor.CANCEL_OPTION)) {
                            evaluateInput();
                            dialogOK = true;

                            addWhileButton.doClick();
                        }
                        dialog.dispose();

                    }
                });

        dialog = DialogDisplayer.getDefault().createDialog(descriptor);

        dialog.setVisible(true);
        repaint();

        return dialogOK;

    }

    private void evaluateInput() {

        String comment = jTextField1.getText();
        ifitem.setComment(comment);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        ifPane = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        addWhileButton = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        orAppendButton = new javax.swing.JButton();
        andAppendButton = new javax.swing.JButton();
        addExpressionButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        whileBody = new javax.swing.JEditorPane();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.jLabel1.text")); // NOI18N

        jTextField1.setText(org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.jTextField1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel13, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.jLabel13.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel14, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.jLabel14.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel15, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.jLabel15.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addWhileButton, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.addWhileButton.text")); // NOI18N
        addWhileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWhileButtonActionPerformed(evt);
            }
        });

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/mass/qcc/qcccodewizard/Question.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel34, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.jLabel34.text")); // NOI18N
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel42, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.jLabel42.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(orAppendButton, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.orAppendButton.text")); // NOI18N
        orAppendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orAppendButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(andAppendButton, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.andAppendButton.text")); // NOI18N
        andAppendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                andAppendButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(addExpressionButton, org.openide.util.NbBundle.getMessage(WhilePopup.class, "WhilePopup.addExpressionButton.text")); // NOI18N
        addExpressionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExpressionButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(whileBody);

        javax.swing.GroupLayout ifPaneLayout = new javax.swing.GroupLayout(ifPane);
        ifPane.setLayout(ifPaneLayout);
        ifPaneLayout.setHorizontalGroup(
            ifPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ifPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ifPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34)
                    .addGroup(ifPaneLayout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addWhileButton)
                        .addGap(138, 138, 138)
                        .addComponent(addExpressionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(andAppendButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orAppendButton))
                    .addGroup(ifPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel15)
                        .addGroup(ifPaneLayout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ifPaneLayout.setVerticalGroup(
            ifPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ifPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ifPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ifPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addComponent(jLabel13))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel15)
                .addGap(5, 5, 5)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ifPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(addWhileButton)
                    .addComponent(orAppendButton)
                    .addComponent(andAppendButton)
                    .addComponent(addExpressionButton))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ifPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ifPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addWhileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWhileButtonActionPerformed
        // Adds a while loop to the document
        // Get the currently open java source
        try {
            JTextComponent jtc = EditorRegistry.lastFocusedComponent();
            CodeDrop codedrop = new CodeDrop();
            //get the name for the condition variable, get the operator, and variable or value

            //String varName;
            //String varValue;
            //String varBody;
            //String varOperator;

            //if (whileName.getSelectedItem().toString() != null) {
                //varName = whileName.getSelectedItem().toString();

            //} else {
                //varName = "";
            //}
            //if ((whileOp.getSelectedIndex() != -1)) {
                //varOperator = whileOp.getSelectedItem().toString();
            //} else {
                //varOperator = "";
            //}
            //if (whileValue.getSelectedItem() != null) {
                //varValue = whileValue.getSelectedItem().toString();
            //} else {
                //varValue = "";
            //}
            //varBody = whileBody.getText();
            CheckVariableName cvn = new CheckVariableName();
            if (cvn.isGood("x")) {
                //If name is valid, add it to the editor.
                System.out.println("Valid Variable Name Found");
                String code = "while(" + whileBody.getText() + ")\n" + "{\n\n" + "\t}";
                try {
                    //Insert into document
                    System.out.println("Inserting Code");
                    CodeDrop.insert(code, jtc);
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                }
            } else {

                JOptionPane.showMessageDialog(this, "Invalid Variable Name. Try Again.");
                System.out.println("Variable name not valid!");
            }

        } catch (java.lang.Throwable t) {

            JOptionPane.showMessageDialog(this, "All Fields must be filled out.");

        }
    }//GEN-LAST:event_addWhileButtonActionPerformed

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        // Help Page
        OpenHelpUrl o = new OpenHelpUrl("http://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html");
    }//GEN-LAST:event_jLabel34MouseClicked

    /**
     * Method that adds an "and" operator to the expression window
     * @param evt "And" button clicked
     */
    private void andAppendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_andAppendButtonActionPerformed
        whileBody.replaceSelection(" && ");
    }//GEN-LAST:event_andAppendButtonActionPerformed

    /**
     * Method that adds an "or" operator to the expression window
     * @param evt "Or" button clicked
     */
    private void orAppendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orAppendButtonActionPerformed
        whileBody.replaceSelection(" || ");
    }//GEN-LAST:event_orAppendButtonActionPerformed

    private void addExpressionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExpressionButtonActionPerformed
        ExpressionPopup exp = new ExpressionPopup(null, whileBody);
        exp.showDialog();
        whileBody.replaceSelection(exp.getExpression());
    }//GEN-LAST:event_addExpressionButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExpressionButton;
    private javax.swing.JButton addWhileButton;
    private javax.swing.JButton andAppendButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel ifPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton orAppendButton;
    private javax.swing.JEditorPane whileBody;
    // End of variables declaration//GEN-END:variables
}
