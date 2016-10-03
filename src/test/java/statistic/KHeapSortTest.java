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

        int []a1={4,1,3,2,16,9,10,14,8,7};
        KHeapSort.sort(a1);
        for(int i=0;i<a1.length;i++){
            System.out.print(a1[i] + " ");
        }
    }

}