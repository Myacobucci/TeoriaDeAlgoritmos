package path;

import graph.*;
import javafx.util.Pair;

import java.util.*;

/**
 * Created by devalais on 10/10/16.
 */
public class AStar extends Path {
    /*
    http://mat.uab.cat/~alseda/MasterOpt/AStar-Algorithm.pdf
    http://www.growingwiththeweb.com/2012/06/a-pathfinding-algorithm.html
    */

    private ArrayList<Node> open;
    private ArrayList<Node> close;
    private Digraph digraph;

    public AStar(final Digraph digraph, Integer source, final Integer target) {
        super(source);
        this.digraph = digraph;
        open = new ArrayList();
        close = new ArrayList();
        Node nodeStart = digraph.getNode(source);
        Node current;
        nodeStart.g = 0;
        Node nodeTarget = digraph.getNode(target);
        Pair<Integer,Integer> targetNodeXY = nodeTarget.getXY();
        nodeStart.f = nodeStart.g + distanceToTarget(nodeStart.getXY(),targetNodeXY);
        open.add(nodeStart);
        while(!open.isEmpty()){
            current = getNodeWithLowestFCost();
            if(current.equals(nodeTarget)){
                distance(target);
                return;
            }
            open.remove(current);
            close.add(current);
            ArrayList<Node> neighbors = current.getNeighbors(digraph);
            for(Node aNeighbor : neighbors){
                if(!close.contains(aNeighbor)){
                    //double actualNeighborF = aNeighbor.g +  distanceToTarget(aNeighbor.getXY(),targetNodeXY);
                    if(!open.contains(aNeighbor)){
                        open.add(aNeighbor);
                    }
                    if(aNeighbor.g == -1 || aNeighbor.g > aNeighbor.possibleG){
                        aNeighbor.g =  aNeighbor.possibleG;
                        aNeighbor.f =  aNeighbor.g +  distanceToTarget(aNeighbor.getXY(),targetNodeXY);;
                        aNeighbor.parent =  aNeighbor.possibleParent;
                    }
                }
            }
        }
    }


    private Node getNodeWithLowestFCost() {
        Node minNode  = open.get(0);
        for(Node node : open){
            if(node.f < minNode.f){
                minNode = node;
            }
        }
        return minNode;
    }

    public Double distanceToTarget(Pair<Integer,Integer> node1XY, Pair<Integer,Integer> node2XY){
        Integer xcoord = node1XY.getKey()- node2XY.getKey();
        Integer ycoord = node1XY.getValue() - node2XY.getValue();
        return Math.sqrt(xcoord*xcoord + ycoord*ycoord);
    }

    /**
     * Build path, between source and target, using BFS information
     * @param target
     */
    protected void distance(Integer target) {
        Integer actual = target;
        Node node = digraph.getNode(target);
        distance = 0;
        while(node.parent != null) {
            distance += node.parent.getWeightTo(node, digraph);
            node = node.parent;
        }

    }

}