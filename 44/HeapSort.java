/*
Dorothy Ng
APCS2 pd10
HW#44 -- Sort of Like Magic
2016-05-24
*/

public class HeapSort {
    public static  void swap(ALHeap heap, int pos1, int pos2) {
	heap.set(pos1, heap.set(pos2,heap.get(pos1)));
    }

    public static void sort(ALHeap heap, int pos){
	if (pos >= 0){
	    int parent = (pos-1)/2;
	    if (parent >= 0){
		if (heap.get(parent) < heap.get(pos)){
		    swap(heap, parent, pos);
		    sort (heap, pos);
		}
	    }
	sort(heap,pos-1);
	}
    }
    public static void sort(ALHeap heap){
	sort(heap, heap.size()-1);
    }

    public static String printHeap(ALHeap heap){
	return heap.toString();
    }

    public static void main(String[]args){
	ALHeap pile = new ALHeap();
	pile.add(2);
	pile.add(4);
	pile.add(6);
	pile.add(8);
	pile.add(10);
	pile.add(1);
	pile.add(3);
	pile.add(5);
	pile.add(7);
	pile.add(9);

	System.out.println(pile);

	sort(pile);

	System.out.println(pile);
    }
}