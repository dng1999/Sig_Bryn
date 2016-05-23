/*****************************************************
 * interface Queue
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 ******************************************************/


public interface Queue<T> {

    //remove from front
    public T remove();

    //add to last
    public void add( T x );

    //check for existence
    public boolean contains (T x);

    //check for nodes present
    public boolean isEmpty();

    //show what's at the front
    public T peek();
    
}//end interface Queue      