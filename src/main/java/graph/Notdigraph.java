package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by juanall on 24/09/16.
 */
public class Notdigraph extends Graph{

    public Notdigraph(Integer totalNodes) {
        super(totalNodes);
    }

    public void addEdge(Integer source, Integer target, Integer weight) {
        nodes.get(source).addEdge(target,weight);
        nodes.get(target).addEdge(source,weight);
    }

    public Digraph getPrimTree(Integer source) {

        Digraph digraph = new Digraph(this.totalNodes);

        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        while (visited.size() != this.totalNodes) {

            Integer MIN = 10000;
            Integer sourceV = 0;
            Integer nearest = 0;

            for (Integer currentNode : visited) {

                Node node = getNode(currentNode);

                for (Edge edge : node.getEdges()) {

                    if (! visited.contains(edge.getTargetNode())) {
                        // busqueda minimo
                        if  ( edge.getWeight() < MIN ) {
                            MIN = edge.getWeight();
                            nearest = edge.getTargetNode();
                            sourceV = node.getId();
                        }
                    }
                }
            }
            System.out.println("Agregando");
            System.out.println("Origen");
            System.out.println(sourceV);
            System.out.println("Mas cercano");
            System.out.println(nearest);
            System.out.println("Distancia");
            System.out.println(MIN);
            digraph.addEdge(sourceV,nearest,MIN);
            visited.add(nearest);

        }

        return digraph;
    }

}
