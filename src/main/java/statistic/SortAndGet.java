package statistic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by juan on 29/09/16.
 */
public class SortAndGet implements IStatistic{
    Integer[] array;

    public SortAndGet(Integer[] elements) {
        this.array = elements;
    }

    public int getKelement(int index) {
        Arrays.sort(array);
        return array[index];
    }

}
