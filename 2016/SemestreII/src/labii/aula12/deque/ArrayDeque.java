package labii.aula12.deque;

import labii.aula12.queue.ArrayQueue;
import labii.aula12.queue.FullQueueException;

public class ArrayDeque<E> extends ArrayQueue<E> implements Deque<E> {

	/**Initializes the deque to use an array of default length. */
	public ArrayDeque(){
		super();
	}

	/** Initializes the deque to use an array of given length. */
	public ArrayDeque(int cap) {
		super(cap);
	}	

	/**Inserts an element to be the first in the deque.*/
	public void addFirst(E element) throws FullDequeException{
		if (last == Q.length -1) {
			throw new FullDequeException("Deque is full.");
		}
		System.arraycopy(Q, first, Q, first + 1, last - first + 1);
		Q[first] = element;
		last++;
	}

	/**Inserts an element to be the last in the deque.*/	
	public void addLast(E element)  throws FullDequeException{
		try{
			enqueue(element);
		} catch(FullQueueException e){
			throw new FullDequeException("Deque is full.");
		}
	}

	/** Returns the first element; an exception is thrown if deque is empty.*/
	public E getFirst() throws EmptyDequeException {
		return super.front();
	}

	/**Returns the last element; an exception is thrown if deque is empty.*/
	public E getLast() throws EmptyDequeException {
		if (isEmpty()){
			throw new EmptyDequeException("Deque is empty.");
		}
		return Q[last];
	}

	/** Removes the first element; an exception is thrown if deque is empty.*/
	public E removeFirst() throws EmptyDequeException {
		return dequeue();
	}

	/** Removes the last element; an exception is thrown if deque is empty.*/
	public E removeLast() throws EmptyDequeException {
		if (isEmpty()) {
			throw new EmptyDequeException("Deque is Empty.");
		}
		return Q[last--];
	}

}


