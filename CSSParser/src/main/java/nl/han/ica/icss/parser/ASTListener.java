package nl.han.ica.icss.parser;

import java.util.Stack;

import nl.han.ica.icss.ast.*;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {
	
	//Accumulator attributes:
	private AST ast;
	private Stack<ASTNode> currentContainer; //This is a hint...

	public ASTListener() {
		ast = new AST();
		currentContainer = new Stack<>();

		//ast.root.addChild(new ConstantDefinition());



	}

	//Constantdefinition wordt gegenereerd
	// Maak een enterconstantreference om die knoop value eruit te halen
//	public void EnterConstDefinition(ICSSParser.ConstantDefinition ctx){
//	    ConstantDefinition def = new ConstantDefinition();
//
//	    //def.name = new ConstantReference(ctx.getChild(1).getText());
//	    def.expression = new PixelLiteral("10px");
//
//	    //push de constantdefinition
//	    currentContainer.push(def);
//
//	    //Dan kun je in de constantreference peek voor de value
//
//	    ast.root.addChild(def);
//    }

    public AST getAST() {
        return ast;
    }
}
