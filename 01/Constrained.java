/*
  Dorothy Ng
  APCS2 pd10
  HW01 -- I Am Still Searching
  2016-02-11
*/
public class Constrained {

    //PART 1
    /*
      For an nxn in matrix, where numbers 
      increase across any row 
      and down any column...
      
      Compose an O(n) search fxn.
    */
    public static boolean searchMatrix(int[][] array, int target){
	int r=0;
	int c=0;
	if (array[0][0]>target || array[array.length-1][array.length-1]<target) return false;
	while (r<array.length  && c<array.length){
	    if (array[r][c]==target) return true;
	    else if (array[r][c+1]>target){
		r++;
		c=0;
	    }
	    else if (array[r+1][c]>target){
		c++;
		r=0;
	    }
	    else return true;
	}
	return false;
    }

    //PART 2
    /*
      For an array of integers 1 to n...
      If 1 num duplicated & 1 num missing,
      
      Compose a function to find the missing number in linear[O(n)] run time
    */
    public static int findMissing(int[]array){
	int tSum=0;
	int aSum=0;
	int tProd=1;
	int aProd=1;
	for (int i=0;i<array.length;i++){
	    aSum+=array[i];
	    tSum+=i+1;
	    aProd*=array[i];
	    tProd*=(i+1);
	}
	int dupe = (int)((tSum-aSum)/(((tProd*1.0)/aProd)-1)); 
	if (aSum>tSum) return dupe-(aSum-tSum);
	else return dupe+(tSum-aSum);
    }

    public static void main(String[]args){
	int[][]array=new int[][]{{1,3,5},{3,7,8},{5,12,15}};
	System.out.println("1:"+searchMatrix(array,1));
	System.out.println("3:"+searchMatrix(array,3));
	System.out.println("7:"+searchMatrix(array,7));
	System.out.println("15:"+searchMatrix(array,15));
	System.out.println("20:"+searchMatrix(array,20));

	System.out.println("--------------------------");
	System.out.println("4,1,3,1:"+findMissing(new int[]{4,1,3,1}));
	System.out.println("2,2,4,1:"+findMissing(new int[]{2,2,4,1}));
	System.out.println("3,2,2,4:"+findMissing(new int[]{3,2,2,4}));
    }
}