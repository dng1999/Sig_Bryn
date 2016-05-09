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

public class BST {

    //instance variables / attributes of a BST:
    TreeNode _first;

    /*****************************************************
     * default constructor
     *****************************************************/
    public BST( ) {
	_first = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) {
     	if (_first == null) {
	    _first = new TreeNode(newVal);
	}
	else  {
	    /*insert food here*/
	}
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav(TreeNode a){
	System.out.print(a.getValue+" ");
	if (a.getLeft() != null) {
	    preOrderTrav(a.getLeft());
	}
	else if (a.getRight() != null) {
	    preOrderTrav(a.getRight());
	}
	else {
	    return;
	}
    } 

    public void preOrderTrav() 
    {
	preOrderTrav(_first);
    }

    public void inOrderTrav() 
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
    }

    public void postOrderTrav() 
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) {

	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	BST arbol = new BST();

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
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class





    
