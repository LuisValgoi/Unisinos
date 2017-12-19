package labii.trabGB.estruturas;

public class Node<E> {
	private E element;
	private Node<E> next;

	/** Creates a node with null references to its element and next node. */
	public Node() {
		this(null, null);
	}

	/** Creates a node with the given element and next node. */
	public Node(E e, Node<E> n) {
		element = e;
		next = n;
	}

	public Node(E e){
		element=e;
	}

	public E getElement() {
		return element; 
	}

	public Node<E> getNext() { 
		return next;
	}

	public void setElement(E newElem) { 
		element = newElem; 
	}

	public void setNext(Node<E> newNext) {
		next = newNext; 
	}
}

