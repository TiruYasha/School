package Graph;

import Lists.Stack.Queues.Queue;

import java.util.HashMap;

public class Graph {
    public static final double INFINITY = Double.MAX_VALUE;
    HashMap<String, Node> nodes;

    public Graph(String startNodeName) {
        nodes = new HashMap<>();
        addNode(startNodeName);
    }

    public void addNode(String name) {
        nodes.put(name, new Node(name));
    }

    public void addEdge(String sourceName, String destinationName, int cost) {
        Node source = nodes.get(sourceName);
        Node destination = nodes.get(destinationName);

        source.addEdge(new Edge(destination, cost));
    }

    public void unweighted(String startName) {
        Node start = nodes.get(startName);

        Queue<Node> queue = new Queue<>();
        queue.enqueue(start);
        start.setDistance(0);

        while (!queue.isEmpty()) {
            Node node = queue.dequeue();

            for (Edge edge : node.getEdges()) {
                Node edgeNode = edge.getDestination();

                if(edgeNode.getDistance() == INFINITY){
                    edgeNode.setDistance(node.getDistance() + 1);
                    queue.enqueue(edgeNode);
                }
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (String key :
                nodes.keySet()) {
            builder.append(nodes.get(key).toString()).append(" \n");
        }

        return builder.toString();
    }
}
