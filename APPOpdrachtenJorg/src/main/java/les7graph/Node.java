package les7graph;

import les5listsstacksqueues.LinkedList;

public class Node {

    public String name;
    public LinkedList<Edge> adj;
    public double dist;
    public Node prev;
    public int scratch;

    public Node(String name) {
        this.name = name;
        adj = new LinkedList<>();
        reset();
    }

    public void reset() {
        dist = Graph.INFINITY;
        prev = null;
        prev = null;
        scratch = 0;
    }

}
