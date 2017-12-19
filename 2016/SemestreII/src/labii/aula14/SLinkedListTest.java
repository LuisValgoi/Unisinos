package labii.aula14;

import labii.aula14.linkedList.Node;
import labii.aula14.linkedList.SLinkedList;
import labii.aula14.linkedList.UnderflowException;;

public class SLinkedListTest {
	
	public static void main(String args[]){
		SLinkedList<String> lista = new SLinkedList<String>();
		try{
			lista.addFirst(new Node<String>("A"));
			lista.addFirst(new Node<String>("B"));
			lista.addFirst(new Node<String>("C"));
			lista.addLast(new Node<String>("D"));
			lista.addLast(new Node<String>("E"));
			lista.addLast(new Node<String>("F"));
			// C,B,A,D,E,F
			lista.removeFirst();
			lista.removeLast();
			// B,A,D,E
			lista.addAfter(new Node<String>("Z"), 3);
		}catch(UnderflowException e){
			System.out.println("ERRO: lista vazia, impossÌvel remover!");
			e.printStackTrace();
		}
		lista.print();
	}
	
}
