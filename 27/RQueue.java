/*
Dorothy Ng
APCS2 pd10
HW27 -- Now Let's COnsider You Lot at Fake Terry's
2016-04-05
 */

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linked list points opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/
import java.util.NoSuchElementException;

public class RQueue<T> implements Queue<T> {

    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() { 
	_front = null;
	_end = null;
    }//end default constructor
    
    
    public void enqueue( T enQVal ) {
	if (_front == null){
	    _end = new LLNode<T>(enQVal,_end);
	    _front = _end;
	}
	else {
	    LLNode<T> neo = new LLNode<T>(enQVal,null);
	    _end.setNext(neo);
	    _end = neo;
	}
	_size++;
    }//end enqueue()

    
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() { 
	sample();
	T tmp = _front.getValue();
	_front = _front.getNext();
	_size--;
	return tmp;
    }//end dequeue()
    
    
    public T peekFront() {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * 1. Choose a random LLNode to move.
     * 2. Move it to the end.
     * 3. Continue until you've shuffled _size times.
     ******************************************/
    public void sample () {
	if (_size == 0) {
	    throw new NoSuchElementException();
	}
	else if (_size == 1) {return ;}
	LLNode<T> pt = _front;
	for (int i=0;i<_size;i++){
	    int rand = (int)(Math.random() * (_size));
	    for (int f=0;f<rand;f++){
		pt = pt.getNext();
	    }
	    LLNode<T> neu = new LLNode<T>(pt.getNext().getValue(),null);
	    pt.setNext(pt.getNext().getNext());
	    _end.setNext(neu);
	    _end = pt.getNext();
	}
    }//end sample()
    

    public boolean isEmpty() {
	return _size == 0;
    } //O(?)


    // print each node, separated by spaces
    public String toString() { 
	String ret = "";
	LLNode<T> ctr = _front;
	for (int i=0;i<_size;i++){
	    ret += ctr.getValue() + " ";
	    ctr = ctr.getNext();
	}
	return ret;
    }//end toString()



    //main method for testing
    public static void main( String[] args ) {


	Queue<String> PirateQueue = new RQueue<String>();

	System.out.println("\nnow enqueuing..."); 
	PirateQueue.enqueue("Dread");
	PirateQueue.enqueue("Pirate");
	PirateQueue.enqueue("Robert");
	PirateQueue.enqueue("Blackbeard");
	PirateQueue.enqueue("Peter");
	PirateQueue.enqueue("Stuyvesant");

	System.out.println("\nnow testing toString()..."); 
	System.out.println( PirateQueue ); //for testing toString()...

	System.out.println("\nnow dequeuing..."); 
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );
	System.out.println( PirateQueue.dequeue() );

	System.out.println("\nnow dequeuing fr empty queue..."); 
	System.out.println( PirateQueue.dequeue() );
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

	^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class RQueue
