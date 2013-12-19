/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette.items.resources;

import edu.mass.qcc.qcccodewizard.CheckVariableName;
import edu.mass.qcc.qcccodewizard.CodeDrop;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.EditorRegistry;
import org.netbeans.modules.javasourcefilepalette.OpenHelpUrl;
import org.netbeans.modules.javasourcefilepalette.items.NewObject;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

/**
 * Opens window that supports object instantiation.
 * @author Ian
 * @author Creed
 */
public class NewObjectPopup extends JPanel {

    private Dialog dialog = null;
    private DialogDescriptor descriptor = null;
    private boolean dialogOK = false;
    NewObject ifitem;
    JTextComponent target;
    private HashMap paramDefs;

    /**
     * Creates new form ItemCustomizer
     *
     * @param item
     * @param target
     */
    public NewObjectPopup(NewObject item, JTextComponent target) {
        this.ifitem = item;
        this.target = target;
        this.paramDefs = new HashMap();
        
        // Sets values for param tool tips. Could be built off text file. 
        paramDefs.put("ArrayList", "Takes a type parameter. Ex <String>");
        paramDefs.put("BufferedReader", "Takes a reader.");
        paramDefs.put("File", "Specifcy string path in parameters.");
        paramDefs.put("FileReader", "Constructs with file or string with path to "
                + "file");
        paramDefs.put("FileWriter", "Constructs with file or string with path to "
                + "file");
        paramDefs.put("HashMap", "Can construct empty, or with an Int specifying capacity.");
        paramDefs.put("InputStream", "After instantiation specify the input stream type + parameters.");
        paramDefs.put("InputStreamReader", "First param is the InputStream second is the char/string type.");
        paramDefs.put("Iterator", "Takes a type parameter. Ex <String>");
        paramDefs.put("Object", "Object takes no parameters.");
        paramDefs.put("OutputStream", "Superclass that does not take parameters.");
        paramDefs.put("PrintWriter", "Takes output file as param, Ex.'output.txt");
        paramDefs.put("Scanner", "Can take a file, sys, stream, path.");
        paramDefs.put("String", "String is an object, but best to construct as: String newString = 'Sample Text'");
        paramDefs.put("StringBuilder", "Most common parameter will be the String.");
        paramDefs.put("InputStreamReader", "First param is the InputStream second is the char/string type.");
        paramDefs.put("Thread", "See Javadoc.");
        initComponents();
    }

    /**
     * Method used to update the tool tip for object parameters after a user
     * changed the object type in the type combobox. 
     * @param objType
     * @return object type as string
     */
    public String getTooltip(JComboBox objType) {
        String toolTip = (String) paramDefs.get(objType.getSelectedItem());
        return toolTip;
    }

    /**
     * Get method used to rebuild the preview window.
     *
     * @param jtc user options
     * @return String with text field's value.
     */
    private String getValue(JTextField jtc) {
        String value;
        if (jtc != null) {
            value = jtc.getText();
        } else {
            value = "[Complete All Fields]";
        }
        return value;
    }

    /**
     * Method that finds obj type in order to make build changes,
     *
     * @param jcb
     * @return
     */
    private String getType(JComboBox jcb) {
        String type = (String) objectName.getSelectedItem();
        return type;
    }

    private String buildParams(JTextField jtc) {
        StringBuilder parsedParams = new StringBuilder();
        if (!getType(objectName).equals("ArrayList") && !getType(objectName).equals("Iterator")) {
            String[] param = params.getText().toString().split(",");
            int count = 0;
            for (String p : param) {
                if (count == param.length - 1) {
                    parsedParams.append(p).append(");");
                } else {
                    parsedParams.append(p).append(", ");
                }
                count++;
            }
            String dropParams = parsedParams.toString();
            return dropParams;
        } else {
            String type = "<" + params.getText() + ">"; // type parameter 
            return type;
        }
    }

    /**
     * Rebuilds the preview window. Is called after any changes to input
     * options.
     */
    private void repopulate() {
        previewField.setText(""); //clear the field
        if (!getType(objectName).equals("ArrayList") && !getType(objectName).equals("Iterator")) {
            previewField.append(getType(objectName) + " " + getValue(varName) + " = new "
                    + getType(objectName) + "(" + buildParams(params) + "//" + getValue(objComment));
        } else {
            previewField.append(getType(objectName) + buildParams(params) + " " + getValue(varName) + " = new "
                    + getType(objectName) + buildParams(params) +"();" + "//" + getValue(objComment));
        }
    }

    /**
     * Validates comment for drop.
     *
     * @return
     */
    public boolean showDialog() {
        instObjectButton.setVisible(false);
        dialogOK = false;

        String displayName = "";
        try {
            displayName = NbBundle.getBundle("org.netbeans.modules.javasourcefilepalette.items.resources.Bundle").getString("Name_HTML_newObject");
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
                }
                dialog.dispose();
                instObjectButton.doClick();
            }
        });

        dialog = DialogDisplayer.getDefault().createDialog(descriptor);

        dialog.setVisible(true);
        repaint();

        return dialogOK;

    }

    /**
     * Sets comment for object drop.
     */
    private void evaluateInput() {

        String comment = objComment.getText();
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
        jLabel1 = new javax.swing.JLabel();
        objComment = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        objectName = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        varName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        instObjectButton = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        params = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        previewField = new javax.swing.JTextArea();
        previewButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.jLabel1.text")); // NOI18N

        objComment.setText(org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.objComment.text")); // NOI18N
        objComment.setToolTipText(org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.objComment.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.jLabel4.text")); // NOI18N

        objectName.setEditable(true);
        objectName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ArrayList", "BufferedReader", "File", "FileReader", "FileWriter", "HashMap", "InputStream", "InputStreamReader", "Iterator", "Object", "OutputStream", "PrintWriter", "Scanner", "String", "StringBuilder", "Thread" }));
        objectName.setToolTipText(org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.objectName.toolTipText")); // NOI18N
        objectName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                objectNameActionPerformed(evt);
            }
        });
        objectName.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                objectNamePropertyChange(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.jLabel10.text")); // NOI18N

        varName.setText(org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.varName.text")); // NOI18N
        varName.setToolTipText(org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.varName.toolTipText")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel11, org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.jLabel11.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(instObjectButton, org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.instObjectButton.text")); // NOI18N
        instObjectButton.setToolTipText(org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.instObjectButton.toolTipText")); // NOI18N
        instObjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instObjectButtonActionPerformed(evt);
            }
        });

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/mass/qcc/qcccodewizard/Question.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(jLabel33, org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.jLabel33.text")); // NOI18N
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel33MouseClicked(evt);
            }
        });

        params.setText(org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.params.text")); // NOI18N
        params.setToolTipText(org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.params.toolTipText")); // NOI18N

        previewField.setColumns(20);
        previewField.setRows(5);
        jScrollPane1.setViewportView(previewField);

        org.openide.awt.Mnemonics.setLocalizedText(previewButton, org.openide.util.NbBundle.getMessage(NewObjectPopup.class, "NewObjectPopup.previewButton.text")); // NOI18N
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(instObjectButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varName, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(objectName, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(objComment)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(params, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(previewButton)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(objectName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(varName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(objComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(params, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(previewButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(instObjectButton)
                            .addComponent(jLabel33))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void instObjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instObjectButtonActionPerformed

        //This instantiates a new Object into the current document

        //Get the currently open java source
        try {
            JTextComponent jtc = EditorRegistry.lastFocusedComponent();
            CodeDrop codedrop = new CodeDrop();

            String oName = objectName.getSelectedItem().toString();
            String vName = varName.getText();
            //String[] param = params.getText().toString().split(",");

            //Make sure its a valid variable name
            CheckVariableName cvn = new CheckVariableName();
            if (cvn.isGood(oName) && cvn.isGood(oName)) {
                //If name is valid, add it to the editor.
                System.out.println("Valid Object Names");
                
                previewButton.doClick();

                String temp = previewField.getText();
                String code = temp.split("/")[0];
                try {
                    //Insert into document
                    System.out.println("Inserting Code");
                    CodeDrop.insert(code, jtc);
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        } catch (java.lang.Throwable t) {

            JOptionPane.showMessageDialog(this, "All Fields must be filled out.");

        }
        //Call combobox models visit method to update with the new variable.
    }//GEN-LAST:event_instObjectButtonActionPerformed

    private void objectNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_objectNameActionPerformed
        params.setToolTipText(getTooltip(objectName));
    }//GEN-LAST:event_objectNameActionPerformed

    private void jLabel33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseClicked
        //Open Instantiating Help
        OpenHelpUrl o = new OpenHelpUrl("http://docs.oracle.com/javase/tutorial/java/javaOO/objectcreation.html");
    }//GEN-LAST:event_jLabel33MouseClicked

    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed

        repopulate();
    }//GEN-LAST:event_previewButtonActionPerformed

    private void objectNamePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_objectNamePropertyChange
        params.setToolTipText(getTooltip(objectName));
    }//GEN-LAST:event_objectNamePropertyChange
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton instObjectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField objComment;
    private javax.swing.JComboBox objectName;
    private javax.swing.JTextField params;
    private javax.swing.JButton previewButton;
    private javax.swing.JTextArea previewField;
    private javax.swing.JTextField varName;
    // End of variables declaration//GEN-END:variables
}
