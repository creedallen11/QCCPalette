
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package edu.mass.qcc.qcccodewizard;

//~--- non-JDK imports --------------------------------------------------------

import japa.parser.ast.CompilationUnit;

import org.openide.util.Exceptions;

//~--- JDK imports ------------------------------------------------------------

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 * Open and read each line of the current java source file collecting all
 * variables into the foundVariables ArrayList.
 *
 * @author Ian
 */
class VariableNameComboModel extends AbstractListModel implements ComboBoxModel {

    // Open and read each line of the current java source file collecting all variables
    // into the foundVariables ArrayList.
    String[] variableNames = { " " };
    String[] variableTypes = { " " };
    String   selection     = null;

    public VariableNameComboModel() {

        // Find Variables
        GetCompilationUnit fv = new GetCompilationUnit();
        CompilationUnit    cu = null;

        try {
            cu = fv.getCU();
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        GetVariableDeclarations vd = new GetVariableDeclarations();

        vd.visit(cu, null);

        ArrayList variableNamesArray = vd.getMyArray();
        ArrayList variableTypesArray = vd.getMyTypeArray();

        this.variableNames = (String[]) variableNamesArray.toArray(new String[0]);
        this.variableTypes = (String[]) variableTypesArray.toArray(new String[0]);
    }

    public void Refresh() {

        // Find Variables
        GetCompilationUnit fv = new GetCompilationUnit();
        CompilationUnit    cu = null;

        try {
            cu = fv.getCU();
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        GetVariableDeclarations vd = new GetVariableDeclarations();

        vd.visit(cu, null);

        ArrayList variableNamesArray = vd.getMyArray();
        ArrayList variableTypesArray = vd.getMyTypeArray();

        this.variableNames = (String[]) variableNamesArray.toArray(new String[0]);
        this.variableTypes = (String[]) variableTypesArray.toArray(new String[0]);
    }

    @Override
    public Object getElementAt(int index) {
        return variableNames[index];
    }

    @Override
    public int getSize() {
        return variableNames.length;
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
