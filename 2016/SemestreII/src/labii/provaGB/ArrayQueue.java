package labii.provaGB;

public class ArrayQueue<E> implements Queue<E> {

	// The actual capacity of the queue array
	protected int capacity; 	

	//Index to the first element
	protected int first = 0;

	//Index to the last element
	protected int last = -1;

	// default array capacity
	public static final int CAPACITY = 1000;	

	// Generic array used to implement the queue 
	protected E Q[];

	/**Initializes the queue to use an array of default length. */
	public ArrayQueue() {
		this(CAPACITY);
	}

	/** Initializes the queue to use an array of given length. */
	public ArrayQueue(int cap){
		capacity = cap;
		Q = (E[]) new Object[capacity]; 
	}

	/** Testes whether the queue is empty. */
	public boolean isEmpty() {
		return (last == (first -1));
	}

	/** Returns the number of elements in the queue. */
	public int size() {
		return ((last - first) + 1);
	}

	 /** Removes and return the element at the front of the queue.*/
	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty.");
		}		
		E temp = Q[first];
		first++;
		return temp;
	}

	/** Inserts an element at the rear of the queue. */
	public void enqueue(E element) throws FullQueueException {
		if (last == Q.length -1) {
			throw new FullQueueException("Queue is full.");
		}
		last++;
		Q[last] = element;
	}

	/** Inspects the element at the front of the queue.*/
	public E front() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty. R");
		}
		return Q[first];
	}

	/** Returns a string representation of the stack as a list of elements. */
	public String toString() {
		String s = "[";
		if (size() > 0 ) {
			s += Q[first];
		}
		if (size() > 1) {
			for (int i = first+1; i <= last; i++) {
				s += ", " + Q[i];
			}
		}
		s += "]";
		return s;
	}
}

