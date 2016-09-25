import graph.Digraph;
import org.junit.Test;
import path.BFS;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by juanall on 25/09/16.
 */
public class BFSTest {

    @Test
    public void bfsAlgorithmTest() {
        Digraph digraph = new Digraph(4);
        digraph.addEdge(0,1,2);
        digraph.addEdge(1,2,1);
        digraph.addEdge(2,0,1);
        digraph.addEdge(0,3,5);

        BFS bfs = new BFS(digraph,0,2);

        assertThat(bfs.getDistance(), equalTo(3));
        assertThat(bfs.path(), hasSize(3));
        assertThat(bfs.path().get(0), equalTo(0));
        assertThat(bfs.path().get(1), equalTo(1));
        assertThat(bfs.path().get(2), equalTo(2));
    }
}
