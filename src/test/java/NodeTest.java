import Graph.Node;
import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;


/**
 * Created by juanall on 24/09/16.
 */
public class NodeTest {

    @Test
    public void addAndGetEdgesTest() {
        Node node = new Node();
        node.addEdge(5,5);
        assertThat(node.getEdges(),hasSize(1));
        node.addEdge(1,3);
        assertThat(node.getEdges(),hasSize(2));
    }
}
