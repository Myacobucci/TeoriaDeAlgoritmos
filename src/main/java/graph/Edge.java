package graph;

/**
 * Created by juanall on 24/09/16.
 */
public class Edge {
    private Integer targetNode;
    private Integer weight;

    public Edge(Integer targetNode, Integer weight) {
        this.targetNode = targetNode;
        this.weight = weight;
    }

    public Integer getTargetNode() {
        return this.targetNode;
    }

    public Integer getWeight() {
        return this.weight;
    }
}
