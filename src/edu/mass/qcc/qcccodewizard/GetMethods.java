
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
 */
package edu.mass.qcc.qcccodewizard;

//~--- non-JDK imports --------------------------------------------------------

import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

//~--- JDK imports ------------------------------------------------------------

import java.util.List;

/**
 *
 * @author Ian
 */
public class GetMethods extends VoidVisitorAdapter {
    @Override
    public void visit(CompilationUnit n, Object arg) {

        // List of all methods
        System.out.println("Methods: " + this.toString());

        List<TypeDeclaration> types = n.getTypes();

        for (TypeDeclaration type : types) {
            List<BodyDeclaration> members = type.getMembers();

            for (BodyDeclaration member : members) {
                if (member instanceof MethodDeclaration) {
                    MethodDeclaration method = (MethodDeclaration) member;

                    System.out.println("Methods: " + method.getName());
                }
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
