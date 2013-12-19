
/*
*
*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette.items;

//~--- non-JDK imports --------------------------------------------------------

import org.netbeans.modules.javasourcefilepalette.items.resources.CharVarPopup;

import org.openide.text.ActiveEditorDrop;

//~--- JDK imports ------------------------------------------------------------

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

/**
 *
 *
 */
public class CharVar implements ActiveEditorDrop {
    private String comment = "";

    private String createBody() {
        comment = getComment();

        StringBuilder buffer = new StringBuilder();

        buffer.append("// ").append(comment).append("\n");

        return buffer.toString();
    }

    /**
     *
     * @param targetComponent
     * @return
     */
    public boolean handleTransfer(JTextComponent targetComponent) {
        CharVarPopup c      = new CharVarPopup(this, targetComponent);
        boolean      accept = c.showDialog();

        if (accept) {
            String body = this.createBody();

            try {
                javasourcefilepaletteUtilities.insert(body, targetComponent);
            } catch (BadLocationException ble) {
                accept = false;
            }
        }

        return accept;
    }

    /**
     *
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
