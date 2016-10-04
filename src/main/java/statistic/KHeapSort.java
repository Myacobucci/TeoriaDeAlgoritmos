package statistic;

import java.util.ArrayList;


public class KHeapSort {


    private int n;
    private int left;
    private int right;
    private int largest;
    protected int size;
    public ArrayList<Comparable> a = new ArrayList<Comparable>();

    public KHeapSort(ArrayList source){
        this.a.addAll(source);
        this.size = a.size();
    }

    public Object getSmallestK(int k){
        int counter = 0;
        buildHeap();
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxHeap(a, 0);
            if(counter == k) {
                return a.get(size-1-k);
            }
            counter ++;
        }
        return a.get(size-1-k);
    }

    protected void buildHeap(){
        n= size-1;
        for(int i=n/2;i>=0;i--){
            maxHeap(a,i);
        }
    }

    public  void maxHeap(ArrayList<Comparable> a, int i){
        left=2*i;
        right=2*i+1;
        if(left <= n && a.get(left).compareTo(a.get(i)) < 0){
            largest = left;
        }
        else{
            largest = i;
        }
        if(right <= n && a.get(right).compareTo(a.get(largest)) < 0){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxHeap(a, largest);
        }
    }

    public void exchange(int i, int j){
        Comparable b = a.get(i);
        Comparable c = a.get(j);
        a.set(i,c);
        a.set(j,b);

    }



}
