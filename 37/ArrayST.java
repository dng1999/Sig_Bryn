/* Dorothy Ng
   APCS2 pd10
   HW37 -- Algorithm as Data Structure
   2016-05-11
 */

/*****************************************************
 * class BST - skeleton
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class ArrayST {

    //instance variables / attributes of a ArrayST:
    int[] tree;
    int height;

    /*****************************************************
     * default constructor
     *****************************************************/
    public ArrayST( ) {
	tree = new int[0];
	height = 0;
    }

    public void expand(){
	height++;
	int[]b = new int[(int)(Math.pow(2,height) - 1)];
	for (int i=0;i<b.length;i++){
	    if (i<tree.length) b[i] = tree[i];
	    else b[i] = -1;
	}
	tree = b;
    }

    public boolean isFull(){
	for (int i=0;i<tree.length;i++){
	    if (tree[i] == -1) return false; 
	}
	return true;
    }

    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert(int newVal, int index){
	if (isFull()) expand();
	if (tree[index]==-1) tree[index]=newVal;
	else if (tree[index] < newVal){
	    insert(newVal, index*2+1);
	}
	else if (tree[index] > newVal){
	    insert(newVal, (index+1)*2);
	}
	return;
    }

    public void insert( int newVal ) {
	insert(newVal, 0);
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav(int a){
	if (a <tree.length && tree[a] != -1){
	    System.out.print(tree[a]+" ");
	    preOrderTrav(a*2+1);
	    preOrderTrav((a+1)*2);
	}
    }
    
    public void preOrderTrav() 
    {
	preOrderTrav(0);
    }
    
    public void inOrderTrav(int a){
	if (a <tree.length && tree[a] != -1){
	    inOrderTrav(a*2+1);
	    System.out.print(tree[a]+" ");
	    inOrderTrav((a+1)*2);
	}
    }
    
    public void inOrderTrav() {
	inOrderTrav(0);
    }
    
    public void postOrderTrav(int a){
	if (a <tree.length && tree[a] != -1){
            postOrderTrav(a*2+1);
	    postOrderTrav((a+1)*2);
	    System.out.print(tree[a]+" ");
	}
    }
	
    public void postOrderTrav() 
    {
	postOrderTrav(0);
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) {

	ArrayST arbol = new ArrayST();

	arbol.insert( 4 );
	arbol.insert( 2 );
	arbol.insert( 5 );
	arbol.insert( 6 );
	arbol.insert( 1 );
	arbol.insert( 3 );

	System.out.println( "\npre-order traversal:" );
	arbol.preOrderTrav();

	System.out.println( "\nin-order traversal:" );
	arbol.inOrderTrav();
	
	System.out.println( "\npost-order traversal:" );
	arbol.postOrderTrav();	
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class





    
