package labii.aula15;

public class DLinkedList<E> {
	protected DNode<E> head; //nodo cabeca da lista
	protected DNode<E> tail; //nodo cauda da lista
	protected long size; //numero de nodos da lista

	public DLinkedList() {
		size = 0;
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public E getFirst() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return head.getElement();
	}

	public E getLast() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		return tail.getElement();
	}

	public void addFirst(E insertItem) {
		DNode<E> n = new DNode<E>(insertItem);
		if (isEmpty()) {
			head = tail = n;
		} else {
			head.setPrevious(n);
			n.setNext(head);
			head = n;
		}
		size++;
	}

	public void addLast(E insertItem) {
		DNode<E> n = new DNode<E>(insertItem);
		if (isEmpty()) {
			head = tail = n;
		} else {
			tail.setNext(n);
			n.setPrevious(tail);
			tail = n;
		}
		size++;
	}

	public E removeFirst() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		E removedItem = head.getElement();
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.getNext();
			head.setPrevious(null);
		}
		size--;
		return removedItem;
	}

	public E removeLast() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		E removedItem = tail.getElement();
		if (head == tail) {
			head = tail = null;
		} else {
			DNode<E> penultimo = tail.getPrevious();
			tail = penultimo;
			tail.setNext(null);
		}
		size--; 
		return removedItem;
	}

	public void print() {
		System.out.println("Exibindo a lista:");
		DNode<E> current = head;
		while (current != null) {
			System.out.println(current.getElement());
			current = current.getNext();
		}
	}

	private DNode<E> find(E key){
		DNode<E> aux = this.head;

		while(aux != null){
			if(aux.getElement().equals(key))
				return aux;

			aux = aux.getNext();
		}

		return null;
	}

	public boolean addBefor(E el, E key){
		DNode<E> current = find(key);

		if(current == null){
			return false;	
			
		}else if(current == head){
			addFirst(el);
			return true;
			
		}else{
			DNode<E> aux = new DNode<E>(el);
			DNode<E> before = current.getPrevious();
			before.setNext(aux);
			aux.setPrevious(before);
			aux.setNext(current);
			current.setPrevious(aux);

			return true;
		}

	}

	public static void main(String args[]) {
		DLinkedList<Integer> list = new DLinkedList<Integer>();
		list.addLast(2);
		list.addLast(4);
		list.addLast(6);
		list.addLast(1);
		list.addLast(8);
		list.addLast(9);
		list.print();
		try {
			list.removeFirst();
		} catch (UnderflowException e) {
			e.printStackTrace();
		}
		list.print();
	}

}
