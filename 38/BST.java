/* Dorothy Ng
   APCS2 pd10
   HW36 -- Algorithm as Data Structure
   2016-05-09
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

public class BST {

    //instance variables / attributes of a BST:
    private TreeNode root;
    private int height;

    /*****************************************************
     * default constructor
     *****************************************************/
    public BST( ) {
	root = null;
	height = 0;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public TreeNode insert(int newVal, TreeNode a){
	if (a == null){
	    a = new TreeNode(newVal);
	}
	else if (a.getValue() < newVal){
	    a.setLeft(insert(newVal, a.getLeft()));
	}
	else if (a.getValue() > newVal){
	    a.setRight(insert(newVal, a.getRight()));
	}
	return a;
    }

    public void insert( int newVal ) {
     	root = insert(newVal, root);
	height++;
    }

    public int height(){
	return height;
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav(TreeNode a){
	System.out.print(a.getValue()+" ");
	if (a.getLeft() != null) preOrderTrav(a.getLeft());
	if (a.getRight() != null) preOrderTrav(a.getRight());
    }
    
    public void preOrderTrav() 
    {
	preOrderTrav(root);
    }
    
    public void inOrderTrav(TreeNode a){
	if (a.getLeft() != null) inOrderTrav(a.getLeft());
	System.out.print(a.getValue()+" ");
	if (a.getRight() != null) inOrderTrav(a.getRight());
    }
    
    public void inOrderTrav() {
	inOrderTrav(root);
    }
    
    public void postOrderTrav(TreeNode a){
	if (a.getLeft() != null) postOrderTrav(a.getLeft());
	if (a.getRight() != null) postOrderTrav(a.getRight());
	System.out.print(a.getValue()+" ");
    }
	
    public void postOrderTrav() 
    {
	postOrderTrav(root);
    }
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) {

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
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class





    
