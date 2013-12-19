/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette;

import edu.mass.qcc.qcccodewizard.*;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Ian
 */
class VariableTypeComboBoxModel extends AbstractListModel implements ComboBoxModel {

    String[] VariableTypes = {"Int", "String", "Char", "Short", "Long", "Float",
        "Double", "Boolean"};
    String selection = null;

    @Override
    public Object getElementAt(int index) {
        return VariableTypes[index];
    }

    @Override
    public int getSize() {
        return VariableTypes.length;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem; // to select and register an
    } // item from the pull-down list

    // Methods implemented from the interface ComboBoxModel
    @Override
    public Object getSelectedItem() {
        return selection; // to add the selection to the combo box
    }
}
