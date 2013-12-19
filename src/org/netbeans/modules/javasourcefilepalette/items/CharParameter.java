
/*
 *-----------------------------------------------------------------------------------------
 *---This file was generated using Snip - A Snippets Source Code Generator 
 *---for use with Netbeans Palettes. This project is an expansion of the sample
 *---Java Palette by Geertjan Wielenga.
 *---Quinsigamond Community College - 2013
 *-----------------------------------------------------------------------------------------
 */

package org.netbeans.modules.javasourcefilepalette.items;
import org.netbeans.modules.javasourcefilepalette.items.resources.CharParameterPopup;
import org.openide.text.ActiveEditorDrop;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

/**
 * This class gets and sets comments for the code snippet and calls
 *  the popup or customizer associated with this class.
 */
public class CharParameter implements ActiveEditorDrop {
    private String comment = "";

    /**
     *
     */
    public CharParameter() {}

    private String createBody() {
        comment = getComment();
        StringBuilder buffer = new StringBuilder();
        buffer.append(comment).append("\n");
        return "";
    }

    /**
     *
     * @param targetComponent
     * @return
     */
    public boolean handleTransfer(JTextComponent targetComponent) {
        CharParameterPopup c      = new CharParameterPopup(this, targetComponent);
        boolean         accept = c.showDialog();

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
     * @return Returns a comment.
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
