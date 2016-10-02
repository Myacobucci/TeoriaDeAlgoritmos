package statistic;

import java.util.ArrayList;

public class Quickselect implements IStatistic{
	Integer[] quickArray;

	public Quickselect(Integer[] elements){
		this.quickArray = elements;
	}

	public int getKelement(int k){
		if (this.quickArray.length < 1){
			return -1;
		}
		return quickSelect(0, this.quickArray.length-1,k+1);
	}

	public int quickSelect(int p, int r, int i){
		//Case in whick subarray has only 1 element
		if (p == r){
			return quickArray[p];
		}
		//Return pivot element
		int q = quickSelectPartition(p,r);
		int k = q - p + 1;
		//Check if pivot is the k smallest
		if (i==k){
			return quickArray[q];
		}
		else if (i<k){
			return quickSelect(p,q-1,i);
		}
		else{
			return quickSelect(q+1,r,i-k);
		}
	}

	public int quickSelectPartition(int p,int r){
		int pivot=quickArray[p];
		int i=p; 
		int j=r;
		int aux;
		while(i<j){
			//Search a bigger element than pivot
			while((quickArray[i]<=pivot) && (i<j)) i++;
			//Search a smaller element than pivot
			while(quickArray[j]>pivot) j--;
			if (i<j) {              
				//swap
				aux= quickArray[i];
				quickArray[i]=quickArray[j];
				quickArray[j]=aux;
			}
		}
		//allign pivot
		quickArray[p]=quickArray[j];
		quickArray[j]=pivot;
		return j;
	}

}
