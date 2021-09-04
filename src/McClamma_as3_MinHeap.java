/* Zackary McClamma
 * CPS 530
 * Assignment 3
 * 27 July 2020 
 * Disclaimer - Some of this code was based on the sample code in the lecture notes
 *              and off of what was discussed in the Q&A session.*/

public class McClamma_as3_MinHeap<Key extends Comparable<Key>, Value> implements McClamma_as3_PriorityQueue<Key, Value>{

	private static final int DEFAULT_CAPACITY = 10;
	private int N; // number of elements in BH
	private Key[] keys;
	private Value[] vals;
	
	/* Constructs a new MinHeap object with the default capacity
	 * Inputs - none
	 * Outputs - none */
	McClamma_as3_MinHeap(){
		N = 0;
		keys = (Key[]) new Comparable[DEFAULT_CAPACITY + 1];
		vals = (Value[]) new Comparable[DEFAULT_CAPACITY + 1];
	}
	
	/* Constructs a new MinHeap with the capacity given
	 * Inputs - newSize = size of the new heap
	 * Outputs - none */
	McClamma_as3_MinHeap(int newSize){
		N = 0;
		keys = (Key[]) new Comparable[newSize + 1];
		vals = (Value[]) new Comparable[newSize + 1];
	}
	
	/* Resizes the tree based on the value of newSize
	 * Inputs - int newSize = desired length of the new keys and values arrays
	 * Outputs - void */ 
	private void resize(int newSize) {
		//Declare local variables to store old keys and values
		Key [] oldKeys;
		Value [] oldValues;
		
		// If the newSize given is 0 this will throw an error
		if (newSize <= 0)
		{
			throw new McClamma_as3_EmptyPQException("Cannot create Priority Queue of size less than or equal to 0");
		}
		// If the input is equal to N
		else if(newSize == N)
		{
			System.out.println("No resizing necessary current size is equal to newSize");
			return;
		}
		//If the input is valid initialize the local variables
		// and reset the original arrays to the newSize
		else
		{
			oldKeys = keys;
			oldValues = vals;
			keys = (Key[]) new Comparable[newSize];
			vals = (Value[]) new Comparable[newSize];
		}
		
		// If the new size is greater than the previous size
		if (newSize > N)
		{
			for	(int i = 0; i < oldKeys.length; i++) {
				keys[i] = oldKeys[i];
				vals[i] = oldValues[i];
			}
			oldKeys = null;
			oldValues = null;
		}
		
		/* If the newSize is less than the original 
		 * since it is a PriorityQueue the nodes
		 * removed start from the top removing the
		 * smallest values. I was not sure if I should
		 * remove the smallest or largest values when
		 * resizing but since the top is where things
		 * are deleted from when running the delete
		 * function I assumed that this would be the proper
		 * way to resize the array if the given value is 
		 * smaller than the current size.*/
		if (newSize < N)
		{
			int diff = N - newSize;
			int newN = 0;
			for (int i = 0; i < newSize - 1; i++)
			{
				keys[i] = oldKeys[i + diff];
				vals[i] = oldValues[i + diff];
				newN = i;
			}
			N = newN;
		}
		
		
	}
	
	/* Returns the minimum value in the tree, if the tree is empty this
	 * method will throw an error*/
	@Override
	public Key findMin() {
		// TODO Auto-generated method stub
		if(N ==0)
				throw new McClamma_as3_EmptyPQException("Empty Priority Queue");
		else
			return keys[1];
	}

	/* Inserts a new node into the tree
	 * Inputs - key = key value of the key value pair for the new node
	 * 			value = value of the key value pair for the new node
	 * Outputs - void */
	public void insert(Key key, Value val){
		// TODO Auto-generated method stub
		if (N == keys.length - 1) {
			resize((keys.length * 2) + 1);
			resize((vals.length * 2) + 1);
		}
		
		keys[++N] = key;
		vals[N] = val;
		percolateUp(N);
	}

	/* Compares the given node and will push the node up
	 * the tree if it is smaller than its parent node.
	 * Inputs - i = node to be pushed
	 * Outputs - void */
	private void percolateUp(int i) {
		while (i > 1 && less(i, (i+1)/3)) {
			exchange(i, (i+1)/3);
			i = (i+1)/3;
		}
	}
	
	/* takes the index value of two nodes and swaps
	 * their places in the tree
	 * Inputs - i = index of child node to be switched
	 *          parent = index of parent node to be switched
	 * Outputs - void */
	private void exchange(int i, int parent) {
		Key tempKey = keys[i];
		Value tempVal = vals[i];
		
		keys[i] = keys[parent];
		keys[parent] = tempKey;
		
		vals[i] = vals[parent];
		vals[parent] = tempVal;
 	}
	
	/* Returns true if i is less than j, otherwise returns false
	 * Inputs - i = first value to be compared
	 * 			j = second value to be compared
	 * Outputs - true or false */
	private boolean less(int i, int j) {
		return keys[i].compareTo(keys[j]) < 0;
	}
	
	/* Deletes the minimum value in the tree and restructures
	 * the tree so that the new lowest value is moved up to the
	 * newly vacant spot.
	 * Inputs - none
	 * Output - Value of the deleted node */
	@Override
	public Value deleteMin() {
		Value oldVal = vals[1];
		keys[1] = null;
		vals[1] = null;
		
		for (int i = 0; i < N; i++)
		{
			//tested against null to move 'deleted' value into unused 0 index
			if (keys[i] == null || keys[i].compareTo(keys[i+1]) < 0)
				exchange(i, i + 1);
			percolateUp(i);
		}
		N--;
		return oldVal;
	}

	/* Makes the tree Empty by setting the member variable N to zero,
	 * and setting the Key and Value arrays to a new instance.
	 * Inputs - None
	 * Output - void*/
	@Override
	public void makeEmpty() {
		// TODO Auto-generated method stub
		N = 0;
		keys = (Key[]) new Comparable[DEFAULT_CAPACITY + 1];
		vals = (Value[]) new Comparable[DEFAULT_CAPACITY + 1];
	}

	/* Returns true if the tree is empty and false if it is
	 * not.
	 * Inputs - none
	 * Output - true if N == 0 otherwise false*/
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return N == 0;
	}

	/* Returns the size of the tree
	 * Inputs - none
	 * Output - N */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return N;
	}
	
	public void print() {
		System.out.printf("[");
		for(int i = 1; i < N; i++)
			System.out.printf("<%d, %s>, ", keys[i], vals[i]);
		System.out.printf("<%d, %s>]\n\n", keys[N], vals[N]);
	}
	

}
