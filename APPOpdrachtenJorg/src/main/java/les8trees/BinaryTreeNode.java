package les8trees;

import java.util.Collections;

public class BinaryTreeNode<AnyType> {

    public static final String DEPTH_INDENT = "    ";
    public AnyType value;

    public BinaryTreeNode<AnyType> left;
    public BinaryTreeNode<AnyType> right;

    public BinaryTreeNode(AnyType value) {
        this.value = value;
    }

    public BinaryTreeNode(AnyType value, BinaryTreeNode<AnyType> left, BinaryTreeNode<AnyType> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int calculateTotalLeaves() {
        int value = 0;
        boolean isLeave = true;
        if (left != null) {
            value += left.calculateTotalLeaves();
            isLeave = false;
        }
        if (right != null) {
            value += right.calculateTotalLeaves();
            isLeave = false;
        }
        if (isLeave) {
            value++;
        }
        return value;
    }

    public int calculateOneNonNullChild() {
        int value = 0;
        boolean hasOneNonNullChild = false;
        if (left != null) {
            value += left.calculateOneNonNullChild();
            hasOneNonNullChild = !hasOneNonNullChild;
        }
        if (right != null) {
            value += right.calculateOneNonNullChild();
            hasOneNonNullChild = !hasOneNonNullChild;
        }
        if (hasOneNonNullChild) {
            value++;
        }
        return value;
    }

    public int calculateTwoNonNullChildren() {
        int value = 0;
        if (left != null) {
            value += left.calculateTwoNonNullChildren();
        }
        if (right != null) {
            value += right.calculateTwoNonNullChildren();
        }
        if (left != null && right != null) {
            value++;
        }
        return value;
    }

    private String getIndentation(int depth) {
        return String.join("", Collections.nCopies(depth, DEPTH_INDENT));
    }

    public int size() {
        int value = 1;
        if (left != null) {
            value += left.size();
        }
        if (right != null) {
            value += right.size();
        }
        return value;
    }

    public String getPreOrder(int depth) {
        String value = "";
        value += getIndentation(depth) + this.value.toString() + "\n";
        if (left != null) {
            value += left.getPreOrder(depth + 1);
        }
        if (right != null) {
            value += right.getPreOrder(depth + 1);
        }
        return value;
    }

    public String getPostOrder(int depth) {
        String value = "";
        if (left != null) {
            value += left.getPostOrder(depth + 1);
        }
        if (right != null) {
            value += right.getPostOrder(depth + 1);
        }
        value += getIndentation(depth) + this.value.toString() + "\n";
        return value;
    }

    public String getInOrder(int depth) {
        String value = "";
        if (left != null) {
            value += left.getInOrder(depth + 1);
        }
        value += getIndentation(depth) + this.value.toString() + "\n";
        if (right != null) {
            value += right.getInOrder(depth + 1);
        }
        return value;
    }

    @Override
    public String toString() {
        return getInOrder(0);
    }

    public void mirror() {
        if (left != null) {
            left.mirror();
        }
        if (right != null) {
            right.mirror();
        }
        BinaryTreeNode tmp = left;
        left = right;
        right = tmp;
    }

    public int substract(int depth) {
        int number = 0;
        if (depth % 2 == 0) {
            number = (Integer) value;
        } else {
            number -= (Integer) value;
        }
        if (left != null) {
            if (depth % 2 == 1) {
                number -= left.substract(depth + 1);
            } else {
                number += left.substract(depth + 1);
            }
        }
        if (right != null) {
            if (depth % 2 == 1) {
                number -= right.substract(depth + 1);
            } else {
                number += right.substract(depth + 1);
            }
        }
        return number;
    }
}
