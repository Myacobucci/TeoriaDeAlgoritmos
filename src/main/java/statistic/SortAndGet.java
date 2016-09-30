package statistic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by juan on 29/09/16.
 */
public class SortAndGet {
    Integer[] array;

    public SortAndGet(Integer[] elements) {
        this.array = elements;
    }

    public int getKelement(Integer index) {
        Arrays.sort(array);
        return array[index];
    }

}
