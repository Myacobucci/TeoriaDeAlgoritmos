package path;

import graph.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by juanall on 24/09/16.
 */
public class BFS extends Path {

    public BFS(Digraph digraph, Integer source, Integer target) {
        super(source);
        Queue<Node> queue = new LinkedList<Node>();
        Node node = digraph.getNode(source);
        node.visited();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node.getId().equals(target)) {
                this.distance(target);
                return;
            }
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
    }

}
