import graph.Notdigraph;
import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

/**
 * Created by juanall on 24/09/16.
 */
public class NotDigraphTest {

     @Test
    public void addEdgesTest() {
         Notdigraph notdigraph = new Notdigraph(10);
         notdigraph.addEdge(1,3,5);

         assertThat(notdigraph.getNode(1).getEdges(),hasSize(1));
         assertThat(notdigraph.getNode(3).getEdges(),hasSize(1));
     }
}
