package statistic;

import java.util.ArrayList;

/**
 * Created by alex on 29/09/16.
 */
public class KSelections implements IStatistic{
    ArrayList<Integer> list = new ArrayList();
    int size;


    public KSelections(ArrayList in){
        this.list.addAll(in);
        this.size = in.size();
    }

    public int getKelement(int k){
        int minPos=0;
        if (k >= this.size) return -1;

        for(int i=0; i<=k; i++){
            minPos = getMinBetween(i,this.size);
            swap(i,minPos);
        }

        return this.list.get(k);
    }

    protected int getMinBetween(int begin, int end){
        Integer minimum = this.list.get(begin);
        int minPos=begin;
        for(int curPos=begin; curPos < end; curPos++){
            if ( this.list.get(curPos).compareTo(minimum) < 0 ) {
                minimum = this.list.get(curPos);
                minPos = curPos;
            }
        }
        return minPos;
    }

    protected void swap(int recPos1, int recPos2){
        Integer tmpRec = this.list.get(recPos1);
        this.list.set(recPos1,this.list.get(recPos2));
        this.list.set(recPos2, tmpRec);
    }

}