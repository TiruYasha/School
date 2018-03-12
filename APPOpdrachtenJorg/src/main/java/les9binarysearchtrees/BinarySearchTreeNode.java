package les9binarysearchtrees;

import java.util.Collections;

public class BinarySearchTreeNode {

    public static final String DEPTH_INDENT = "    ";

    public int value;

    public BinarySearchTreeNode left;
    public BinarySearchTreeNode right;


    public BinarySearchTreeNode() {
        this.value = 0;
        left = null;
        right = null;
    }

    public BinarySearchTreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    private String getIndentation(int depth) {
        return String.join("", Collections.nCopies(depth, DEPTH_INDENT));
    }

    public String toString(int depth) {
        String string = "";
        if(left != null) {
            string += left.toString(depth + 1);
        }
        string += getIndentation(depth) + Integer.toString(this.value)  + "\n";
        if(right != null) {
            string += right.toString(depth + 1);
        }
        return string;
    }
}
