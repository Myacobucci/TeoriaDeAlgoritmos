package graph;

import java.util.ArrayList;

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

    public ArrayList<Integer> preOrden(Integer node) {
        //System.out.println(node);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(node);
        if (this.getNode(node).getEdges().isEmpty()) {
            //list.add(node);
            return list;
        }
        for (Edge edge : getNode(node).getEdges()) {
            list.addAll(preOrden(edge.getTargetNode()));
        }
        list.add(node);
        return list;
    }
}
