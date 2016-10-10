package path;

import graph.Digraph;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alex on 07/10/16.
 */
public class DijkstraTest {

    @Test
    public void dijkstraTest1() {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 1, 9);
        digraph.addEdge(0, 2, 2);
        digraph.addEdge(1, 2, 5);
        digraph.addEdge(2, 3, 8);
        digraph.addEdge(2, 4, 7);
        digraph.addEdge(3, 1, 4);
        digraph.addEdge(4, 3, 3);

        Dijkstra d = new Dijkstra(digraph, 0, 3);

        Assert.assertEquals((Integer)10, d.distanceTo(3));
        System.out.println(d.getPathTo(3).toString());
        Assert.assertEquals("[3, 2, 0]", d.getPathTo(3).toString());
    }


    @Test
    public void dijkstraTest2() {
        Digraph digraph = new Digraph(8);
        digraph.addEdge(0, 1, 3);
        digraph.addEdge(0, 2, 10);
        digraph.addEdge(2, 6, 8);
        digraph.addEdge(6, 4, 9);
        digraph.addEdge(3, 6, 9);
        digraph.addEdge(6, 1, 5);
        digraph.addEdge(2, 5, 7);
        digraph.addEdge(1, 5, 6);
        digraph.addEdge(5, 3, 4);
        digraph.addEdge(4, 3, 4);
        digraph.addEdge(4, 7, 1);

        Dijkstra d = new Dijkstra(digraph, 0, 3);

        System.out.println(d.distanceTo(3));
        Assert.assertEquals((Integer)13, d.distanceTo(3));

        System.out.println(d.getPathTo(3).toString());
        Assert.assertEquals("[3, 5, 1, 0]", d.getPathTo(3).toString());

        System.out.println(d.getPathTo(7).toString());
        Assert.assertEquals("[0]", d.getPathTo(0).toString());
    }
}