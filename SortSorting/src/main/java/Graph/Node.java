package Graph;

import Lists.Stack.Queues.HANLinkedList;
import javafx.util.Builder;

public class Node {

    private String name;
    private HANLinkedList<Edge> edges;
    private double distance;

    public Node(String name) {
        this.name = name;
        edges = new HANLinkedList<>();
    }

    public HANLinkedList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge newEdge) {
        edges.addFirst(newEdge);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(": ");

        for (Edge edge : edges) {
            builder.append(edge.toString()).append(" - ");
        }

        return builder.toString();
    }
}
