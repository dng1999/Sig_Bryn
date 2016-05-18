/* Dorothy Ng
   APCS2 pd10
   HW39 -- Neighbourhood Disposal
   2016-05-17
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
    
    /*****************************************************
     * default constructor
     *****************************************************/
    public BST( ) {
	root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public TreeNode insert(int newVal, TreeNode a){
	if (a == null){
	    a = new TreeNode(newVal);
	}
	else if (a.getValue() > newVal){
	    a.setLeft(insert(newVal, a.getLeft()));
	}
	else if (a.getValue() < newVal){
	    a.setRight(insert(newVal, a.getRight()));
	}
	return a;
    }
    
    public void insert( int newVal ) {
     	root = insert(newVal, root);
    }

    /*****************************************************
     * void remove( int ) 
     * Removes a data element while keeping BST conventions.
     *****************************************************/
    public void remove(int val){
	remove(root, val);
    }

    public void remove(TreeNode a,int val){
	TreeNode b = search(a, val);
	if (a.getLeft() == null && a.getRight() == null){
	    rm0(a);
	}
	if (a.getLeft() != null && a.getRight() != null){
	    rm2(a);
	}
	else {
	    rm1(a);
	}
    }

    public TreeNode searchL(TreeNode a, TreeNode tar){
	if (a.getLeft() == null) return null;
	if (a.getLeft().getValue() == tar.getValue()) return a;
	else if (a.getLeft() != null) searchL(a.getLeft(),tar);
	return null;
    }

    public TreeNode searchR(TreeNode a, TreeNode tar){
	if (a.getRight() == null) return null;
	if (a.getRight().getValue() == tar.getValue()) return a;
	else if (a.getRight() != null) searchR(a.getRight(),tar);
	return null;
    }

    public void rm0(TreeNode a){
	TreeNode b = searchL(root,a);
	TreeNode c;
	if (b!=null) b.setLeft(null);
	else if (b==null){
	    b=searchR(root,a);
	    c=new TreeNode(b.getValue());
	    b=c;
	}
    }
    
    public TreeNode search(TreeNode a, int val){
	if (a.getValue() == val) return a;
        if (a.getLeft() != null) search(a.getLeft(),val);
	if (a.getRight() != null) search(a.getRight(),val);
	return null;
    }
    
    public void rm1(TreeNode a){
	if (a.getLeft() != null){
	    TreeNode b = a.getLeft();
	    a.setValue(b.getValue());
	    remove(a.getLeft(),b.getValue());
	}
	if (a.getRight() != null){
	    TreeNode b = a.getRight();
	    a.setValue(b.getValue());
            remove(a.getRight(),b.getValue());
	}
    }

    public TreeNode searchMax(TreeNode a){
	if (a.getRight() != null) searchMax(a.getRight());
	return a;	
    }
    
    public void rm2(TreeNode a){
	TreeNode b = searchMax(root.getLeft());
	a.setValue(b.getValue());
	remove(a.getLeft(),b.getValue());
    }

    public int height(TreeNode a){
	if (a==null) return 0;
	if (a.getLeft() == null && a.getRight() == null) return 1;
	int hL = height(a.getLeft());
	int hR = height(a.getRight());
	if (hL>hR) return 1+hL;
	else return 1+hR;
    }
    
    public int height(){
	return height(root);
    }

    public int numLeaves(TreeNode a){
	if (a==null) return 0;
	if (a.getLeft() == null && a.getRight() == null) return 1;
	return numLeaves(a.getLeft()) + numLeaves(a.getRight());
    }

    public int numLeaves(){
	return numLeaves(root);
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
	
	System.out.print("PRE-TEST TRAVERSELS\nPre: ");
	arbol.preOrderTrav();
	System.out.print("In: ");
	arbol.inOrderTrav();

	arbol.remove(1); //leaf test case
	System.out.print("AFTER REMOVING LEAF OF VAL 1\nPre: ");
	arbol.preOrderTrav();
	System.out.print("In: ");
	arbol.inOrderTrav();

	arbol.remove(2); //one child test case
	System.out.print("AFTER REMOVING NODE OF VAL 2\nPre: ");
	arbol.preOrderTrav();
	System.out.print("In: ");
	arbol.inOrderTrav();

	arbol.remove(4); //root test case
	System.out.print("AFTER REMOVING ROOT (OF VAL 4)\nPre: ");
	arbol.preOrderTrav();
	System.out.print("In: ");
	arbol.inOrderTrav();
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class





    
