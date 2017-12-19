package progii.exercicioFila;

/**
 * Interface for a queue: a collection of elements that are inserted
 * and removed according to the first-in first-out principle.
 *
 * @author Michael T. Goodrich
 * @author Natasha Gelfand
 * @author Mark Handy
 * @author Roberto Tamassia
 * @see EmptyQueueException
 */


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
//end#fragment Queue
