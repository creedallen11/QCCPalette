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
import org.netbeans.modules.javasourcefilepalette.items.StringArray;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

/**
 * Constructs an array based for code drop based on user parameters/choices.
 * @author Ian
 * @author Creed
 */
public class StringArrayPopup extends javax.swing.JPanel {

    private Dialog dialog = null;
    private DialogDescriptor descriptor = null;
    private boolean dialogOK = false;
    StringArray ifitem;
    JTextComponent target;

    /**
     * Creates new Popup form
     *
     * @param item
     * @param target
     */
    public StringArrayPopup(StringArray item, JTextComponent target) {
        this.ifitem = item;
        this.target = target;
        initComponents();

    }

    /**
     *
     * @return
     */
    public boolean showDialog() {
        addVariableButton.setVisible(false);
        dialogOK = false;

        String displayName = "";
        try {
            displayName = NbBundle.getBundle("org.netbeans.modules.javasourcefilepalette.items.resources.Bundle").getString("NAME_html-stringArray");
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

                    addVariableButton.doClick();
                }
                dialog.dispose();

            }
        });

        dialog = DialogDisplayer.getDefault().createDialog(descriptor);

        dialog.setVisible(true);
        repaint();

        return dialogOK;

    }

    /**
     * Builds code drop based on parameters. 
     * @return 
     */
    private String arrayFormatter() {
        //Find the type of variable
        GroupButtonUtils gbu = new GroupButtonUtils();
        String varType = gbu.getSelectedButtonText(buttonGroup1);
        StringBuilder sb = new StringBuilder();
        boolean sizeSpecified, contentProvided;
        int size = 0;
        try {
            size = Integer.parseInt(sizeField.getText());
            sizeSpecified = true;
            
        } catch (Exception e) {
            sizeSpecified = false;
        }
        // no contents and size is not specified
        if (arrayElementTextArea.getText().isEmpty() && !sizeSpecified)
        {
            sb.append(varType+"[] "+arrayName.getText()+";");
        }
        else if (arrayElementTextArea.getText().isEmpty() && sizeSpecified)
        {
            sb.append(varType+"[] "+arrayName.getText()+" = new "+varType+"["+ size +"];");
        }
        else if (!arrayElementTextArea.getText().isEmpty())
        {
            String[] arrayElements = arrayElementTextArea.getText().split(" ");
            
            if (varType.equals("String"))
            {
                sb.append(varType+"[] "+ arrayName.getText()+ " = {");
                        int count = 0;
                        for (String elements : arrayElements) {
                            if (count == arrayElements.length - 1) {
                                sb.append("\"").append(elements).append("\"");

                            } else {
                                sb.append("\"").append(elements).append("\"").append(", ");
                            }
                            count++;
                        }

                        sb.append("};");
            }
            else if (varType.equals("char"))
            {
                sb.append(varType+"[] "+ arrayName.getText()+ " = {");
                        int count = 0;
                        for (String elements : arrayElements) {
                            if (count == arrayElements.length - 1) {
                                sb.append("'").append(elements).append("'");

                            } else {
                                sb.append("'").append(elements).append("'").append(", ");
                            }
                            count++;
                        }

                        sb.append("};");
            }
            else if (varType.equals("boolean"))
            {
                sb.append(varType+"[] "+ arrayName.getText()+ " = {");
                int count = 0;
                for (String elements : arrayElements) {
                            if (count == arrayElements.length - 1) {
                                sb.append(" ").append(elements).append(" ");

                            } else {
                                sb.append(" ").append(elements).append(" ").append(", ");
                            }
                            count++;
                        }
                sb.append("};");
            }
            else if (varType.equals("int") || varType.equals("byte") || 
                    varType.equals("short") || varType.equals("long")
                    || varType.equals("double") || varType.equals("float"))
            {
                sb.append(varType+"[] "+ arrayName.getText()+ " = {");
                int count = 0;
                for (String elements : arrayElements) {
                            if (count == arrayElements.length - 1) {
                                sb.append(" ").append(elements).append(" ");

                            } else {
                                sb.append(" ").append(elements).append(" ").append(", ");
                            }
                            count++;
                        }
                sb.append("};");
            }
        }
        
        String built = sb.toString();
        
        return built;

    }

    /**
     * Comment check. Could be made into 1 method for project. 
     */
    private void evaluateInput() {

        String comment = arrayComment.getText();
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
        arrayComment = new javax.swing.JTextField();
        varPane = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        addVariableButton = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        arrayName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arrayElementTextArea = new javax.swing.JTextArea();
        sizeField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jLabel1.text")); // NOI18N

        arrayComment.setText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.arrayComment.text")); // NOI18N
        arrayComment.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.arrayComment.toolTipText")); // NOI18N

        varPane.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.varPane.border.title"))); // NOI18N
        varPane.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.varPane.toolTipText")); // NOI18N

        buttonGroup1.add(jRadioButton1);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton1, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton1.text")); // NOI18N
        jRadioButton1.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton1.toolTipText")); // NOI18N

        buttonGroup1.add(jRadioButton2);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton2, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton2.text")); // NOI18N
        jRadioButton2.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton2.toolTipText")); // NOI18N

        buttonGroup1.add(jRadioButton3);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton3, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton3.text")); // NOI18N
        jRadioButton3.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton3.toolTipText")); // NOI18N

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton4, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton4.text")); // NOI18N
        jRadioButton4.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton4.toolTipText")); // NOI18N

        buttonGroup1.add(jRadioButton5);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton5, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton5.text")); // NOI18N
        jRadioButton5.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton5.toolTipText")); // NOI18N

        buttonGroup1.add(jRadioButton6);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton6, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton6.text")); // NOI18N
        jRadioButton6.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton6.toolTipText")); // NOI18N

        buttonGroup1.add(jRadioButton7);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton7, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton7.text")); // NOI18N
        jRadioButton7.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton7.toolTipText")); // NOI18N

        buttonGroup1.add(jRadioButton8);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton8, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton8.text")); // NOI18N
        jRadioButton8.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton8.toolTipText")); // NOI18N

        buttonGroup1.add(jRadioButton9);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton9, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton9.text")); // NOI18N
        jRadioButton9.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jRadioButton9.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(addVariableButton, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.addVariableButton.text")); // NOI18N
        addVariableButton.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.addVariableButton.toolTipText")); // NOI18N
        addVariableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVariableButtonActionPerformed(evt);
            }
        });

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/mass/qcc/qcccodewizard/Question.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel33, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jLabel33.text")); // NOI18N
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel39, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jLabel39.text")); // NOI18N

        arrayName.setText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.arrayName.text")); // NOI18N
        arrayName.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.arrayName.toolTipText")); // NOI18N

        javax.swing.GroupLayout varPaneLayout = new javax.swing.GroupLayout(varPane);
        varPane.setLayout(varPaneLayout);
        varPaneLayout.setHorizontalGroup(
            varPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(varPaneLayout.createSequentialGroup()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33))
            .addGroup(varPaneLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arrayName, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addVariableButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        varPaneLayout.setVerticalGroup(
            varPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(varPaneLayout.createSequentialGroup()
                .addGroup(varPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(varPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton3)
                        .addComponent(jRadioButton4)
                        .addComponent(jRadioButton5)
                        .addComponent(jRadioButton6)
                        .addComponent(jRadioButton7)
                        .addComponent(jRadioButton8)
                        .addComponent(jRadioButton9))
                    .addComponent(jLabel33))
                .addGap(0, 1, Short.MAX_VALUE)
                .addGroup(varPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel39)
                    .addComponent(addVariableButton)
                    .addComponent(arrayName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jPanel2.border.title"))); // NOI18N

        arrayElementTextArea.setColumns(20);
        arrayElementTextArea.setRows(5);
        jScrollPane1.setViewportView(arrayElementTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sizeField.setText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.sizeField.text")); // NOI18N
        sizeField.setToolTipText(org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.sizeField.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(StringArrayPopup.class, "StringArrayPopup.jLabel2.text")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(varPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(arrayComment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sizeField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(arrayComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(0, 0, 0)
                .addComponent(varPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 14, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addVariableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVariableButtonActionPerformed
        //Creates new array in the document.

        //Get the currently open java source
        try {
            JTextComponent jtc = EditorRegistry.lastFocusedComponent();
            CodeDrop codedrop = new CodeDrop();

            GroupButtonUtils gbu = new GroupButtonUtils(); //Find the type of variable
            String varType;
            if (gbu.getSelectedButtonText(buttonGroup1) != null) {
                varType = gbu.getSelectedButtonText(buttonGroup1);

                //Get the name for the variable
                String varName = arrayName.getText();
                System.out.println(varName);
                String code = arrayFormatter();
                //Make sure its a valid variable name...
                CheckVariableName cvn = new CheckVariableName();
                if (cvn.isGood(varName)) {
                    //If name is valid, check for elements and add it to the editor.


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

            }
        } catch (java.lang.Throwable t) {

            JOptionPane.showMessageDialog(this, "All Fields must be filled out.");

        }
        //Call combobox models visit method to update with the new variable.
    }//GEN-LAST:event_addVariableButtonActionPerformed

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        // Help Page
        OpenHelpUrl o = new OpenHelpUrl("http://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html");
    }//GEN-LAST:event_jLabel33MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVariableButton;
    private javax.swing.JTextField arrayComment;
    private javax.swing.JTextArea arrayElementTextArea;
    private javax.swing.JTextField arrayName;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField sizeField;
    private javax.swing.JPanel varPane;
    // End of variables declaration//GEN-END:variables
}
