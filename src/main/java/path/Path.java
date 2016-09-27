package path;

import graph.Node;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by juanall on 24/09/16.
 */
public abstract class Path {
    protected Integer distance;
    protected Integer source;
    protected ArrayList<Integer> path;
    protected HashMap<Integer, Node> nodes;

    protected Path(Integer source) {
        this.distance = 0;
        this.source = source;
        this.path = new ArrayList<Integer>();
        this.nodes = new HashMap<Integer, Node>();
    }

    public ArrayList<Integer> path() {
        return this.path;
    }

    public Integer getDistance() {
        return this.distance;
    }

    /**
     * Build path, between source and target, using BFS information
     * @param target
     */
    protected void distance(Integer target) {
        Integer actual = target;
        this.path.add(0,target);
        while (actual != this.source) {
            distance = distance + nodes.get(actual).getPredecessor().getWeight();
            this.path.add(0, nodes.get(actual).getPredecessor().getId());
            actual = nodes.get(actual).getPredecessor().getId();
        }
    }

}
