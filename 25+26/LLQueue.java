/*
Dorothy Ng
APCS2 pd10
HW25 -- Brits Do Not Wait In Line
2016-04-04
 */
/*****************************************************
 * class LLQueue
 * uses a linked list to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

import java.util.NoSuchElementException;
import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
    int _size;
        
    // default constructor creates an empty queue
    public LLQueue() { 
	_front = new LLNode<T>(null,null);
	_end = new LLNode<T>(null,_front);
	_size = 0;
    }
    
    // means of adding a thing to the collection
    public void enqueue( T enQVal ) {
	if (_size == 0) {
	    LLNode<T> tmp = new LLNode(enQVal,null);
	    _front = tmp;
	    _end = tmp;
	}
	else {
	    LLNode<T> tmp = new LLNode(enQVal,_end);
	    _end = tmp;
	}
	_size++;
    }//O(1)
    
    
    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() { 
	if (isEmpty()) {
	    throw new NoSuchElementException("Empty");
	}
	LLNode<T> curr = _end;
	for (int i=0;i<_size;i++){
	    if (i==_size-1){
		_front = curr;
		_front.setNext(null);
	    }
	    else {curr = curr.getNext();}
	}
	_size--;
	T stor = _front.getValue();
	return stor;
    }//O(n)


    // means of peeking at thing next in line for removal
    public T peekFront() {
	return _front.getValue();
    }//O(1)


    public boolean isEmpty() {
	return _size == 0;
    }//O(1)


    // print each node, separated by spaces
    public String toString() { 
	String ret = "";
	LLNode<T> curr = _end;
	for (int i=0;i<_size;i++){
	    ret += curr.getValue()+" ";
	    curr = curr.getNext();
	}
	return ret;
    }//O(n)



    public static void main( String[] args ) {

	Queue<String> LLQueuelJ = new LLQueue<String>();

	System.out.println("\nnow enqueuing thrice..."); 
	LLQueuelJ.enqueue("James");
	LLQueuelJ.enqueue("Todd");
	LLQueuelJ.enqueue("Smith");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( LLQueuelJ ); //for testing toString()...

	System.out.println("\nnow dequeuing thrice..."); 
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );
	System.out.println( LLQueuelJ.dequeue() );

	System.out.println("\nDequeuing from empty queue should yield error..."); 
	System.out.println( LLQueuelJ.dequeue() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class LLQueue
