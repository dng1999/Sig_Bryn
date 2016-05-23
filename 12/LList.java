/*
Dorothy Ng
APCS2 pd10
HW12b -- Truckin' Through the Night
2016-03-14
*/

//LList
//implements List interface
public class LList implements List {
    
    private LLNode nodeS; //start of linked list
    private LLNode nodeE; //end of linked list
    //link a node to the first element of a linked list
    
    public LList (){
	nodeS = new LLNode();
	nodeE = new LLNode();
    }

    public boolean add (String x){
	LLNode tmp = new LLNode();
	tmp.set(x);
	tmp.setNext(nodeS);
	nodeS = tmp;
	return true;
    }
    //return val of the ith node
    public String get (int i){
	LLNode tmp = nodeS;
	for (int p=0;p<i;p++){
	    tmp = tmp.getNext();
	}
	return tmp.get();
    }
    //set val of the ith node
    public String set (int i, String x){
	LLNode tmp = nodeS;
	for (int p=0;p<i;p++){
	    tmp = tmp.getNext();
	}
	tmp.set(x);
	return tmp.get();
    }
    //return size of node
    public int size (){
	int ctr=1; //bc you already count first node
	LLNode trk = nodeS;
	while (trk.get() != nodeE.get() && trk.getNext() != nodeE.getNext()){
	    trk = trk.getNext();
	    ctr++;
	}
	return ctr;
    }

    //TEST
    /*
    public static void main (String[]args){
	//("s m a v k")
	LList skye = new LList();
	skye.set(0,"k");
	skye.add("v");
	skye.add("a");
	skye.add("m");
	skye.add("s");
	//System.out.print(skye.size());
	for (int i=0;i<skye.size();i++){
	    System.out.print(skye.get(i));}
	System.out.print("\n~~~~~~~~~~\n");
	//("y m a v k")
	skye.set(0,"y");
	for (int i=0;i<skye.size();i++){
	    System.out.print(skye.get(i));}
	System.out.print("\n");
	}*/
}
