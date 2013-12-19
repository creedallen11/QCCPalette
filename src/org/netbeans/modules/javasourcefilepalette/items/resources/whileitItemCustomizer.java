package org.netbeans.modules.javasourcefilepalette.items.resources;

//~--- non-JDK imports --------------------------------------------------------

import org.netbeans.modules.javasourcefilepalette.items.whileit;

import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.util.NbBundle;

//~--- JDK imports ------------------------------------------------------------

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.JTextComponent;

/**
 *
 * @author Ian
 */
public class whileitItemCustomizer extends javax.swing.JPanel {
    private Dialog           dialog     = null;
    private DialogDescriptor descriptor = null;
    private boolean          dialogOK   = false;
    whileit                  ifitem;
    JTextComponent           target;

    // Variables declaration - do not modify
    private javax.swing.JLabel     jLabel1;
    private javax.swing.JTextField jTextField1;

    /**
     * Creates new form ItemCustomizer
     * @param item
     * @param target
     */
    public whileitItemCustomizer(whileit item, JTextComponent target) {
        this.ifitem = item;
        this.target = target;
        initComponents();
    }

    /**
     *
     * @return
     */
    public boolean showDialog() {
        dialogOK = false;

        String displayName = "";

        try {
            displayName = NbBundle.getBundle(
                "org.netbeans.modules.javasourcefilepalette.items.resources.Bundle").getString("NAME_html-whileit");
        } catch (Exception e) {}

        descriptor = new DialogDescriptor(this,
                                          NbBundle.getMessage(whileitItemCustomizer.class,
                                              "LBL_Customizer_InsertPrefix") + " " + displayName, true,
                                                  DialogDescriptor.OK_CANCEL_OPTION, DialogDescriptor.OK_OPTION,
                                                      new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (descriptor.getValue().equals(DialogDescriptor.OK_OPTION)) {
                    evaluateInput();
                    dialogOK = true;
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

    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">
    private void initComponents() {
        jLabel1     = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1.setText(org.openide.util.NbBundle.getMessage(ItemCustomizer.class, "ItemCustomizer.jLabel1.text"));    // NOI18N
        jTextField1.setText(org.openide.util.NbBundle.getMessage(ItemCustomizer.class,
                "ItemCustomizer.jTextField1.text"));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);

        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
                layout.createSequentialGroup().addContainerGap().add(jLabel1).addPreferredGap(
                    org.jdesktop.layout.LayoutStyle.RELATED).add(
                    jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 220,
                    Short.MAX_VALUE).addContainerGap()));
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(
                layout.createSequentialGroup().addContainerGap().add(
                    layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel1).add(
                        jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)).addContainerGap(
                            org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }    // </editor-fold>

    // End of variables declaration
}


//~ Formatted by Jindent --- http://www.jindent.com
