package statistic;

import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

/**
 * Created by juan on 29/09/16.
 */
public class SortAndGetTest {

    @Test
    public void getKelement() {
        Integer[] array = new Integer[5];
        array[0] = 5;
        array[1] = 1;
        array[2] = 100;
        array[3] = 3;
        array[4] = 0;
        SortAndGet sortAndGet = new SortAndGet(array);
        assertThat(sortAndGet.getKelement(2), equalTo(3));
    }
}
