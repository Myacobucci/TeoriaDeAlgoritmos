package statistic;

import java.util.ArrayList;
import java.util.Iterator;

    /**
     * Created by alex on 24/09/16.
     */
public class BruteForce {

    protected final ArrayList<Comparable> list = new ArrayList<Comparable>();;
    protected int size;

    public BruteForce(){
        this.size = 0;
    }
    public BruteForce(ArrayList source){
        this.list.addAll(source);
        this.size = list.size();
    }


    public void addToList(Comparable e){
        this.list.add(e);
    }

    public Comparable getFromList(int pos){
        return list.get(pos);
    }


    public Object getSmallestK(int k){
        boolean isKElement;
        Iterator it = list.iterator();

        while(it.hasNext()) {
            Comparable elem = (Comparable) it.next();
            if (isKElement(elem,k)){
                return elem;
            }
        }
        return null;
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

