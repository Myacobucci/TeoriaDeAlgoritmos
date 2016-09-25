
import graph.Digraph;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
/**
 * Created by juanall on 24/09/16.
 */
public class DigraphTest {

    @Test
    public void addEdgesTest() {
        Digraph digraph = new Digraph(10);
        digraph.addEdge(0,3,5);

        assertThat(digraph.getNode(3).getEdges(), hasSize(0));
        assertThat(digraph.getNode(0).getEdges(), hasSize(1));
    }

}
