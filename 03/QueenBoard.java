/*
  Dorothy Ng
  APCS2 pd10
  HW03 -- Execution
  2016-02-23
 */

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard {

    private int[][] _board;
    
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }

    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
	int col=0;
	for (;col<_board.length;){
	    if (solveH(col)){col++;}
	    else {
		for (int r=0;r<_board.length;r++){
		    if (removeQueen(r,col)) _board[r][col-1]=-1;
		}
	    }
	    //	    System.out.println(this);
	}
	printSolution();
	return true;
    }

    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	int i=0;
	for (;i<_board.length;i++){
	    if (addQueen(i,col)){ 
		_board[i][col]=1;
		return true;}
	}
	return false;
    }


    public void printSolution()
    {
	/** Print board, a la toString...
	        Except:
		    all negs and 0's replaced with underscore
		        all 1's replaced with 'Q'
	*/
	System.out.print(toString());
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * <General description>
     * precondition: queens placed previously are in their correct positions
     * postcondition: returns boolean depending on whether
     * a queen can be placed or not
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;
	    if(row - offset >= 0){
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: queens placed previously are in their correct positions
     * postcondition: returns boolean depending on whether 
     * a queen can be removed or not
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: board is filled and has been solved
     * postcondition: return a string containing information about the board
     */
    public String  toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		//ans += _board[r][c]+"\t";
		if (_board[r][c]==1){
		    ans += "Q\t";}
		else {
		    ans += "_\t";}
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(5);
        /*System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
        System.out.println(b);
	b.removeQueen(3,0);
        System.out.println(b);*/
	b.solve();
    }
    
}//end class