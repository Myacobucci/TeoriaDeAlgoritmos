package statistic;

import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;


import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

/**
 * Created by juan on 29/09/16.
 */
public class SortAndGetTest {

    @Test
    public void getKelementTest() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(100);
        arrayList.add(3);
        arrayList.add(0);
        SortAndGet sortAndGet = new SortAndGet();
        assertThat(sortAndGet.getKelement(2,arrayList), equalTo(3));
    }
}
