package statistic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;

import java.util.ArrayList;

public class QuickselectTest {
	@Test
    public void getKelementTest() {
        ArrayList array = new ArrayList();
        array.add(5);
        array.add(1);
        array.add(100);
        array.add(3);
        array.add(0);
        array.add(7);
        Quickselect quickselect = new Quickselect();
        assertThat(quickselect.getKelement(0,array), equalTo(0));
        assertThat(quickselect.getKelement(1,array), equalTo(1));
        assertThat(quickselect.getKelement(2,array), equalTo(3));
        assertThat(quickselect.getKelement(3,array), equalTo(5));
        assertThat(quickselect.getKelement(4,array), equalTo(7));
        assertThat(quickselect.getKelement(5,array), equalTo(100));
    }
}
