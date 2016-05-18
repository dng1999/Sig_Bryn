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
	root = remove(root, val);
    }

    public TreeNode remove(TreeNode a,int val){
	//search
	if (a == null) return a;
	else if (a.getValue() > val) remove(a.getLeft(),val);
	else if (a.getValue() < val) remove(a.getRight(),val);
	//now assuming a is the TreeNode with val
	//two
	else if (a.getLeft() != null && a.getRight() != null){
	    a.setValue(sMax(a.getLeft()).getValue());
	    a.setLeft(remove(a.getRight(),a.getValue()));
	}
	//zero
	else if (a.getLeft() == null && a.getRight() == null){
	    a.setValue(-1);
	    copy(root);
	}
	//one
	else {
	    if (a.getLeft() != null) {
		a.setValue(sMax(a.getLeft()).getValue());
		a.setLeft(remove(a.getRight(),a.getValue()));
	    }
	    else {
		a.setValue(sMin(a.getRight()).getValue());
		a.setRight(remove(a.getLeft(),a.getValue()));
	    }
	}
	return a;
    }

    public void copy(TreeNode a){
	int[] vals = new int[(int)(Math.pow(2,height(root)))];
	int ctr = 0;
	this.root = copy(a,vals,0);
    }

    public TreeNode copy(TreeNode a, int[] vals, int ctr){
	vals[ctr] = a.getValue();
        if (a.getLeft() != null)
	    copy(a.getLeft(),vals,ctr++);
        else if (a.getRight() != null)
	    copy(a.getRight(),vals,ctr++);
	BST cp = new BST();
	for (int i = 0;i<=ctr;i++){
	    if (vals[i] != -1) cp.insert(vals[i]);
	}
	return cp.getRoot();
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
    
    public TreeNode search(int val){
	return search(root,val);
    }
    
    public TreeNode search(TreeNode a, int val){
	if (a.getValue() == val) return a;
        if (a.getLeft() != null) search(a.getLeft(),val);
	if (a.getRight() != null) search(a.getRight(),val);
	return null;
    }

    public TreeNode sMax(TreeNode a){
	if (a.getRight() != null) sMax(a.getRight());
	return a;
    }

    public TreeNode sMin(TreeNode a){
	if (a.getLeft() != null) sMin(a.getLeft());
	return a;
    }

    public TreeNode getRoot(){
	return root;
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
	System.out.print("\nIn: ");
	arbol.inOrderTrav();

	arbol.remove(1); //leaf test case
	System.out.print("\nAFTER REMOVING LEAF OF VAL 1\nPre: ");
	arbol.preOrderTrav();
	System.out.print("\nIn: ");
	arbol.inOrderTrav();

	arbol.remove(2); //one child test case
	System.out.print("\nAFTER REMOVING NODE OF VAL 2\nPre: ");
	arbol.preOrderTrav();
	System.out.print("\nIn: ");
	arbol.inOrderTrav();

	arbol.remove(4); //root test case
	System.out.print("\nAFTER REMOVING ROOT (OF VAL 4)\nPre: ");
	arbol.preOrderTrav();
	System.out.print("\nIn: ");
	arbol.inOrderTrav();
	System.out.println();
	/*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }

}//end class





    
