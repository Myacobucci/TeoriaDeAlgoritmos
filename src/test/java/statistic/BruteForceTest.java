package statistic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alex on 28/09/16.
 */
public class BruteForceTest {
    @Test
    public void getSmallestKTest() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(10);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(0);

        BruteForce bf = new BruteForce();

        Assert.assertEquals(1, bf.getKelement(1,list));
        Assert.assertEquals(10, bf.getKelement(5,list));

    }

}