package les9binarysearchtrees;

import les3sorting.ISortAlgorithm;
import les3sorting.QuickSort;

import java.util.Arrays;

public class BinarySearchTree {

    public static final int ROOT_DEPTH = 0;

    public BinarySearchTreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    public void remove(int value) {
        root = remove(value, root);
    }

    public int find(int value) {
        return valueAt(find(value, root));
    }

    public int findMin() {
        return valueAt(findMin(root));
    }

    public int findMax() {
        return valueAt(findMax(root));
    }

    public void removeMin() {
        root = removeMin(root);
    }

    private BinarySearchTreeNode removeMin(BinarySearchTreeNode node) {
        if (node == null) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (node.left != null) {
            node.left = removeMin(node.left);
            return node;
        }
        return node.right;
    }

    //moet nog recursive
    private BinarySearchTreeNode find(int value, BinarySearchTreeNode node) {
        while (node != null) {
            if (value < node.value) {
                node = node.left;
            } else if (value > node.value) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    private BinarySearchTreeNode findMin(BinarySearchTreeNode node) {
        if (node.left != null) {
            return findMin(node.left);
        }
        return node;
    }

    private BinarySearchTreeNode findMax(BinarySearchTreeNode node) {
        if (node.right != null) {
            return findMax(node.right);
        }
        return node;
    }

    private int valueAt(BinarySearchTreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.value;
        }
    }

    private BinarySearchTreeNode insert(int value, BinarySearchTreeNode node) {
        if (node == null) {
            node = new BinarySearchTreeNode(value);
        } else if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return node;
    }

    private BinarySearchTreeNode remove(int value, BinarySearchTreeNode node) {
        if (node == null) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (value < node.value) {
            node.left = remove(value, node.left);
        } else if (value < node.value) {
            node.right = remove(value, node.right);
        } else if (node.left != null && node.right != null) {
            node.value = findMin(node.right).value;
            node.right = removeMin(node.right);
        } else {
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public static BinarySearchTree fromArray(int[] input) {
        ISortAlgorithm<Integer> insertionSort = new QuickSort<>();
        input = Arrays.stream(insertionSort.sort(Arrays.stream(input).boxed().toArray(Integer[]::new))).mapToInt(Integer::intValue).toArray();
        return fromSortedArray(input);
    }

    public static BinarySearchTree fromSortedArray(int[] input) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        fromSortedArray(input, binarySearchTree);
        return binarySearchTree;
    }

    private static void fromSortedArray(int[] input, BinarySearchTree binarySearchTree) {
        if (input.length > 0) {
            binarySearchTree.insert(input[input.length / 2]);
            fromSortedArray(Arrays.copyOfRange(input, 0, input.length / 2), binarySearchTree);
            fromSortedArray(Arrays.copyOfRange(input, input.length / 2 + 1, input.length), binarySearchTree);
        }
    }

    @Override
    public String toString() {
        return root.toString(ROOT_DEPTH);
    }
}
