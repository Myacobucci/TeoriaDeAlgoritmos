import graph.Digraph;
import org.junit.Test;
import path.AStar;
import path.HeuristicSearch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by maxi on 08/10/16.
 */
public class AStarTest {
    @Test
    public void bfsAlgorithmTest() {
        Digraph digraph = new Digraph(4);
        digraph.getNode(0).setXY(0,0);
        digraph.getNode(1).setXY(0,2);
        digraph.getNode(2).setXY(1,2);
        digraph.getNode(3).setXY(5,0);
        digraph.addEdge(0,1,2);
        digraph.addEdge(1,2,1);
        digraph.addEdge(2,0,1);
        digraph.addEdge(0,3,5);
        digraph.addEdge(3,2,2);

        AStar astar = new AStar(digraph,0,2);

        assertThat(astar.getDistance(), equalTo(3));
    }
    @Test
    public void heuristicSearchTest2() {
        Digraph digraph = new Digraph(4);
        digraph.getNode(0).setXY(0, 0);
        //Node 1 now is far away from target
        digraph.getNode(1).setXY(100, 2);
        digraph.getNode(2).setXY(1, 2);
        digraph.getNode(3).setXY(5, 0);
        digraph.addEdge(0,1,2);
        digraph.addEdge(1, 2, 1);
        digraph.addEdge(2, 0, 1);
        digraph.addEdge(0, 3, 5);
        digraph.addEdge(3, 2, 2);

        AStar astar = new AStar(digraph,0,2);

        assertThat(astar.getDistance(), equalTo(7));
    }
}
