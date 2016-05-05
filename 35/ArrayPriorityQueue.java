public class ArrayPriorityQueue implements PriorityQueue{
    
    private ArrayList<Integer> queue;
    
    public ArrayPriorityQueue(){
	queue = new ArrayList<Integer>();
    }
    
    public static boolean isEmpty(){
	if (queue.size()==0) return true;
	return false;
    }

    public static void add(Integer x){
	
    }
}
