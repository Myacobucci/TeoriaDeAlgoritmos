package statistic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alex on 28/09/16.
 */
public class BruteForceTest {
    @Test
    public void getSmallestK() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(10);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(0);

        BruteForce bf = new BruteForce(list);

        Assert.assertEquals(1, bf.getSmallestK(1));
        Assert.assertEquals(3, bf.getSmallestK(3));
        Assert.assertEquals(10, bf.getSmallestK(5));
        Assert.assertNotEquals(4, bf.getSmallestK(5));

    }

}