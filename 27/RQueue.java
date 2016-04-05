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
	    _front = new LLNode<T>(enQVal,_end);
	    _end = new LLNode<T>(enQVal,null);
	}
	else {
	    LLNode<T> neo = new LLNode<T>(enQVal,null);
	    _end.setNext(neo);
	    _end = neo;
	}
    }//end enqueue()


    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() { 
	return null;
    }//end dequeue()


    public T peekFront() {
	return null;
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * Algo:
     * 1. Create a new RQueue (will be referred to as 'neu'). It will be empty.
     * 2. Randomly choose from
    ******************************************/
    public void sample () {

    }//end sample()


    public boolean isEmpty() {
	return false;
    } //O(?)


    // print each node, separated by spaces
    public String toString() { 
	return "";
    }//end toString()



    //main method for testing
    public static void main( String[] args ) {

	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v

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

	^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

    }//end main

}//end class RQueue
