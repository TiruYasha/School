package nl.han.ica.icss.generator;

import nl.han.ica.icss.ast.*;
import java.util.ArrayList;

public class Generator {

    StringBuilder builder;

	public String generate(AST ast) {
        //BEGIN STARTCODE

        builder = new StringBuilder();
        generateRecursive(ast.root);
        return builder.toString();
        //EIND STARTCODE
	}

    private void generateRecursive(ASTNode node) {
        for (ASTNode astNode : node.getChildren()) {
            generateRecursive(astNode);
        }

        if(!(node instanceof Stylerule))
            return;

        builder.append(node.toString());
    }
}
