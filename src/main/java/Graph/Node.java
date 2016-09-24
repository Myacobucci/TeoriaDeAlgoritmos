package Graph;

import java.util.ArrayList;

/**
 * Created by juanall on 24/09/16.
 */
public class Node {
    private ArrayList<Edge> edges;

    public Node() {
        this.edges = new ArrayList<Edge>();
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void addEdge(Integer targetNode , Integer weight){
        edges.add(new Edge(targetNode,weight));
    }
}
