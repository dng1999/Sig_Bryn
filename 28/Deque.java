/*
  Dorothy Ng
  APCS2 pd10
  HW28 -- All Hands on Deque!
  2016-04-07
 */

/**********
I added contains (T x) to Queue, but other than that,
I didn't see any particular reason I needed to change Queue,
besides changing the method names.
**********/
import java.util.NoSuchElementException;

public class Deque <T> implements Queue<T> {
    
    private DLLNode<T> _front, _end;
    private int _size;
    
    //default constructor
    public Deque() { 
	_front = null;
	_end = _front;
	_size = 0;
    }//O(1)
    
    //add to the end
    public void add( T val ) 
    {
	if ( isEmpty() ) {
	    _front = new DLLNode<T>( val, null, null );
	    _end = _front;
	}
	else {
	    _end.setNext( new DLLNode<T>( val, _end, null ) );
	    _end = _end.getNext();
	}
	_size++;
    }//O(1)

    //remove the first node
    public T remove() 
    { 
	if (_front == null )
	    throw new NoSuchElementException("Empty Deque");
	T val = _front.getValue();
	_front = _front.getNext();
	if ( _front == null ) { }
	else _front.setPrev(null);
	
	_size--;

	return val;
    }//O(1)
    
    //return value of first node
    public T peek() 
    {
	return _front.getValue();
    }//O(1)
    
    //check for existence of node
    public boolean contains ( T x ) {
	DLLNode<T> ctr = _front;
	for (int i=0;i<_size;i++){
	    if (ctr.getValue().equals(x)) return true;
	    ctr = ctr.getNext();
	}
	return false;
    }//O(n)

    //returns true if queue is empty
    public boolean isEmpty() { return _front == null; }//O(1)
    
    //returns size of queue
    public int size() { return _size; }//O(1)

    public String toString() 
    { 
	String ret = "";
	DLLNode<T> ctr = _front;
	while ( ctr != null ) {
	    ret += ctr.getValue() + " ";
	    ctr = ctr.getNext();
	}
	return ret;
    }

    //main method for testing
    public static void main( String[] args ) {

	Queue<String> PirateQueue = new Deque<String>();

	System.out.println("\nnow enqueuing..."); 
	PirateQueue.add("Dread");
	PirateQueue.add("Pirate");
	PirateQueue.add("Robert");
	PirateQueue.add("Blackbeard");
	PirateQueue.add("Peter");
	PirateQueue.add("Stuyvesant");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( PirateQueue ); //for testing toString()...

	System.out.println("\nnow dequeuing..."); 
	System.out.println( PirateQueue.remove() );
	System.out.println( PirateQueue.remove() );
	System.out.println( PirateQueue.remove() );
	System.out.println( PirateQueue.remove() );
	System.out.println( PirateQueue.remove() );
	System.out.println( PirateQueue.remove() );

	System.out.println("\nnow dequeuing fr empty queue..."); 
	System.out.println( PirateQueue.remove() );

    }//end main
}