package labii.exe11;

public class NodeStack<E> implements Stack<E> {
	protected Node<E> top;	// reference to the head node
	protected int size;		// number of elements in the stack

	public NodeStack() {	// constructs an empty stack
		top = null;
		size = 0;
	}

	public int size() {
		return size; 
	}

	public boolean isEmpty(){
		if (top == null) return true;
		return false;
	}

	public void push(E elem){
		Node<E> v = new Node<E>(elem, top);	// create and link-in a new node
		top = v;
		size++;
	}

	public E top() throws EmptyStackException {
		if (isEmpty()) throw new EmptyStackException("Stack is empty.");
		return top.getElement();
	}

	public E pop() throws EmptyStackException {
		if (isEmpty()) throw new EmptyStackException("Stack is empty.");
		E temp = top.getElement();
		top = top.getNext();	// link-out the former top node
		size--;
		return temp;
	}

	@Override
	public String toString() {
		String s;
		Node<E> cur = null;
		s = "[";
		int n = size();
		if (n > 0) {
			cur = top;
			s += cur.getElement();
		}
		if (n > 1)
			for (int i = 1; i <= n-1; i++) {
				cur = cur.getNext();
				s += ", " + cur.getElement();
			}
		s += "]";
		return s;
	}
}

