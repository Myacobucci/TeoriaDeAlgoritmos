package tsp;

import java.util.HashSet;
import java.util.Set;

public class TSP {

    private static final Integer integer = 0;

    public final Integer getPathWeight(Integer source, Set<Integer> nodes, Integer[][] matrix) {
        if (nodes.isEmpty()) {
            return matrix[source][0];
        }
        Set<Integer> solutions = new HashSet<>();
        for (Integer node : nodes) {
            Integer value = matrix[source][node] + getPathWeight(node,copySet(nodes,node),matrix);
            solutions.add(value);
        }
        return getMin(solutions);
    }

    public Integer getMin(Set<Integer> values) {
        Integer min = 1000000;
        for (Integer value : values) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    public Set<Integer> copySet(Set<Integer> set, Integer toDelete) {
        Set<Integer> copySet = new HashSet<>();
        copySet.addAll(set);
        copySet.remove(toDelete);
        return copySet;
    }

}
