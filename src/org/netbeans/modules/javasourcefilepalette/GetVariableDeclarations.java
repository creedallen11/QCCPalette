/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette;

import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.type.Type;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ian
 */
public class GetVariableDeclarations extends VoidVisitorAdapter {

    ArrayList myArray = new ArrayList();

    /**
     *
     * @param n
     * @param arg
     */
    @Override
    public void visit(VariableDeclarationExpr n, Object arg) {
        //List all variables
        List<VariableDeclarator> myVars = n.getVars();
        Type myType = n.getType();
        for (VariableDeclarator vars : myVars) {

            System.out.println("Variable: " + myType + " : " + vars.getId().toString());
            //myArray.add(myType.toString());
            myArray.add(vars.getId().toString());

        }
    }

    /**
     * @return the myArray
     */
    public ArrayList getMyArray() {
        return myArray;
    }

    /**
     * @param myArray the myArray to set
     */
    public void setMyArray(ArrayList myArray) {
        this.myArray = myArray;
    }
}
// extract method information here.
// put in to hashmap

