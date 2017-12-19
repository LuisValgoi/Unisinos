package labii.aula14.linkedList;

public class Node<E>{
	private E element; 
	private Node<E> next;

	/** Cria um nodo com referencia nula para seu elemento e o próximo */
	public Node() { 
		this( null, null ); 
	}

	/** Cria um nodo com um dado elemento e o proximo nodo **/
	public Node(E s, Node<E> n){
		element = s;
		next = n;
	}

	/** Cria um nodo com um dado elemento e o proximo nodo em null**/
	public Node( E element ) { 
		this( element, null ); 
	}

	/** Retorna o elemento deste nodo **/
	public E getElement(){ return element; }

	/** Retorna o proximo elemento deste nodo **/
	public Node<E> getNext(){ return next; }

	/** Define o elemento deste nodo **/
	public void setElement(E newElem){ element = newElem; }

	/** Define o proximo elemento deste nodo **/
	public void setNext(Node<E> newNext){ next = newNext; }
}
