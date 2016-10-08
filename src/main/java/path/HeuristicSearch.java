package path;

import graph.*;
import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeuristicSearch extends Path{
    public HeuristicSearch(final Digraph digraph, Integer source, final Integer target) {
        super(source);
        //Create priorityQueue
        PriorityQueue<Node> queue = new PriorityQueue<Node>(10, new Comparator<Node>() {
            public int compare(Node node1, Node node2) {
                Pair<Integer,Integer> node1XY = digraph.getNode(node1.getId()).getXY();
                Pair<Integer,Integer> node2XY = digraph.getNode(node2.getId()).getXY();
                Pair targetNodeXY = digraph.getNode(target).getXY();
                Double distanceNode1 = distanceToTarget(node1XY, targetNodeXY);
                Double distanceNode2 = distanceToTarget(node2XY, targetNodeXY);
                if (distanceNode1 < distanceNode2)
                {
                    return -1;
                }
                if (distanceNode1 > distanceNode2)
                {
                    return 1;
                }
                return 0;
            }
        });
        Node node = digraph.getNode(source);
        node.visited();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            for (Edge edge : node.getEdges()) {
                Node currentNode = digraph.getNode(edge.getTargetNode());
                if (currentNode.getState() == State.NOTVISITED) {
                    currentNode.setPredecessor(new Predecessor(node.getId(),edge.getWeight()));
                    queue.add(currentNode);
                    nodes.put(currentNode.getId(),currentNode);
                    currentNode.visited();
                }
            }
        }
        this.distance(target);
    }

    public Double distanceToTarget(Pair<Integer,Integer> node1XY, Pair<Integer,Integer> node2XY){
        Integer xcoord = node1XY.getKey()- node2XY.getKey();
        Integer ycoord = node1XY.getValue() - node2XY.getValue();
        return Math.sqrt(xcoord*xcoord + ycoord*ycoord);
    }
}
