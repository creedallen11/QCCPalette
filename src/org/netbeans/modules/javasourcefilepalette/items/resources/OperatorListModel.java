
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette.items.resources;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Ian
 */
class OperatorListModel extends AbstractListModel implements ComboBoxModel {
    String[] operators = {
        "Assignment", "=", "Arithmetic", "+", "-", "*", "/", "%", "Unary", "+", "-", "++", "--", "!",
        "Equality & Relational", "==", "!=", ">", ">=", "<", "<=", "Conditional", "&&", "||", "?:", "Bitwise and Shift",
        "~", "<<", ">>", ">>>", "&", "^", "|",
    };
    String selection = null;

    @Override
    public Object getElementAt(int index) {
        return operators[index];
    }

    @Override
    public int getSize() {
        return operators.length;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selection = (String) anItem;    // to select and register an
    }    // item from the pull-down list

    // Methods implemented from the interface ComboBoxModel
    @Override
    public Object getSelectedItem() {
        return selection;    // to add the selection to the combo box
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
