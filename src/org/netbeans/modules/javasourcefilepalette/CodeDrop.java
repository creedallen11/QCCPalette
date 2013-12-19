/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette;

import edu.mass.qcc.qcccodewizard.*;
import java.awt.AWTException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;
import org.openide.text.IndentEngine;
import org.openide.text.NbDocument;
import org.openide.util.Exceptions;

/**
 *
 * @author Ian
 */
public class CodeDrop {

    /**
     *
     * @param s
     * @param target
     * @throws BadLocationException
     */
    public static void insert(final String s, final JTextComponent target) throws BadLocationException {

        final StyledDocument doc = (StyledDocument) target.getDocument();
        if (doc == null) {
            return;
        }

        class InsertFormatedText implements Runnable {

            @Override
            public void run() {
                try {
                    try {
                        insertFormated(s, target, doc);
                    } catch (AWTException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);

                }
            }
        }
        InsertFormatedText insert = new InsertFormatedText();

        //This starts the run() in the Runnable above:
        NbDocument.runAtomicAsUser(doc, insert);

    }

    private static int insertFormated(String s, JTextComponent target, Document doc) throws BadLocationException, AWTException {

        int start = -1;

        try {

            //Find the location in the editor,
            //and if it is a selection, remove it,
            //to be replaced by the dropped item:
            Caret caret = target.getCaret();
            int p0 = Math.min(caret.getDot(), caret.getMark());
            int p1 = Math.max(caret.getDot(), caret.getMark());
            doc.remove(p0, p1 - p0);
            start = caret.getDot();


            IndentEngine engine = IndentEngine.find(doc);
            StringWriter textWriter = new StringWriter();
            Writer indentWriter = engine.createWriter(doc, start, textWriter);
            try {
                indentWriter.write(s);
                indentWriter.close();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }

            doc.insertString(start, textWriter.toString(), null);

            //} catch (IOException ex) {
            //  Exceptions.printStackTrace(ex);
        } catch (BadLocationException ble) {
            Exceptions.printStackTrace(ble);
        }

        return start;
    }
}
