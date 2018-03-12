package les7graph;

import les5listsstacksqueues.Queue;
import proeftoets.GraphMatrix;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {

    public static final double INFINITY = Double.MAX_VALUE;

    private Map<String, Node> nodeMap = new HashMap<String, Node>();

    public void addEdge(String sourceName, String destName, double cost) {
        Node node = getNode(sourceName);
        Node nodeDest = getNode(destName);
        node.adj.addFirst(new Edge(nodeDest, cost));
    }

    public void printPath(String destName) {
        Node node = nodeMap.get(destName);
        if (node == null)
            throw new NoSuchElementException();
        else if (node.dist == INFINITY)
            System.out.println(destName + " is unreachable");
        else {
            System.out.print("(Cost is: " + node.dist + ") ");
            printPath(node);
            System.out.println();
        }
    }

    public void unweighted(String startName) {
        clearAll();

        Node start = nodeMap.get(startName);
        if (start == null)
            throw new NoSuchElementException("Start node not found");

        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(start);
        start.dist = 0;

        while (!queue.isEmpty()) {
            Node node = queue.dequeue();

            for (Edge edge : node.adj) {
                Node edgeNode = edge.dest;

                if (edgeNode.dist == INFINITY) {
                    edgeNode.dist = node.dist + 1;
                    edgeNode.prev = node;
                    queue.enqueue(edgeNode);
                }
            }
        }
    }

    public void dijkstra(String startName) throws Exception {
        PriorityQueue<Path> pQueue = new PriorityQueue<Path>();

        Node start = nodeMap.get(startName);
        if (start == null)
            throw new NoSuchElementException("Start node not found");

        clearAll();
        pQueue.add(new Path(start, 0));
        start.dist = 0;

        int nodesSeen = 0;
        while (!pQueue.isEmpty() && nodesSeen < nodeMap.size()) {
            Path vrec = pQueue.remove();
            Node node = vrec.dest;
            if (node.scratch != 0) // already processed node
                continue;

            node.scratch = 1;
            nodesSeen++;

            for (Edge edge : node.adj) {
                Node edgeNode = edge.dest;
                double edgeCost = edge.cost;

                if (edgeCost < 0) {
                    throw new Exception("Graph has negative edges");
                }
                if (edgeNode.dist > node.dist + edgeCost) {
                    edgeNode.dist = node.dist + edgeCost;
                    edgeNode.prev = node;
                    pQueue.add(new Path(edgeNode, edgeNode.dist));
                }
            }
        }
    }

    private Node getNode(String nodeName) {
        Node node = nodeMap.get(nodeName);
        if (node == null) {
            node = new Node(nodeName);
            nodeMap.put(nodeName, node);
        }
        return node;
    }

    private void printPath(Node dest) {
        if (dest.prev != null) {
            printPath(dest.prev);
            System.out.print(" to ");
        }
        System.out.print(dest.name);
    }

    private void clearAll() {
        for (Node node : nodeMap.values()) {
            node.reset();
        }
    }

    public boolean isConnected() {
        for(String key : nodeMap.keySet()) {
            try {
                dijkstra(key);
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (Node node : nodeMap.values()) {
                if(node.scratch != 1) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        try {
            FileReader fin = new FileReader(args[0]);
            Scanner graphFile = new Scanner(fin);
            // Read the edges and insert
            String line;
            while (graphFile.hasNextLine()) {
                line = graphFile.nextLine();
                StringTokenizer st = new StringTokenizer(line);
                try {
                    if (st.countTokens() != 3) {
                        System.err.println("Skipping bad line " + line);
                        continue;
                    }
                    String source = st.nextToken();
                    String dest = st.nextToken();
                    int cost = Integer.parseInt(st.nextToken());
                    g.addEdge(source, dest, cost);
                } catch (NumberFormatException e) {
                    System.err.println("Skipping bad line " + line);
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        System.out.println("File read...");
        Scanner in = new Scanner(System.in);
        while (processRequest(in, g))
            ;
    }

    public static boolean processRequest(Scanner in, Graph g) {
        try {
            System.out.print("Enter start node:");
            String startName = in.nextLine();

            System.out.print("Enter destination node:");
            String destName = in.nextLine();

            System.out.print("Enter algorithm (u, d, c, t): ");
            String alg = in.nextLine();

            if (alg.equals("u")) {
                g.unweighted(startName);
            } else {
                if (alg.equals("d")) {
                    g.dijkstra(startName);
                } else {
                    if(alg.equals("c")) {
                        System.out.println(g.isConnected());
                    } else {
                        if(alg.equals("t")) {
                            System.out.println(g.toMatrixRep());
                        }
                    }
                }
            }

            g.printPath(destName);
        } catch (NoSuchElementException e) {
            return false;
        } catch (Exception e) {
            System.err.println(e);
        }
        return true;
    }

    public GraphMatrix toMatrixRep() {
        GraphMatrix graphMatrix = new GraphMatrix();
        graphMatrix.matrix = new Edge[nodeMap.size()][nodeMap.size()];
        int i = 0;
        for (Node node : nodeMap.values()) {
            int j = 0;
            i++;
            for (Node nodeConnected : nodeMap.values()) {
                if(node.adj.get(i).dest == nodeConnected) {
                    graphMatrix.matrix[i][j] = node.adj.get(i);
                    break;
                }
                j++;
            }
        }
        return graphMatrix;
    }
}

