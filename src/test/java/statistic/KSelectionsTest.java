package statistic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by alex on 02/10/16.
 */
public class KSelectionsTest {
    @Test
    public void getKSmallestTest() throws Exception {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(10);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(0);

        KSelections ks = new KSelections();

        Assert.assertEquals(1, ks.getKelement(1,list));
        Assert.assertEquals(3, ks.getKelement(3,list));
        Assert.assertEquals(10, ks.getKelement(5,list));
        Assert.assertNotEquals(4, ks.getKelement(5,list));

    }

}