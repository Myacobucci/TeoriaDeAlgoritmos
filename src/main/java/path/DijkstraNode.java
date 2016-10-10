package path;

import graph.Edge;
import graph.Node;
import graph.State;

/**
 * Created by alex on 05/10/16.
 */
public class DijkstraNode extends Node {
    private Integer weigth = 0;


    public DijkstraNode(Integer id, Integer weigth){
        super(id);
        this.weigth = weigth;
    }

    public DijkstraNode(DijkstraNode copy) {
        super(copy.getId());
        this.weigth = copy.getWeigth();
        this.setPredecessor(copy.getPredecessor());
        for (Edge edge: copy.getEdges() ) {
            this.addEdge(edge.getTargetNode(), edge.getWeight());
        }
        if (copy.getState() == State.VISITED){ this.visited();}
    }

    public Integer getWeigth() {
        return weigth;
    }


}
