package labii.exe12;

public class DLinkedListFilha<E extends Comparable<E>> extends DLinkedList<E>{

	public static void main(String[] args) {
		DLinkedListFilha<String> lista = new DLinkedListFilha<String>();
		lista.addLast("2");
		lista.addLast("4");		
		lista.addLast("6");
		lista.addLast("8");
		
		lista.addAfter("3", "2");
		lista.print();
		lista.addAfter("5", "4");
		lista.print();
		lista.addAfter("9", "8");
		lista.print();
		
		lista.addBefore("7", "8");
		lista.print();		
		try {
			lista.removePos(3);
			lista.print();
		} catch (UnderflowException e) {
			System.out.println("underflow");
		}
		
		try {
			lista.removeMax();
			lista.print();
		} catch (UnderflowException e) {
			System.out.println("underflow");
		}
		
	}

	public boolean addAfter(E el, E key){
		DNode<E> current = head;

		while(current != null){
			if(current.getElement() == key)
				break;

			else current = current.getNext();
		}

		if(current==null){
			return false;
		}

		else if(current==tail){
			addLast(el);
			return true;
		}

		else{
			DNode<E> next = current.getNext();
			DNode novo = new DNode(el,next,current);

			next.setPrevious(novo);
			current.setNext(novo);
			return true;
		}
	}

	public boolean removeMax() throws UnderflowException{
		DNode<E> maior = findMax();

		if(super.isEmpty()){
			throw new UnderflowException();	
		}	
		else if(maior == head){
			removeFirst();
			return true;

		}else if(maior == tail){
			removeLast();
			return true;
		}
		else{			
			DNode<E> before = maior.getPrevious();
			DNode<E> after = maior.getNext(); 
			before.setNext(after);			

			return true;
		}
	}

	public void removePos(int pos) throws UnderflowException{
		if(pos < 0 || pos > size - 1)
			throw new IndexOutOfBoundsException();

		if(pos == 0)
			removeFirst();

		else if(pos == size -1)
			removeLast();

		else{	

			int i = 0;
			DNode<E> atual = head;	
			while (i != pos) {				
				i++;				
				atual = atual.getNext();
			}

			DNode<E> before = atual.getPrevious();
			DNode<E> after = atual.getNext();
			before.setNext(after);			
		}			

	}

	public DNode<E> findMax(){
		DNode<E> current = this.head;

		DNode<E> maior = current;		
		while(current != null){			
			if(current.getElement().compareTo(maior.getElement()) > 0){
				maior = current;
			}

			current = current.getNext();
		}

		return maior;
	}

	public DNode<E> find(E key){
		DNode<E> aux = this.head;

		while(aux != null){
			if(aux.getElement().equals(key))
				return aux;

			aux = aux.getNext();
		}

		return null;
	}

}
