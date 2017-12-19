package labii.exe11;

public class NodeQueue<E> implements Queue<E> {

	protected Node<E> head, tail;  	// the head and tail nodes
	protected int size;         	// Keeps track of number of elements in queue

	/** Creates an empty queue. */
	public NodeQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	//# Return the current queue size
	public int size() {
		return size;
	}

	//# Returns true iff queue is empty
	public boolean isEmpty() {
		if ( (head==null) && (tail==null) )
			return true;
		return false;
	}

	public void enqueue(E elem) {
		Node<E> node = new Node<E>();
		node.setElement(elem);
		node.setNext(null); // node will be new tail node
		if (size == 0)
			head = node; // special case of a previously empty queue
		else
			tail.setNext(node); // add node at the tail of the list
		tail = node; // update the reference to the tail node
		size++;
	}

	public E front() throws EmptyQueueException {
		if (size == 0)
			throw new EmptyQueueException("Queue is empty.");
		return head.getElement();
	}

	public E dequeue() throws EmptyQueueException {
		if (size == 0)
			throw new EmptyQueueException("Queue is empty.");
		E tmp = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null; // the queue is now empty
		return tmp;
	}

	public String toString() {
		String s = "";
		s += "[";
		       if (!isEmpty()) {
		    	   Node<E> p = head;
		    	   do {
		    		   s += p.getElement() ;
		    		   if (p != tail)
		    			   s += ", ";
		    		   p = p.getNext();
		    	   } while (p != null);
		       }
		       s += "]";
		    		   return s;
	}
}
