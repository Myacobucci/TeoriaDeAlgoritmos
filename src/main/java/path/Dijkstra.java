package path;

import graph.Digraph;
import graph.Edge;
import graph.Predecessor;
import graph.State;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


/**
 * Created by alex on 03/10/16.
 */
public class Dijkstra extends Path{


    Comparator<DijkstraNode> sortQueue = new PQComparator();
    PriorityQueue<DijkstraNode> pQueue;
    HashMap<Integer, DijkstraNode> visitedNodes;

    Integer totalVisited = 0;
    Integer totalNodes = 0;
    Integer target;


    public Dijkstra(Digraph digraph, Integer source, Integer target) {
        super(source);
        this.target = target;

        //
        totalNodes = digraph.getTotalNodes();
        visitedNodes = new HashMap<>(totalNodes);
        pQueue = new PriorityQueue<DijkstraNode>(totalNodes,sortQueue);

        // Charge first element in Priority Queue
        DijkstraNode sourceNode = new DijkstraNode(source, 0);
        Predecessor pdSource = new Predecessor(-1,-1);
        sourceNode.setPredecessor(pdSource);
        pQueue.add(sourceNode);



        while ((pQueue.size() > 0) && (totalVisited < totalNodes)){

            DijkstraNode pqNode = pQueue.poll();

            if (digraph.getNode(pqNode.getId()).getState() == State.NOTVISITED){
                digraph.getNode(pqNode.getId()).visited();
                visitedNodes.put(pqNode.getId(), pqNode);
                totalVisited++;

                Predecessor pd = new Predecessor(pqNode.getId(),pqNode.getWeigth());

                ArrayList<Edge> edgesAdj = digraph.adj_e(pqNode.getId());

                for (Edge edge: edgesAdj){
                    if (digraph.getNode(edge.getTargetNode()).getState() == State.NOTVISITED){
                        Integer newDistance = pqNode.getWeigth() + edge.getWeight();
                        DijkstraNode dn = new DijkstraNode(  edge.getTargetNode(), newDistance);
                        dn.setPredecessor(pd);
                        pQueue.add(dn);
                    }
                }
            }
        }
    }


    public State isVisited(Integer id){
        return this.visitedNodes.get(id).getState();
    }

    public Integer distanceTo(Integer target){
        DijkstraNode node = this.visitedNodes.get(target);

        if (node == null) { return -1; }

        return node.getWeigth();
    }

    public ArrayList<Integer> getPathTo(Integer target){
        DijkstraNode actualNode = this.visitedNodes.get(target);
        ArrayList<Integer> path = new ArrayList<>();
        if (actualNode == null){ return null;}

        while ( actualNode != null){
            path.add(actualNode.getId());
            Predecessor pred = actualNode.getPredecessor();
            actualNode = this.visitedNodes.get(pred.getId());
        }
        return path;
    }

}
