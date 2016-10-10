package graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by juanall on 24/09/16.
 */
public abstract class Graph {
    protected final HashMap<Integer,Node> nodes = new HashMap<Integer, Node>();
    protected Integer totalNodes;

    public Graph(Integer totalNodes) {
        this.totalNodes = totalNodes;
        for (Integer index = 0; index < totalNodes ; index++ ) {
            nodes.put(index,new Node(index));
        }
    }

    public abstract void addEdge(Integer source, Integer target, Integer weight);

    public Node getNode(Integer id) {
        return nodes.get(id);
    }

    public Integer getTotalNodes() {return this.totalNodes; }


    public ArrayList<Edge> adj_e(Integer source){
        return this.nodes.get(source).getEdges();
    }

    public ArrayList<Node> adj(Integer source){
        ArrayList<Edge> edges = this.nodes.get(source).getEdges();
        ArrayList<Node> adjNodes = new ArrayList<>();

        for (Edge edge: edges){
            adjNodes.add(edge.getTargetNode(),this.nodes.get(edge.getTargetNode()));
        }
        return adjNodes;
    }
}