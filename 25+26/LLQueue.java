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

//import java.util.NoSuchElementException;
//import java.util.RuntimException;

public class LLQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
        
    // default constructor creates an empty queue
    public LLQueue() { 
	_front = new LLNode<T>(null,null);
	_end = new LLNode<T>(null,_front);
    }
    
    // means of adding a thing to the collection
    public void enqueue( T enQVal ) {
	LLNode<T> add = new LLNode<T>(enQVal,_end);
	_end = add;
    }//O(1)
    
    
    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() { 
	LLNode<T> stor = _front;
	LLNode<T> ctr = _end;
	for (int i = 0; i < _size; i++){
	    ctr = ctr.getNext();
	    if (ctr.getNext().equals(_front)) _front = ctr; 
	}
	return stor.getValue();
    }//O(n)


    // means of peeking at thing next in line for removal
    public T peekFront() {
	return _front.getValue();
    }//O(?)


    public boolean isEmpty() {
	return false;
    }//O(?)


    // print each node, separated by spaces
    public String toString() { 
	return "";
    }//O(?)



    public static void main( String[] args ) {

	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
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
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class LLQueue
