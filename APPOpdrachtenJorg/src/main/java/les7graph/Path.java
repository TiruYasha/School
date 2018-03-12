package les7graph;

public class Path implements Comparable<Path> {

    public Node dest;
    public double cost;

    public Path(Node dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Path rhs) {
        double otherCost = rhs.cost;
        return Double.compare(cost, otherCost);
    }
}
