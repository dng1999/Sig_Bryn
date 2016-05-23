/*
Dorothy Ng
APCS2 pd10
HW12a -- We Got a Big Ol' Convoy
2016-03-14
*/

//LLNode
//specifies what a node has and can do
public class LLNode {
    
    private String value; //car
    private LLNode next; //cdr
    //default
    public LLNode (){
	value = "";
	next = null;
    }
    //return val of node
    public String get (){
	return value;
    } 
    //set val of node
    public void set (String x){
	value = x;
    }
    //return the val of the next node
    public LLNode getNext (){
	return next;
    }
    //set the val of the next node
    public void setNext (LLNode n){
	next = n;
    }
}
