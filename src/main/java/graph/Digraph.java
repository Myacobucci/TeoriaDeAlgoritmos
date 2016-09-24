package graph;

/**
 * Created by juanall on 24/09/16.
 */
public class Digraph extends Graph {
    public Digraph(Integer totalNodes) {
        super(totalNodes);
    }

    public void addEdge(Integer source, Integer target, Integer weight) {
        this.nodes.get(source).addEdge(target,weight);
    }

}
