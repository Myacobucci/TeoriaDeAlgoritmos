package statistic;

import java.util.ArrayList;
import java.util.Iterator;

    /**
     * Created by alex on 24/09/16.
     */
public class BruteForce implements IStatistic{

    protected final ArrayList<Integer> list = new ArrayList<Integer>();;
    protected int size;

    public BruteForce(ArrayList source){
        this.size = 0;
        this.list.addAll(source);
        this.size = list.size();
    }

    public int getKelement(int k){
        Iterator it = list.iterator();

        while(it.hasNext()) {
            Integer elem = (Integer) it.next();
            if (isKElement(elem,k)){
                return elem;
            }
        }
        return 0;
    }

    protected Boolean isKElement(Comparable element, int k) {
        Iterator it = list.iterator();
        int kPosition = 0;

        while (it.hasNext()) {
            Comparable actual = (Comparable) it.next();
            if (actual.compareTo(element) < 0) {
                kPosition++;
            }
        }

        if (kPosition == k)
            return true;
        return false;
    }
}

