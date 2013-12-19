
/*
* javasourcefilepaletteUtilities.java

* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette.items;

//~--- non-JDK imports --------------------------------------------------------

import org.netbeans.modules.javasourcefilepalette.KeyBoard;

import org.openide.text.IndentEngine;
import org.openide.text.NbDocument;
import org.openide.util.Exceptions;

//~--- JDK imports ------------------------------------------------------------

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyledDocument;

/**
 * Handles dropping code into the document.
 *
 * @author Ian
 */
public class javasourcefilepaletteUtilities {
    static Robot tabBot;
    KeyBoard     kb;

    {}

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

        /**
         * Runnable of insertFormatted()
         *
         * @see insertFormatted()
         */
        class InsertFormatedText implements Runnable {
            @Override
            public void run() {
                try {
                    try {
                        try {
                            insertFormated(s, target, doc);
                        } catch (IOException ex) {
                            Exceptions.printStackTrace(ex);
                        }
                    } catch (AWTException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }

        InsertFormatedText insert = new InsertFormatedText();

        // This starts the run() in the Runnable above:
        NbDocument.runAtomicAsUser(doc, insert);
    }

    /**
     *
     * @param s
     * @param target
     * @param isMacro
     * @throws BadLocationException
     */
    public static void insertm(final String s, final JTextComponent target, boolean isMacro)
            throws BadLocationException {
        final StyledDocument doc = (StyledDocument) target.getDocument();

        if (doc == null) {
            return;
        }

        class InsertFormatedMacro implements Runnable {
            @Override
            public void run() {
                try {
                    try {
                        try {
                            insertFormatedm(s, target, doc, true);
                        } catch (IOException ex) {
                            Exceptions.printStackTrace(ex);
                        }
                    } catch (AWTException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                } catch (BadLocationException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        }

        InsertFormatedMacro insertm = new InsertFormatedMacro();

        // This starts the run() in the Runnable above:
        NbDocument.runAtomicAsUser(doc, insertm);
    }

    /**
     * Inserts code into the palette when the code is a macro abbreviation.
     *
     * @param s
     * @param target
     * @param doc
     * @param isMacro
     * @return int
     * @throws BadLocationException
     * @throws AWTException
     * @throws IOException
     */
    private static int insertFormatedm(String s, JTextComponent target, Document doc, boolean isMacro)
            throws BadLocationException, AWTException, IOException {
        int   start = 1;
        Caret caret = target.getCaret();
        int   p0    = Math.min(caret.getDot(), caret.getMark());
        int   p1    = Math.max(caret.getDot(), caret.getMark());

        doc.remove(p0, p1 - p0);
        start = caret.getDot();

        /*
         * //Insert the string in the document,
         * //using the indentation engine
         * //to create the correct indentation:
         * IndentEngine engine = IndentEngine.find(doc);
         * StringWriter textWriter = new StringWriter();
         * Writer indentWriter = engine.createWriter(doc, start, textWriter);
         *
         * indentWriter.write(s);
         * indentWriter.close();
         * doc.insertString(start, textWriter.toString() + '\t', null);
         */

        Robot    tabbot = new Robot();
        KeyBoard kb     = new KeyBoard(tabbot);

        kb.type(s);
        kb.doType(KeyEvent.VK_TAB);

        return start;
    }

    /**
     * Drops the code into the document if its NOT a macro.
     *
     * @param s
     * @param target
     * @param doc
     * @return int
     * @throws BadLocationException
     * @throws AWTException
     * @throws IOException
     */
    private static int insertFormated(String s, JTextComponent target, Document doc)
            throws BadLocationException, AWTException, IOException {
        int start = -1;

        try {

            // Find the location in the editor,
            // and if it is a selection, remove it,
            // to be replaced by the dropped item:
            Caret caret = target.getCaret();
            int   p0    = Math.min(caret.getDot(), caret.getMark());
            int   p1    = Math.max(caret.getDot(), caret.getMark());

            doc.remove(p0, p1 - p0);
            start = caret.getDot();

            // Insert the string in the document,
            // using the indentation engine
            // to create the correct indentation:
            IndentEngine engine       = IndentEngine.find(doc);
            StringWriter textWriter   = new StringWriter();
            Writer       indentWriter = engine.createWriter(doc, start, textWriter);

            indentWriter.write(s);
            indentWriter.close();
            doc.insertString(start, textWriter.toString(), null);

            // Fix Imports and Save Document.
            Robot    tabbot = new Robot();
            KeyBoard kb     = new KeyBoard(tabbot);

            // Fix Imports using Fast Import.
            kb.doType(KeyEvent.VK_CONTROL, KeyEvent.VK_SHIFT, KeyEvent.VK_I);

            // Save
            kb.doType(KeyEvent.VK_CONTROL, KeyEvent.VK_S);

            // } catch (IOException ex) {
            // Exceptions.printStackTrace(ex);
        } catch (BadLocationException ble) {
            Exceptions.printStackTrace(ble);
        }

        return start;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
