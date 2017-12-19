package progii.exercicioFila;
/**
 * Implementation of the stack ADT using a fixed-length array.  An
 * exception is thrown if a push operation is attempted when the size
 * of the stack is equal to the length of the array.  This class
 * includes the main methods of the built-in class java.util.Stack.
 * @author Natasha Gelfand
 * @author Roberto Tamassia
 * @see FullStackException
 */

public class ArrayStack<E> implements Stack<E> {

	/**
	 * Length of the array used to implement the stack.
	 */
	protected int capacity; 	// The actual capacity of the stack array

	/**
	 * Default array capacity.
	 */
	public static final int CAPACITY = 1000;	// default array capacity

	/**
	 * Array used to implement the stack.
	 */
	protected E S[];		// Generic array used to implement the stack 

	/**
	 * Index of the top element of the stack in the array.
	 */
	protected int top = -1;	// index for the top of the stack

	/**
	 * Initializes the stack to use an array of default length.
	 */
	public ArrayStack() {
		this(CAPACITY); // default capacity 
	}

	/**
	 * Initializes the stack to use an array of given length.
	 * @param cap length of the array.
	 */
	public ArrayStack(int cap) {
		capacity = cap;
		S = (E[]) new Object[capacity]; // compiler may give warning, but this is ok
	}

	/**
	 * Returns the number of elements in the stack.
	 */
	public int size() { 
		return (top + 1);
	}

	/**
	 * Testes whether the stack is empty.
	 */
	public boolean isEmpty() {
		return (top < 0);
	}

	/**
	 * Inserts an element at the top of the stack.
	 */
	public void push(E element) throws FullStackException {
		if (size() == capacity)
			throw new FullStackException("Stack is full.");
		S[++top] = element;
	}

	/**
	 * Inspects the element at the top of the stack.
	 */
	public E top() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Stack is empty.");
		return S[top];
	}

	/**
	 * Removes the top element from the stack.
	 */
	public E pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Stack is empty.");
		
		E element = S[top];
		S[top--] = null; // dereference S[top] for garbage collection.
		return element;
	}

	/**
	 * Returns a string representation of the stack as a list of elements,
	 */
	public String toString() {
		String s;
		s = "[";
		if (size() > 0) s+= S[0];
		if (size() > 1)
			for (int i = 1; i <= size()-1; i++) {
				s += ", " + S[i];
			}
		return s + "]";
	}
}

