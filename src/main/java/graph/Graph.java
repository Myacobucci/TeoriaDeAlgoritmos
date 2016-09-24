package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by juanall on 24/09/16.
 */
public abstract class Graph {
    protected final HashMap<Integer,Node> nodes = new HashMap<Integer, Node>();
    private ArrayList<Integer> bfsWay;

    public Graph(Integer totalNodes) {
        bfsWay = new ArrayList<Integer>();
        for (Integer index = 0; index < totalNodes ; index++ ) {
            nodes.put(index,new Node());
        }
    }

    public abstract void addEdge(Integer source, Integer target, Integer weight);

    public Node getNode(Integer id) {
        return nodes.get(id);
    }

    public void bfs(Integer root) {
        bfsWay.add(root);
        Queue<Node> queue = new LinkedList<Node>();
        Node node = nodes.get(root);
        node.visit();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            for (Edge edge : node.getEdges()) {
                Node currentNode = nodes.get(edge.getTargetNode());
                if (currentNode.getState() == State.NOTVISITED) {
                    System.out.println(edge.getTargetNode());
                    bfsWay.add(edge.getTargetNode());
                    queue.add(currentNode);
                    currentNode.visit();
                }

            }
        }
    }

    public ArrayList<Integer> getBfsWay() {
        return this.bfsWay;
    }

}