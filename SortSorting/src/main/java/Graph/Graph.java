package Graph;

import java.util.HashMap;

public class Graph {

    HashMap<String, Node> nodes;

    public Graph(String startNodeName){
        nodes = new HashMap<>();
        addNode(startNodeName);
    }

    public void addNode(String name){
        nodes.put(name, new Node(name));
    }

    public void addEdge(String sourceName, String destinationName, int cost){
        Node source = nodes.get(sourceName);
        Node destination = nodes.get(destinationName);

        source.addEdge(new Edge(destination, cost));
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
