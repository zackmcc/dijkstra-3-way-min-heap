/* Zackary McClamma
 * CPS 530
 * Assignment 3
 * 27 July 2020 
 * Disclaimer - This code was taken directly from the assignemnt on Isidore. I did
 * add a print function to facilitate console output but the rest of this
 * interface was untouched. */

/**
 * Base interface for priority queue implementations. Throw
 * exceptions as appropriate.
 */
public interface McClamma_as3_PriorityQueue<Key, Value> {
    /**
     * Returns true if priority queue has no elements
     * 
     * @return true if the priority queue has no elements
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this priority queue.
     * 
     * @return the number of elements in this priority queue.
     */
    public int size();

    /**
     * Returns the minimum Key in the priority queue
     * 
     * @return the minimum Key
     * @throws McClamma_as3_EmptyPQException
     *             if priority queue contains no elements
     */
    public Key findMin();

    /**
     * Inserts a new <key, val> pair into the priority queue. 
     * Duplicate keys ARE allowed.
     * @param x
     *            <key, val> to be inserted into the priority queue.
     */
    void insert(Key key, Value val);


    /**
     * Removes the pair with the minimum key from the priority queue 
     * and returns its value
     * @return the value of the pair that has the minimum key
     * @throws McClamma_as3_EmptyPQException
     *             if priority queue contains no elements
     */
    public Value deleteMin();

    /**
     * Resets the priority queue to appear as not containing any elements.
     */
    public void makeEmpty();
    
    /*
     * Prints the key value pairs in an array
     * */
    public void print();



	

}
