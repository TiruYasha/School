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
    }

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

        ASTNode node = currentContainer.peek();

        node.addChild(selector);
    }

    @Override
    public void enterClassSelector(ICSSParser.ClassSelectorContext ctx) {
        ClassSelector selector = new ClassSelector(ctx.getText());
        ASTNode node = currentContainer.peek();

        node.addChild(selector);
    }

    @Override
    public void enterIdSelector(ICSSParser.IdSelectorContext ctx) {
        IdSelector selector = new IdSelector(ctx.getText());
        ASTNode node = currentContainer.peek();

        node.addChild(selector);
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
    public void enterDeclarationProperty(ICSSParser.DeclarationPropertyContext ctx) {
        Declaration declaration = (Declaration) currentContainer.peek();
        declaration.property = ctx.getText();
    }

    @Override
    public void enterPixelLiteral(ICSSParser.PixelLiteralContext ctx) {
        ASTNode node = currentContainer.peek();

        if (node == null) {
            currentContainer.pop();
            currentContainer.push(new PixelLiteral(ctx.getText()));
        }
        else {
            node.addChild(new PixelLiteral(ctx.getText()));
        }
    }

    @Override
    public void enterPercentageLiteral(ICSSParser.PercentageLiteralContext ctx) {
        ASTNode node = currentContainer.peek();

        if (node == null) {
            currentContainer.pop();
            currentContainer.push(new PercentageLiteral(ctx.getText()));
        }
        else {
            node.addChild(new PercentageLiteral(ctx.getText()));
        }
    }

    @Override
    public void enterColorLiteral(ICSSParser.ColorLiteralContext ctx) {
        ASTNode node = currentContainer.peek();

        if (node == null) {
            currentContainer.pop();
            currentContainer.push(new ColorLiteral(ctx.getText()));
        }
        else {
            node.addChild(new ColorLiteral(ctx.getText()));
        }
    }

    @Override
    public void enterScalarLiteral(ICSSParser.ScalarLiteralContext ctx) {
        ASTNode node = currentContainer.peek();

        if (node == null) {
            currentContainer.pop();
            currentContainer.push(new ScalarLiteral(ctx.getText()));
        }
        else {

            node.addChild(new ScalarLiteral((ctx.getText())));
        }
    }

    @Override
    public void enterConstantDefinition(ICSSParser.ConstantDefinitionContext ctx) {
        ConstantDefinition def = new ConstantDefinition();
        currentContainer.push(def);
    }

    @Override
    public void exitConstantDefinition(ICSSParser.ConstantDefinitionContext ctx) {
        ast.root.addChild(currentContainer.pop());
    }

    @Override
    public void enterConstantReference(ICSSParser.ConstantReferenceContext ctx) {
        ASTNode node = currentContainer.peek();

        node.addChild(new ConstantReference(ctx.getText()));
    }

    @Override
    public void enterConstantDefinitionExpression(ICSSParser.ConstantDefinitionExpressionContext ctx) {
        ASTNode node = currentContainer.peek();

        if (node == null) {
            currentContainer.pop();
            currentContainer.push(new ConstantReference(ctx.getText()));
        }
        else {
            node.addChild(new ConstantReference(ctx.getText()));
        }
    }

    @Override
    public void enterSom(ICSSParser.SomContext ctx) {
        //Push a null so that the first literal knows it is a som.
        currentContainer.push(null);
    }

    @Override
    public void exitSom(ICSSParser.SomContext ctx) {
        Operation operation = (Operation) currentContainer.pop();
        ASTNode node = currentContainer.peek();

        node.addChild(operation);
    }

    @Override
    public void enterAddOperator(ICSSParser.AddOperatorContext ctx) {
        Expression node = (Expression) currentContainer.pop();

        Operation add = new AddOperation();
        add.lhs = node;

        currentContainer.push(add);
    }

    @Override
    public void enterSubstractOperator(ICSSParser.SubstractOperatorContext ctx) {
        Expression node = (Expression) currentContainer.pop();

        Operation add = new SubtractOperation();
        add.lhs = node;

        currentContainer.push(add);
    }

    @Override
    public void enterMultiplyOperator(ICSSParser.MultiplyOperatorContext ctx) {
        Expression node = (Expression) currentContainer.pop();

        Operation add = new MultiplyOperation();
        add.lhs = node;

        currentContainer.push(add);
    }

    @Override
    public void enterSwitchrule(ICSSParser.SwitchruleContext ctx) {
        currentContainer.push(new Switchrule());
    }

    @Override
    public void exitSwitchrule(ICSSParser.SwitchruleContext ctx) {
        ast.root.addChild(currentContainer.pop());
    }

    @Override
    public void enterCaserule(ICSSParser.CaseruleContext ctx) {
        currentContainer.push(new SwitchValueCase());
    }

    @Override
    public void exitCaserule(ICSSParser.CaseruleContext ctx) {
        ASTNode value = currentContainer.pop();
        ASTNode node = currentContainer.peek();

        node.addChild(value);
    }

    @Override
    public void enterDefaultcase(ICSSParser.DefaultcaseContext ctx) {
        currentContainer.push(new SwitchDefaultCase());
    }

    @Override
    public void exitDefaultcase(ICSSParser.DefaultcaseContext ctx) {
        ASTNode value = currentContainer.pop();
        ASTNode node = currentContainer.peek();

        node.addChild(value);
    }

    public AST getAST() {
        return ast;
    }
}
