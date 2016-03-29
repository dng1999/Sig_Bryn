/*
Dorothy Ng
APCS2 pd10
HW19 -- 
2016-03-28
 */
/*****************************************************
 * skeleton for class CLList 
 * implements a circularly-linked list of doubly-linked nodes
 ******************************************************/

public class CLList<T> {

    // only 1 head/tail/front/end pointer is necessary,
    // since the list is circularly-linked
    private DLLNode<T> _head;
    private int _size = 0;

    public CLList() {
	_head = null;
    }

    //returns size of c-linked list
    public int size() { return _size; }
    
    //adds node to end of c-linked list
    public boolean add( T x ) {
	if (_size == 0) {
	    _head = new DLLNode(x,null,null);
	    _head.setPrev(_head);
	    _head.setNext(_head);
	}
	else if (_size == 1){
	    DLLNode<T> tmp = new DLLNode(x,_head,_head);
	    _head.setPrev(tmp);
	    _head.setNext(tmp);
	}
	else {
	    DLLNode<T> tmp = new DLLNode(x,_head.getPrev(),_head);
	    _head.getPrev().setNext(tmp);
	    _head.setPrev(tmp);
	}
	_size++;
	return true;
    }
    
    //returns value of node at index
    public T get( int index ) {
	DLLNode<T> tmp = _head;
	for (int i=0;i<index;i++){
	    tmp = tmp.getNext();
	}
	return tmp.getCargo();
    }

    //replaces value of node at index
    //returns replaced value
    public T set( int index, T newVal ) {
	DLLNode<T> tmp = _head;	
	for (int i=0;i<index;i++){
	    tmp = tmp.getNext();
	}
	T hold = tmp.getCargo();
	tmp.setCargo(newVal);
	return hold;
    }

    //returns String of c-linked list
    public String toString() {
	String ret = _head.getCargo()+" -> ";
	DLLNode<T> tmp = _head.getNext();
	while (tmp != _head){
	    ret += tmp.getCargo()+" -> ";
	    tmp = tmp.getNext();
	}
	ret += "NULL";
	return ret;
    }


    public static void main( String[] args ) {

	CLList<String> liz = new CLList<String>();

	liz.add("kenneth");
	liz.add("jack");
	liz.add("tracy");

	System.out.println(liz);

	System.out.println("\ntesting get()...");
	for( int i = 0; i < liz._size; i++ ) {
	    System.out.println("node " + i + " contains " + liz.get(i) );
	    System.out.println(liz);
	}

	System.out.println("\ntesting set()...");
	for( int i = 0; i < liz._size; i++ ) {
	    System.out.println( liz.set( i, "rock"+i ) );
	    System.out.println(liz);
	}

    }//end main

}//end class CLList
