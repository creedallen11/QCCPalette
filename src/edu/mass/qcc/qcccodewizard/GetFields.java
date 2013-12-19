
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package edu.mass.qcc.qcccodewizard;

//~--- non-JDK imports --------------------------------------------------------

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.visitor.VoidVisitorAdapter;

//~--- JDK imports ------------------------------------------------------------

import java.util.List;

/**
 *
 * @author Ian
 */
public class GetFields extends VoidVisitorAdapter {

    // List all field variables.
    @Override
    public void visit(CompilationUnit n, Object arg) {
        System.out.println("Field Variables: " + this.toString());

        List<TypeDeclaration> f_vars = n.getTypes();

        for (TypeDeclaration type : f_vars) {
            List<BodyDeclaration> members = type.getMembers();

            for (BodyDeclaration member : members) {
                if (member instanceof FieldDeclaration) {
                    FieldDeclaration         myType   = (FieldDeclaration) member;
                    List<VariableDeclarator> myFields = myType.getVariables();

                    System.out.println("Fields: " + myType.getType() + ":" + myFields.toString());
                }
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
