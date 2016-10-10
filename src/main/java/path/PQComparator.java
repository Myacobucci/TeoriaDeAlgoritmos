package path;

import path.DijkstraNode;

import java.util.Comparator;


/**
 * Created by alex on 05/10/16.
 */

class PQComparator implements Comparator<DijkstraNode> {

    public int compare(DijkstraNode one, DijkstraNode two) {
        return one.getWeigth() - two.getWeigth();
    }

}