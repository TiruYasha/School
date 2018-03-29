package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;

import java.util.HashMap;

public class EvalExpressions implements Transform {

    private HashMap<String,ConstantDefinition> symboltable; //Another hint...

    @Override
    public void apply(AST ast) {
        symboltable = ast.symboltable;

        transform(ast.root);
    }

    private void transform(ASTNode node) {

        node.getChildren().forEach(this::transform);

        if(!(node instanceof Declaration))
            return;

        Declaration declaration = (Declaration) node;

        if(!(declaration.expression instanceof ConstantReference))
            return;

        ConstantReference expression =  (ConstantReference) declaration.expression;

        if(symboltable.containsKey( expression.name)){
            ConstantDefinition def = symboltable.get(expression.name);

            declaration.expression = def.expression;
        }
    }
}
