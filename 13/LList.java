/*
Dorothy Ng
APCS2 pd10
HW13 -- LoList, LoLit
2016-03-15
*/
/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List { //your List interface must be in same dir

    //instance vars
    private LLNode _start;
    private int _size;

    // constructor -- initializes instance vars
    public LList() {
	_start = null; //at birth, a list has no elements
	_size = 0;
    }
    
    //--------------v  List interface methods  v--------------
    public boolean add(String newVal){ 
	LLNode tmp = new LLNode(newVal, _start);
	_start = tmp;
	_size++;
	return true;
    } 

    public void add(int i, String s){
	LLNode tmp = new LLNode (s,null);
	LLNode target = _start; //node that will point to added node
	LLNode dest = new LLNode (); //node that added node will direct to
	for(int p=0; p < i; p++)
	    target = target.getNext();
	dest = target.getNext();
	target.setNext(tmp);
	tmp.setNext(dest);
    }

    public String remove(int i){
	LLNode rmv = new LLNode (); //removed node
	LLNode tmp = _start; //node that comes before removed node
	for(int p=0; p < i-1; p++)
	    tmp = tmp.getNext();
	rmv = tmp.getNext();
	String value = rmv.getCargo(); //cargo of removed node
	tmp.setNext(rmv.getNext());
	rmv.setNext(null);
	return value;
    }

    public String get(int index){ 
	if (index < 0 || index >= size())
	    throw new IndexOutOfBoundsException();
	String retVal;
	LLNode tmp = _start; //create alias to head
	//walk to desired node
	for(int i=0; i < index; i++)
	    tmp = tmp.getNext();
	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    } 

    public String set(int index, String newVal){ 
	if (index < 0 || index >= size())
	    throw new IndexOutOfBoundsException();
	LLNode tmp = _start; //create alias to head
	//walk to desired node
	for(int i=0; i < index; i++)
	    tmp = tmp.getNext();
	//store target node's cargo
	String oldVal = tmp.getCargo();
	//modify target node's cargo
	tmp.setCargo(newVal);
	return oldVal;
    } 

    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------

    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	LLNode tmp = _start; //init tr
	while(tmp != null){
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main(String[] args){
	//("s m a v k")
	LList skye = new LList();
	skye.add("k");
	System.out.println(skye);
	skye.add("v");
	System.out.println(skye);
	skye.add("a");
	System.out.println(skye);
	skye.add("m");
	System.out.println(skye);
	skye.add("s");
	System.out.println(skye);
	System.out.print("~~~~~~~~~~\n");
	//("y m a v k")
	skye.set(0,"y");
	System.out.println(skye);
	skye.set(1,"n");
	System.out.println(skye);
	skye.set(3,"m");
	System.out.println(skye);
	System.out.print("~~~~~~~~~~\n");
	//("y m a bird v k")
	skye.add(3,"bird");
	System.out.println(skye);
	skye.remove(5);
	System.out.println(skye);
    }
    
}//end class LList



