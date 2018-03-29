package Toets.dieren;

import java.util.HashMap;

public class IdentificationKey<T> {

    public IdentificationNode<T> root;
    public IdentificationNode<T> currentNode;

    public IdentificationKey(){
    }

    public void addNode(IdentificationNode<T> node) {
        if (root == null) {
            root = node;
        }
    }

    public String getQuestion(){
        return currentNode.question;
    }

    public void start() {
        currentNode = root;
    }

    public void navigate(boolean answer){
        if(answer){
            currentNode = currentNode.getRight();
        }else{
            currentNode = currentNode.getLeft();
        }
    }

    public boolean found(){
        return currentNode.value != null;
    }

    public T getSpecies(){
        return currentNode.value;
    }

    public void extend(String question, T species){
        IdentificationNode<T> oldNode = new IdentificationNode<>(currentNode.value);
        oldNode.left = currentNode.left;
        oldNode.right = currentNode.right;

        currentNode.value = null;
        currentNode.question = question;
        currentNode.left = oldNode;
        currentNode.right = new IdentificationNode<>(species);
    }

//    private IdentificationNode<T> findNode(T species, IdentificationNode<T> current) {
//        IdentificationNode<T> node;
//
//        if(current.value.compareTo(species) == 0)
//        {
//            return current;
//        }
//
//        node = findNode(species, current.left);
//        if(node != null && node.value.compareTo(species) == 0){
//            return node;
//        }
//
//        node = findNode(species, current.right);
//
//        if(node != null && node.value.compareTo(species) == 0) {
//            return node;
//        }
//        return null;
//    }
}
