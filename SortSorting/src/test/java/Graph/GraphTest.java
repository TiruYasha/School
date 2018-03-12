package Graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class GraphTest {

    public static final String SECOND_NODE = "SecondNode";
    public static final String START_NODE = "StartNode";
    private Graph sut;

    @Before
    public void initialize(){
        sut = new Graph(START_NODE);
    }

    @Test
    public void initializingGraphCreatesStartNode(){
        Graph graph = new Graph(START_NODE);

        HashMap<String, Node> result = graph.nodes;

        Assert.assertNotNull(result.get(START_NODE));
    }

    @Test
    public void addNodeAddsANode(){
        sut.addNode(SECOND_NODE);

        Assert.assertEquals(sut.nodes.size(), 2);
        Assert.assertNotNull(sut.nodes.get(SECOND_NODE));
    }

    @Test
    public void addEdgeAddsEdgeToNode(){
        sut.addNode(SECOND_NODE);
        sut.addEdge(START_NODE, SECOND_NODE, 0);

        Edge result = sut.nodes.get(START_NODE).getEdges().get(0);

        assertEquals(result.getDestination().getName(), SECOND_NODE);
        assertEquals(result.getCost(), 0);
    }

    @Test
    public void toStringPrintsListOfNodesWithEdges(){
        sut.addNode(SECOND_NODE);
        sut.addEdge(START_NODE, SECOND_NODE, 0);

        String result = sut.toString();

        assertEquals(result, "StartNode: SecondNode 0 -  \n" +
                "SecondNode:  \n");
    }
}
