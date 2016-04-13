public class FastSelect {

    int[] arr;

    //constructor
    public FastSelect(int[] in) {
	arr = in;
    }

    //swap elements at two different positions
    public void swap (int pos1, int pos2) {
	int tmp = arr[pos1];
	arr[pos1]=arr[pos2];
	arr[pos2]=tmp;
    }
    
    //partition the array around a pivot
    //return pos of pivot
    public int parti () {
	int right = arr.length-1;
	
	int random = (int)(Math.random() * right);
	
	int pvtVal = arr[random];
	int pvtPos = random;
	swap (pvtPos, right);
	
	int savPos = 0;
	for (int i = 0; i < right-1; i++) {
	    if (arr[i] < pvtVal) {
		swap (savPos,i);
		savPos++;
	    }
	}
	swap (right, savPos);
	return savPos;
    }

    public int Fsel (int k, int lo, int hi) {
	if (lo >= hi) {
	    return arr[k];
	}
	else {
	    int posV = parti();
	    if (posV == k) {return arr[posV];}
	    else {FSel(k,<newlo>,<newhi>);}
	}
    }
    
    public static void main (String[]args) {
	//insert test statements
    }
}
