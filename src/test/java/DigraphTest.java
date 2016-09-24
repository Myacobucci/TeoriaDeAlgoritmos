
import graph.Digraph;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;
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

    @Test
    public void bfsTest() {
        Digraph digraph = new Digraph(3);
        digraph.addEdge(0,1,1);
        digraph.addEdge(1,2,1);
        digraph.addEdge(2,0,1);
        digraph.bfs(0);
        assertThat(digraph.getBfsWay(), hasSize(3));
        assertThat(digraph.getBfsWay().get(0), equalTo(0));
        assertThat(digraph.getBfsWay().get(2), equalTo(2));
    }
}
