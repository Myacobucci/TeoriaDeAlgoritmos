package statistic;

import java.util.ArrayList;
import java.util.Iterator;

    /**
     * Created by alex on 24/09/16.
     */
public class BruteForce implements IStatistic{

    protected ArrayList<Integer> list = new ArrayList<Integer>();
    protected int size;

    public BruteForce(){

    }

    public int getKelement(int k, ArrayList<Integer> arrayList){
        this.list = arrayList;
        this.size = list.size();
        Iterator it = list.iterator();

        while(it.hasNext()) {
            Integer elem = (Integer) it.next();
            if (isKElement(elem,k)){
                return elem;
            }
        }
        return 0;
    }

    protected Boolean isKElement(Integer element, int k) {
        Iterator<Integer> it = list.iterator();
        int kPosition = 0;
        Integer actual;

        while (it.hasNext()) {
            actual = it.next();
            if (actual.compareTo(element) < 0) {
                kPosition++;
            }
        }

        return (kPosition == k);
    }
}

