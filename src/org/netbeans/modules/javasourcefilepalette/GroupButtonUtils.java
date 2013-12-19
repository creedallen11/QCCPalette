/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette;

import edu.mass.qcc.qcccodewizard.*;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

/**
 *
 * @author Ian
 */
public class GroupButtonUtils {

    /**
     *
     * @param buttonGroup
     * @return
     */
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
