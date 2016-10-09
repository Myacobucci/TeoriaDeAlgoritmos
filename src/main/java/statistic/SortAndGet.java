package statistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by juan on 29/09/16.
 */
public class SortAndGet implements IStatistic{

    public SortAndGet() {
    }

    public int getKelement(int index, ArrayList arrayList) {
        Collections.sort(arrayList);
        return (int) arrayList.get(index);
    }

}
