/*
Dorothy Ng
APCS2 pd10
HW05 -- Knightly Exploration
2016-02-26
*/

//backtracking failed

/*======================================
  class KnightTour
  Animates finding a Knight's Tour of a square chess board.
  
  usage: to find a Knight's Tour on an n*n board, run
  $ java KnightTour [n]
  ======================================*/

// TIP: from a *nix prompt, use
// $ time java KnightTour 5
// to measure execution time of 
// $ java Knight 5


import java.io.*;
import java.util.*;


//class to support KnightTour
class TourFinder {

    //instance vars
    private int[][] _board;
    private int sideLength; //board has dimensions n x n
    private boolean solved = false;
    
    //constructor
    public TourFinder( int n ) {
	
	sideLength = n;
	
	//init 2D array to represent square board with moat
	_board = new int[n+4][n+4];
	
	//SETUP BOARD:
	//  0 on each cell to mark unvisited
	// -1 on each border/buffer cell around edges (moat)
	//---------------------------------------------------------
	for( int i=0; i < n+4; i++ )
	    for( int j=0; j < n+4; j++ )
		_board[i][j] = -1; //lay down initial blanket of -1's
	
	for( int i=2; i < n+2; i++ )
	    for( int j=2; j < n+2; j++ )
		_board[i][j] = 0; //lay down 0's for actual board
	//---------------------------------------------------------
	
    }//end constructor
    
    
    public String toString() {
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	String retStr = "";//";0H";  
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC
	
	int i, j;
	for( i=0; i < sideLength+4; i++ ) {
	    for( j=0; j < sideLength+4; j++ )
		retStr = retStr + String.format( "%3d", _board[j][i] );
	    //"%3d" allots 3 spaces for each number
	    retStr = retStr + "\n";
	}
	return retStr;
    }
    
    
    //helper method to keep try/catch clutter out of main flow
    private void delay( int n ) {
	try {
	    Thread.sleep(n);
	}
	catch( InterruptedException e ) {
	    System.exit(0);
	}
    }
    
    
    /*********************************************
     * void findTour( int x, int y, int moves ) --
     * use depth-first-with-backtracking algo 
     * to find valid knight's tour
     * @param x      starting x-coord
     * @param y      starting y-coord
     * @param moves  number of moves made so far
     *********************************************/
    public void findTour( int x, int y, int moves ) {
	
	//delay(50); //slow it down enough to be followable
	int[] moveX = {1,2,2,1}; //how many units to move when checking nodes
	int[] moveY = {-2,-1,1,2};
	int X=0; //position of next node to move to
	int Y=0;
	
	//if a tour has been completed, stop animation
	if ( solved ) {
	    System.out.println("solved");
	    System.exit(0);
	}	
	//primary base case: tour completed
	if (moves==(sideLength*sideLength)) {
	    solved = true;
	    System.out.println("moves");
	    return;
	}
	
	//other base case: stepped off board or onto visited cell
	/*if (_board[x][y]<0 || _board[x][y]>0) {
	    System.out.println("out");
	    System.out.println(this);
	    System.out.println(_board[x][y]);
	    return;
	    }*/
	//otherwise, mark current location
	//and recursively generate tour possibilities from current pos
	else {
	    
	    //delay(1000); //uncomment to slow down enough to view
	    if (moves==1) { //the first knight is placed
		_board[x][y]=moves;
		moves++;
	    }
	    /*======================================
	      Recursively try to solve (find tour) from 
	      each of knight's available moves.
	      . e . d .
	      f . . . c
	      . . @ . .
	      g . . . b
	      . h . a .
	      ======================================*/
	    for (int ctr=0;ctr<8;ctr++){
		if (ctr<4){//what place to check
		    X = moveX[ctr];
		    Y = moveY[ctr]*-1;}
		else {
		    X = moveX[ctr-4]*-1;
		    Y = moveY[ctr-4];}
		//if invalid placement, ignore and move on
		if (_board[x+X][y+Y]<0 || _board[x+X][y+Y]>0) {}
		//if valid, place knight and move on
		else {
		    _board[x+X][y+Y]=moves;
		    System.out.println( this ); //refresh screen
		    findTour(x+X,y+Y,moves+1);
		    return;}
	    }
	    //If made it this far, path did not lead to tour, so back up.
	    //remove knight at position
	    _board[x][y]=0;
	    //find previous knight
	    for (int iR=0;iR<sideLength;iR++){
		for (int iC=0;iC<sideLength;iC++){
		    if (_board[iR][iC]==moves-1){
			System.out.println( this ); //refresh screen
			//find next possible placement
			findTour(iR,iC,moves-1);
		    }
		}
	    }
	    System.out.println( this ); //refresh screen
	}
    }
}//end class TourFinder


public class KnightTour {
    
    public static void main( String[] args ) {
	
	int n = 8; //default board size
	
	//if command line argument given, set board size accordingly
	try { 
	    n = Integer.parseInt( args[0] );
	} catch( Exception e ) { 
	    System.out.println( "Invalid input. Using board size " 
				+ n + "..." );
	}
	
	TourFinder tf = new TourFinder( n );
	
	//clear screen using ANSI control code
	System.out.println( "" ); 
	
	//display board 
	System.out.println( tf );
	
	//for random starting location, use lines below:
	//int startX = 2 + (int)( n * Math.random() );
	//int startY = 2 + (int)( n * Math.random() );
	//tf.findTour( startX, startY, 1 );   // 1 or 0 ?
	
	//for fixed starting location, use line below:
	tf.findTour( 2, 2, 1 );
	
    }

}//end class KnightTour