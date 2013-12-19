
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package edu.mass.qcc.qcccodewizard;

/**
 * Checks that a variable name is proper java syntax
 * @author Ian
 */
public class CheckVariableName {
    public Boolean isGood(String name) {
        if (name.matches("^[a-zA-Z][a-zA-Z0-9]*?$")) {
            return true;
        }

        return false;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
