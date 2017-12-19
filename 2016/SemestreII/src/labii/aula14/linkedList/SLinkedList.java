package labii.aula14.linkedList;

public class SLinkedList<E> {
	protected Node<E> head; //nodo cabeca da lista
	protected Node<E> tail; //nodo cauda da lista
	protected long size; //numero de nodos da lista

	/** Construtor default que cria uma lista vazia **/
	public SLinkedList(){
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty(){
		return head == null;
	}

	public Node<E> getFirst() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException();
		return head;
	}

	public Node<E> getLast() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException();
		return tail;
	}

	public void addFirst(Node<E> novoNodo){
		novoNodo.setNext(head);
		head = novoNodo;
		size++;
		if(size == 1)
			tail = head;
	}

	public void addLast(Node<E> novoNodo){
		if(isEmpty())
			addFirst(novoNodo);
		else{
			novoNodo.setNext(null);
			tail.setNext(novoNodo);
			tail = novoNodo;
			size++;
		}
	}

	public Node<E> removeFirst() throws UnderflowException {
		if(isEmpty()) throw new UnderflowException();
		Node<E> removedItem = head;
		if (head == tail) {
			head = tail = null;
		} 
		else {
			head = head.getNext();
		}
		size--;
		return removedItem;
	}

	public Node<E> removeLast() throws UnderflowException {
		if (isEmpty()) throw new UnderflowException();
		Node<E> removedItem = tail;
		if (head == tail) {
			head = tail = null;
		} 
		else {
			Node<E> current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			tail = current;
			current.setNext(null);
		}
		size--;
		return removedItem;
	}

	public static void main(String args[]){
		SLinkedList<String> lista = new SLinkedList<String>();
		try{
			lista.addFirst(new Node<String>("A"));
			lista.addFirst(new Node<String>("B"));
			lista.addFirst(new Node<String>("C"));
			lista.addLast(new Node<String>("D"));
			lista.addLast(new Node<String>("E"));
			lista.addLast(new Node<String>("F"));
			lista.removeFirst();
			lista.removeLast();

		}catch(UnderflowException e){
			System.out.println("ERRO: lista vazia, impossivel remover!");
			e.printStackTrace();
		}
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("Empty list");
		}
		else {
			System.out.print("The list is: ");
			Node<E> current = head;
			while (current != null) {
				System.out.print(current.getElement().toString() + " ");
				current = current.getNext();
			}
			System.out.println("\n");
		}
	}

	public void addAfter(Node<E> n, int pos){
		if(pos >= size || pos < 0){
			throw new IndexOutOfBoundsException();
		}if(pos == size - 1){
			addLast(n);
		}else{
			Node<E> current = head;

			int i = 0;
			while(i < pos){
				current = current.getNext();
				i++;
			}

			n.setNext(current.getNext());
			current.setNext(n);
			size++;
		}
	}
	
	public void addBefore(Node<E> n, int pos){
		if(pos >= size || pos < 0){
			throw new IndexOutOfBoundsException();
		}if(pos == 0){
			addFirst(n);
		}else{
			Node<E> current = head;
			Node<E> previous = null;
			
			int i = 0;
			while(i < pos){				
				previous = current;
				current = current.getNext();
				i++;
			}
			
			current.setNext(current);
			previous.setNext(n);		
			size++;
		}
	}

}
