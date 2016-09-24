package Graph;

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
}
