package labii.exe11;

public interface Queue<E> {  

	/** Returns the number of elements in the queue.*/
	public int size();  

	/** Returns whether the queue is empty. */
	public boolean isEmpty(); 

	/** Inspects the element at the front of the queue.*/
	public E front() throws EmptyQueueException; 

	/** Inserts an element at the rear of the queue. */
	public void enqueue (E element); 

	/** Removes and return the element at the front of the queue.*/
	public E dequeue() throws EmptyQueueException; 
}