package Graph;

import java.util.HashMap;

/**
 * Created by juanall on 24/09/16.
 */
public abstract class Graph {
    protected final HashMap<Integer,Node> nodes = new HashMap<Integer, Node>();

    public Graph(Integer totalNodes) {
        for (Integer index = 0; index < totalNodes ; index++ ) {
            nodes.put(index,new Node());
        }
    }

    public abstract void addEdge(Integer source, Integer target, Integer weight);

    public Node getNode(Integer id) {
        return nodes.get(id);
    }

}