package statistic;

import java.util.ArrayList;

/**
 * Created by maxi on 10/10/16.
 */
public class HeapSelect implements IStatistic {

    private Integer[] quickArray;
    private int maxsize;
    private int size;
    private int[] heap;

    public HeapSelect(){

    }

    public int getKelement(int k, ArrayList<Integer> arrayList){
        buildHeap(k, arrayList);
        return remove();
    }

    protected void buildHeap(int k, ArrayList<Integer> arrayList){
        this.maxsize = k+1;
        this.size = 0;
        this.heap = new int[this.maxsize + 1];
        this.heap[0] = Integer.MAX_VALUE;

        for (int i = 0; i < arrayList.size(); i++) {
            int currentElement = arrayList.get(i);
            if (size == k+1) {
                maxHeap();
                if(this.heap[1] > currentElement){
                    remove();
                    insert(currentElement);
                }
            } else {
                insert(currentElement);
            }
        }
        maxHeap();
    }

    private int parent(int pos){
        return pos / 2;
    }

    private int leftChild(int pos){
        return (2 * pos);
    }

    private int rightChild(int pos){
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos){
        if (pos >=  (size / 2)  &&  pos <= size){
            return true;
        }
        return false;
    }

    private void swap(int fpos,int spos){
        int tmp;
        tmp = this.heap[fpos];
        this.heap[fpos] = this.heap[spos];
        this.heap[spos] = tmp;
    }

    private void maxHeapify(int pos){
        if (!isLeaf(pos)){
            if ( this.heap[pos] < this.heap[leftChild(pos)]  || this.heap[pos] < this.heap[rightChild(pos)]){
                if (this.heap[leftChild(pos)] > this.heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                }else{
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element){
        this.heap[++size] = element;
        int current = size;
        while(this.heap[current] > this.heap[parent(current)]) {
            swap(current,parent(current));
            current = parent(current);
        }
    }

    public void maxHeap(){
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    public int remove(){
        int popped = this.heap[1];
        this.heap[1] = this.heap[size--];
        if(size>0){
            maxHeapify(1);
        }
        return popped;
    }
}