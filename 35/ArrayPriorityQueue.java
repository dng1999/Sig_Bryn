/* Dorothy Ng
   APCS2 pd10
   HW35 -- Privileged Status Gets You to the Front of the Line
   2016-05-04 */
import java.util.ArrayList;

public class ArrayPriorityQueue{
    
    private ArrayList<Comparable> arr;
    
    public ArrayPriorityQueue(){
	arr = new ArrayList<Comparable>();
    }

    public void add(Comparable x){
        arr.add(x);
    }
    
    public boolean isEmpty(){
	if (arr.size()==0) return true;
	return false;
    }
    
    public Comparable peekMin(){
	Comparable minVal = arr.get(0);
	for (int i = 1; i<arr.size(); i++){
	    if (minVal.compareTo(arr.get(i))>0){
		minVal = arr.get(i);
	    }
	}
	return minVal;
    }

    public Comparable removeMin(){
	Comparable minVal = peekMin();
	for (int i = 0; i<arr.size(); i++){
	    if (arr.get(i).compareTo(minVal)==0){
		arr.remove(i);
	    }
	}
	return minVal;
    }
    
    public String toString(){
	String ret="";
	for (int i = 0; i<arr.size(); i++){
	    ret+=arr.get(i)+" ";
	}
	return ret;
    }

    public static void main (String[]args){
	ArrayPriorityQueue goldCity = new ArrayPriorityQueue();
	goldCity.add(4);
	goldCity.add(2);
	goldCity.add(8);
	goldCity.add(5);
	System.out.println(goldCity);
	System.out.println(goldCity.peekMin());
	goldCity.removeMin();
	System.out.println(goldCity);
    }
}
