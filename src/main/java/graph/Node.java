package graph;

import java.util.ArrayList;

/**
 * Created by juanall on 24/09/16.
 */
public class Node {
    private ArrayList<Edge> edges;
    private State state;

    public Node() {
        this.edges = new ArrayList<Edge>();
        this.state = State.NOTVISITED;
    }

    public ArrayList<Edge> getEdges() {
        return this.edges;
    }

    public void addEdge(Integer targetNode , Integer weight){
        edges.add(new Edge(targetNode,weight));
    }

    public State getState() {
        return this.state;
    }

    public void visit() {
        this.state = State.VISITED;
    }
}
