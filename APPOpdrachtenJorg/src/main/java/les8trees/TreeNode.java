package les8trees;

import java.util.Collections;

public class TreeNode<AnyType> {

    public static final String DEPTH_INDENT = "    ";
    public AnyType value;

    public TreeNode<AnyType> child;
    public TreeNode<AnyType> sibling;

    public TreeNode(AnyType value) {
        this.value = value;
    }

    public TreeNode(AnyType value, TreeNode<AnyType> child, TreeNode<AnyType> sibling) {
        this.value = value;
        this.child = child;
        this.sibling = sibling;
    }

    private String getIndentation(int depth) {
        return String.join("", Collections.nCopies(depth, DEPTH_INDENT));
    }

    @Override
    public String toString() {
        return toString(0);
    }

    public String toString(int depth) {
        String value = "";
        value += getIndentation(depth) + this.value.toString() + "\n";
        if(child != null) {
            value += child.toString(depth + 1);
        }
        if(sibling != null) {
            value += sibling.toString(depth);
        }
        return value;
    }
}
