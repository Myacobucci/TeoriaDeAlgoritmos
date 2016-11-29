import graph.AproxTSP;
import graph.Notdigraph;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by juan on 28/11/16.
 */
public class AproxTSPTest {

    @Test
    public void getPathTest() {
        Notdigraph notdigraph = new Notdigraph(4);

        Integer[][] matrix = new Integer[4][4];
        matrix[0][0] = 0;
        matrix[1][1] = 0;
        matrix[2][2] = 0;
        matrix[3][3] = 0;

        matrix[1][0] = 10;
        matrix[0][1] = 10;
        notdigraph.addEdge(0,1,10);

        matrix[2][0] = 35;
        matrix[0][2] = 35;
        notdigraph.addEdge(0,2,35);

        matrix[2][1] = 3;
        matrix[1][2] = 3;
        notdigraph.addEdge(1,2,3);

        matrix[3][1] = 2;
        matrix[1][3] = 2;
        notdigraph.addEdge(1,3,2);

        matrix[0][3] = 7;
        matrix[3][0] = 7;
        notdigraph.addEdge(3,0,7);

        matrix[3][2] = 9;
        matrix[2][3] = 9;
        notdigraph.addEdge(2,3,9);

        AproxTSP aproxTSP = new AproxTSP();

        assertThat(5, equalTo(aproxTSP.getPath(notdigraph).size()));
        System.out.println(aproxTSP.getPath(notdigraph));
    }
}
