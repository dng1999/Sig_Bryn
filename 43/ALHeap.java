/*
Dorothy Ng
APCS2 pd10
HW 43 -- Heap of Trouble
2016-05-23
 */
/*****************************************************
 * class ALHeap
 * Implements a min heap using an ArrayList as underlying container
 *****************************************************/

import java.util.ArrayList;

public class ALHeap {

    //instance vars
    private ArrayList<Integer> _heap; //underlying container is array of Integers

    /*****************************************************
     * default constructor  ---  inits empty heap
     *****************************************************/
    public ALHeap() 
    { 
	_heap = new ArrayList<Integer>();
    }



    /*****************************************************
     * toString()  ---  overrides inherited method
     * Returns either 
     * a) a level-order traversal of the tree (simple version)
     * b) ASCII representation of the tree (bit more complicated, much more fun)
     *****************************************************/
    public String toString() 
    {
	String str = "";
	for (int i=0;i<_heap.size();i++){
	    str+= _heap.get(i)+" ";
	}
	return str;
    }//O(?)



    /*****************************************************
     * boolean isEmpty()
     * Returns true if no meaningful elements in heap, false otherwise
     *****************************************************/
    public boolean isEmpty() 
    {
	return _heap.isEmpty(); 
    } //O(1)



    /*****************************************************
     * Integer peekMin()
     * Returns min value in heap
     * Postcondition: Heap remains unchanged.
     *****************************************************/
    public Integer peekMin() 
    { 
	return _heap.get(0);
    } //O(1)



    /*****************************************************
     * add(Integer) 
     * Inserts an element in the heap
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void add( Integer addVal, int index )
    {
	if (index>_heap.size()-1) _heap.add(addVal);
	else if (_heap.get(index) < addVal){
	    add(addVal, index*2+1);
	}
	else if (_heap.get(index) > addVal){
	    add(addVal, index*2+2);
	}
	else _heap.add(index,addVal);
    }
    
    public void add( Integer addVal ) 
    { 
	add(addVal,0);
    } //O(?)



    /*****************************************************
     * removeMin()  ---  means of removing an element from heap
     * Removes and returns least element in heap.
     * Postcondition: Tree maintains heap property.
     *****************************************************/
    public void removeMin(int curr){
	if (minChildPos(curr) == -1) _heap.remove(curr);
	else if (minChildPos(curr) == curr*2+1) {
	    _heap.set(curr,_heap.get(curr*2+1));
	    removeMin(curr*2+1);
	}
	else if (minChildPos(curr) == curr*2+2) {
	    _heap.set(curr,_heap.get(curr*2+2));
	    removeMin(curr*2+2);
	}
    }

    public Integer removeMin() 
    {
	Integer stor = _heap.get(0);
	removeMin(0);
	return stor;
    }//O(?)



    /*****************************************************
     * minChildPos(int)  ---  helper fxn for removeMin()
     * Returns index of least child, or 
     * -1 if no children, or if input pos is not in ArrayList
     * Postcondition: Tree unchanged
     *****************************************************/
    private int minChildPos( int pos ) 
    {
	if (pos > _heap.size()-1 || pos*2+1 > _heap.size()-1) return -1;
	else if (pos*2+2 > _heap.size()-1) return pos*2+1;
	else if (_heap.get(pos*2+1)>_heap.get(pos*2+2)) return pos*2+1;
	else if (_heap.get(pos*2+1)<_heap.get(pos*2+2)) return pos*2+2;
	return -1;
    }//O(?)



    //************ aux helper fxns ***************
    private Integer minOf( Integer a, Integer b ) 
    {
	if ( a.compareTo(b) < 0 )
	    return a;
	else
	    return b;
    }

    //swap for an ArrayList
    private void swap( int pos1, int pos2 ) 
    {
	_heap.set( pos1, _heap.set( pos2, _heap.get(pos1) ) );	
    }
    //********************************************



    //main method for testing
    public static void main( String[] args ) {

	
	  ALHeap pile = new ALHeap();

	  pile.add(2);
	  System.out.println(pile);
	  pile.add(4);
	  System.out.println(pile);
	  pile.add(6);
	  System.out.println(pile);
	  pile.add(8);
	  System.out.println(pile);
	  pile.add(10);
	  System.out.println(pile);
	  pile.add(1);
	  System.out.println(pile);
	  pile.add(3);
	  System.out.println(pile);
	  pile.add(5);
	  System.out.println(pile);
	  pile.add(7);
	  System.out.println(pile);
	  pile.add(9);
	  System.out.println(pile);

	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);
	  System.out.println("removing " + pile.removeMin() + "...");
	  System.out.println(pile);

	  /*--V--------------MOVE ME DOWN------------------V---
	  ==|============================================|===*/

    }//end main()

}//end class ALHeap
