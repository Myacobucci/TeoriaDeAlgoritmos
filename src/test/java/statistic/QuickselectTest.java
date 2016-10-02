package statistic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;

public class QuickselectTest {
	@Test
    public void getKelement() {
        Integer[] array = new Integer[6];
        array[0] = 5;
        array[1] = 1;
        array[2] = 100;
        array[3] = 3;
        array[4] = 0;
        array[5] = 7;
        Quickselect quickselect = new Quickselect(array);
        assertThat(quickselect.getKelement(0), equalTo(0));
        assertThat(quickselect.getKelement(1), equalTo(1));
        assertThat(quickselect.getKelement(2), equalTo(3));
        assertThat(quickselect.getKelement(3), equalTo(5));
        assertThat(quickselect.getKelement(4), equalTo(7));
        assertThat(quickselect.getKelement(5), equalTo(100));
    }
}
