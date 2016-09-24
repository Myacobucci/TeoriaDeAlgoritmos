import graph.Edge;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by juanall on 24/09/16.
 */
public class EdgeTest {

    @Test
    public void createEdgeTest() {
        Edge edge = new Edge(3,5);
        assertThat(edge.getWeight(),equalTo(5));
        assertThat(edge.getTargetNode(),equalTo(3));
    }
}
