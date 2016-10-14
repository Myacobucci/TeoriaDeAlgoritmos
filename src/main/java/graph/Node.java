package graph;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Created by juanall on 24/09/16.
 */
public class Node {
    private ArrayList<Edge> edges;
    private State state;
    private Predecessor predecessor;
    private Integer id;
    private Integer x;
    private Integer y;
    public  Integer g = -1;
    public  Integer possibleG;
    public double f;
    public Node parent = null;
    public Node possibleParent;


    public Node(Integer id) {
        this.id = id;
        this.edges = new ArrayList<Edge>();
        this.state = State.NOTVISITED;

    }

    public Integer getId() {
        return this.id;
    }

    public void setPredecessor(Predecessor predecessor) {
        this.predecessor = predecessor;
    }

    public Predecessor getPredecessor() {
        return this.predecessor;
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

    public void visited() {
        this.state = State.VISITED;
    }

    public void setXY(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Pair<Integer, Integer> getXY(){
        return new Pair(x,y);
    }

    public ArrayList<Node> getNeighbors(Digraph digraph) {
        ArrayList<Node> neighbors = new ArrayList<>();
        for(Edge edge : edges){
            Node neighbor = digraph.getNode(edge.getTargetNode());
            neighbors.add(neighbor);
            neighbor.possibleG = this.g + edge.getWeight();
            neighbor.possibleParent = this;
        }
        return neighbors;
    }

    public Integer getWeightTo(Node node, Digraph digraph) {
        for(Edge edge : edges){
            Node neighbor = digraph.getNode(edge.getTargetNode());
            if(node.equals(neighbor)) {
                return edge.getWeight();
            }

        }
        return 100000; //error
    }
}
