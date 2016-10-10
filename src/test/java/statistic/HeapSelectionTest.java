package statistic;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by maxi on 10/10/16.
 */
public class HeapSelectionTest {


    @Test
    public void getKelementTest() {
        ArrayList array = new ArrayList();
        ArrayList array2 = new ArrayList();
        array2.add(5);
        array2.add(7);
        array2.add(0);
        array.add(5);
        array.add(1);
        array.add(100);
        array.add(3);
        array.add(0);
        array.add(7);
        HeapSelect heapSelect = new HeapSelect();
        assertThat(heapSelect.getKelement(0, array), equalTo(0));
        assertThat(heapSelect.getKelement(1, array), equalTo(1));
        assertThat(heapSelect.getKelement(2, array), equalTo(3));
        assertThat(heapSelect.getKelement(3, array), equalTo(5));
        assertThat(heapSelect.getKelement(4, array), equalTo(7));
        assertThat(heapSelect.getKelement(5, array), equalTo(100));
        assertThat(heapSelect.getKelement(0, array2), equalTo(0));
    }
}
