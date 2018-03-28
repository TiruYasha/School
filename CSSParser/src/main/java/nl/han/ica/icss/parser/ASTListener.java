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


    @Override
    public void enterSelectorStyle(ICSSParser.SelectorStyleContext ctx) {
        Stylerule rule = new Stylerule();

        currentContainer.push(rule);
    }

    @Override
    public void exitSelectorStyle(ICSSParser.SelectorStyleContext ctx) {
        ASTNode rule = currentContainer.pop();

        ast.root.addChild(rule);
    }

    @Override
    public void enterTagSelector(ICSSParser.TagSelectorContext ctx) {
        TagSelector selector = new TagSelector(ctx.getText());
        currentContainer.peek().addChild(selector);
    }

    @Override
    public void enterClassSelector(ICSSParser.ClassSelectorContext ctx) {
        ClassSelector selector = new ClassSelector(ctx.getText());
        currentContainer.peek().addChild(selector);
    }

    @Override
    public void enterIdSelector(ICSSParser.IdSelectorContext ctx) {
        IdSelector selector = new IdSelector(ctx.getText());
        currentContainer.peek().addChild(selector);
    }

    @Override
    public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
        Declaration declaration = new Declaration();
        currentContainer.push(declaration);
    }

    @Override
    public void exitDeclaration(ICSSParser.DeclarationContext ctx) {
        ASTNode declaration = currentContainer.pop();

        currentContainer.peek().addChild(declaration);
    }

    @Override
    public void enterDeclarationProperty(ICSSParser.DeclarationPropertyContext ctx){
        Declaration declaration = (Declaration) currentContainer.peek();
        declaration.property = ctx.getText();
    }

    @Override
    public void enterPixelLiteral(ICSSParser.PixelLiteralContext ctx){
        Declaration declaration = (Declaration) currentContainer.peek();
        declaration.expression = new PixelLiteral(ctx.getText());
    }

    @Override
    public void enterPercentageLiteral(ICSSParser.PercentageLiteralContext ctx){
        Declaration declaration = (Declaration) currentContainer.peek();
        declaration.expression = new PercentageLiteral(ctx.getText());
    }

    @Override
    public void enterColorLiteral(ICSSParser.ColorLiteralContext ctx){
        Declaration declaration = (Declaration) currentContainer.peek();
        declaration.expression = new ColorLiteral(ctx.getText());
    }

    public AST getAST() {
        return ast;
    }
}
