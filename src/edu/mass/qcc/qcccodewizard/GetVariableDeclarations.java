
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package edu.mass.qcc.qcccodewizard;

//~--- non-JDK imports --------------------------------------------------------

import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.type.Type;
import japa.parser.ast.visitor.VoidVisitorAdapter;

//~--- JDK imports ------------------------------------------------------------

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian
 */
public class GetVariableDeclarations extends VoidVisitorAdapter {
    ArrayList myNameArray = new ArrayList();
    ArrayList myTypeArray = new ArrayList();

    @Override
    public void visit(VariableDeclarationExpr n, Object arg) {

        // List all variables
        List<VariableDeclarator> myVars = n.getVars();
        Type                     myType = n.getType();

        for (VariableDeclarator vars : myVars) {
            System.out.println("Variable: " + myType + " : " + vars.getId().getName());
            myTypeArray.add(myType.toString());
            myNameArray.add(vars.getId().toString());
        }
    }

    /**
     * @return the myNameArray
     */
    public ArrayList getMyArray() {
        return myNameArray;
    }

    /**
     * @param myNameArray the myNameArray to set
     */
    public void setMyArray(ArrayList myArray) {
        this.myNameArray = myArray;
    }

    /**
     * @return the myTypeArray
     */
    public ArrayList getMyTypeArray() {
        return myTypeArray;
    }

    /**
     * @param myTypeArray the myTypeArray to set
     */
    public void setMyTypeArray(ArrayList myTypeArray) {
        this.myTypeArray = myTypeArray;
    }
}

//extract method information here.
//put in to hashmap


//~ Formatted by Jindent --- http://www.jindent.com
