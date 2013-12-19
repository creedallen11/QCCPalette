/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.javasourcefilepalette;

/**
 *
 * @author Ian
 */
public class CheckVariableName {

    /**
     * Checks that a variable name is valid
     * @param name
     * @return true or false
     */
    public Boolean isGood(String name) {
        if (name.matches("^[a-zA-Z][a-zA-Z0-9]*?$")) {
            return true;
            
        }
        
        return false;
    }
}
