package tspTests;

import org.junit.Test;
import tsp.TSP;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by juanall on 12/11/16.
 */
public class TSPTests {

    @Test
    public void tspSimpleCaseTest() {
        Set<Integer> nodes = new HashSet<>();
        //nodes.add(0);
        nodes.add(1);
        nodes.add(2);
        nodes.add(3);

        Integer[][] matrix = new Integer[4][4];
        matrix[0][0] = 0;
        matrix[1][1] = 0;
        matrix[2][2] = 0;
        matrix[3][3] = 0;

        matrix[1][0] = 10;
        matrix[0][1] = 10;

        matrix[2][0] = 5;
        matrix[0][2] = 5;

        matrix[2][1] = 3;
        matrix[1][2] = 3;

        matrix[3][1] = 2;
        matrix[1][3] = 2;

        matrix[0][3] = 7;
        matrix[3][0] = 7;

        matrix[3][2] = 9;
        matrix[2][3] = 9;

        TSP tsp = new TSP();
        System.out.println(tsp.getPathWeight(0,nodes,matrix));

    }
}
