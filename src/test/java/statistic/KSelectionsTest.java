package statistic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alex on 02/10/16.
 */
public class KSelectionsTest {
    @Test
    public void getKSmallest() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(10);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(0);

        KSelections ks = new KSelections(list);

        Assert.assertEquals(1, ks.getKSmallest(1));
        Assert.assertEquals(3, ks.getKSmallest(3));
        Assert.assertEquals(10, ks.getKSmallest(5));
        Assert.assertNotEquals(4, ks.getKSmallest(5));

    }

}