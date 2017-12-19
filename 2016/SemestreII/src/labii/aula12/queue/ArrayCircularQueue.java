package labii.aula12.queue;
public class ArrayCircularQueue<E> implements Queue<E> {

	// The actual capacity of the queue array
	protected int capacity; 	

	//Index to the first element
	protected int first = -1;

	//Index to the last element
	protected int last = -1;

	// default array capacity
	public static final int CAPACITY = 1000;	

	// Generic array used to implement the queue 
	protected E Q[];

	/**Initializes the queue to use an array of default length. */
	public ArrayCircularQueue() {
		this(CAPACITY);
	}

	/** Initializes the queue to use an array of given length. */
	public ArrayCircularQueue(int cap){
		capacity = cap;
		Q = (E[]) new Object[capacity]; 
	}

	/** Testes whether the queue is empty. */
	public boolean isEmpty() {
		if (first == -1) {
			return true;
		}
		else {
			return false;
		}
	}

	/** Returns the number of elements in the queue. */
	public int size() {
		if (first > last) {
			return (Q.length - first) + (last + 1);
		}
		else {
			return (last - first + 1);
		}
	}

	/** Removes and return the element at the front of the queue.*/
	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is Empty.");
		}
		E element = Q[first];

		// Queue contains only one element
		if (first == last) {
			first = last = -1;
		}
		else if (first == Q.length -1){
			first = 0;
		}
		else{
			first++;
		}
		return element;
	}

	/** Inserts an element at the rear of the queue. */
	public void enqueue(E element) throws FullQueueException {
		if ((first == 0 && last == Q.length -1) || (first == last + 1)) {
			throw new FullQueueException("Queue is full");
		}
		else {
			if ((last == Q.length-1) || (last == -1)) {
				last = 0;
				Q[last] = element;
				
				if (first == -1)
					first = 0;				
			}
			else
				Q[++last] = element;
		}
	}

	/** Inspects the element at the front of the queue.*/
	public E front() throws EmptyQueueException {
		if (isEmpty()) 
			throw new EmptyQueueException("Queue is empty.");
		return Q[first];
	}

	public boolean moveToFront(E element){
		E[] aux = (E[]) new Object[Q.length + 1];
		System.arraycopy(Q, 0, aux, 1, Q.length);
		
		boolean response = false;
		for(int i = 0; i < Q.length; i++){
			if(Q[i] != null){
				if(Q[i].equals(element)){
					aux[0] = element;
					first = 0;
					response = true;
					Q = aux;			
					break;
				}
			}
		}
		
		return response;
	}
	
	/** Returns a string representation of the stack as a list of elements. */
	public String toString(){		
		String s = "[";

		if(isEmpty()){
			s += "]";
			return s;
		}

		if (size() > 0) {
			s += Q[first];
		}

		if (size() > 1) {
			if (first > last){
				for (int i = first + 1; i < Q.length; i++){
					s += ", " + Q[i]; 
				}

				for (int i = 0; i <= last; i++) {
					s += ", " + Q[i];
				}
			}
			else{
				for (int i = first + 1; i <= last; i++) {
					s += ", " + Q[i];
				}
			}
		}
		s += "]";
		return s;
	}
}
