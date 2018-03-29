package nl.han.ica.icss.checker;

import java.util.ArrayList;
import java.util.HashMap;

import nl.han.ica.icss.ast.*;

public class Checker {

    private HashMap<String, ConstantDefinition> symboltable;
    private ArrayList<ASTNode> visitedNodes;

    public void check(AST ast) {
        //Clear symbol table
        visitedNodes = new ArrayList<>();
        symboltable = new HashMap<>();

        checkRecursive(ast.root);

        checkIfConstantNotUsed(ast.root);

        //Save the symbol table.
        ast.symboltable = symboltable;
        //Save the verdict
        if (ast.getErrors().isEmpty()) {
            ast.checked = true;
        }
    }

    private void checkIfConstantNotUsed(ASTNode node) {
        node.getChildren().forEach(this::checkIfConstantNotUsed);

        if((node instanceof  ConstantReference)){
            long count = visitedNodes.stream().filter(q -> q instanceof ConstantReference && ((ConstantReference) q).name.equals(
                    ((ConstantReference) node).name)).count();
            if(count == 1){
                node.setError("The declaration is not used. See: " + ((ConstantReference) node).name);
            }
        }
    }

    private void checkRecursive(ASTNode node) {
        visitedNodes.add(node);

        node.getChildren().forEach(this::checkRecursive);

        if(!(node instanceof ConstantDefinition))
            return;

        ConstantDefinition def = (ConstantDefinition) node;
        String key = def.name.name;

        if(symboltable.containsKey(key)){
            def.setError("A constant with the same name may not be defined more than once. See: " + key);
        } else{
            symboltable.put(key, def);
        }
    }
}
