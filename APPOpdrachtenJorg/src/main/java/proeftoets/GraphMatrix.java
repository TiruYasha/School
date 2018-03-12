package proeftoets;

import les7graph.Edge;

public class GraphMatrix {

    public Edge[][] matrix;

    public GraphMatrix(Edge[][] matrix) {
        this.matrix = matrix;
    }

    public GraphMatrix() {
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != null) {
                    string += " " + matrix[i][j].cost;
                } else {
                    string += " -";
                }
            }
            string += "\n";
        }
        return string;
    }
}
