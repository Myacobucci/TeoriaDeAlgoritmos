package statistic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by eze on 02/10/16.
 */
public class KHeapSortTest {


    @Test
    public void getKSmallestTest() throws Exception {

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(10);
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(0);

        KHeapSort hs = new KHeapSort();

        Assert.assertEquals(1, hs.getKelement(1,list));
        Assert.assertEquals(3, hs.getKelement(3,list));
        Assert.assertEquals(10, hs.getKelement(5,list));
        Assert.assertNotEquals(4, hs.getKelement(5,list));


    }

}