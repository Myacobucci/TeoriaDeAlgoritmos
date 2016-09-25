package graph;

/**
 * Created by juanall on 25/09/16.
 */
public class Predecessor {
    Integer id;
    Integer weight;

    public Predecessor(Integer id, Integer weight) {
        this.id = id;
        this.weight = weight;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getWeight() {
        return this.weight;
    }
}
