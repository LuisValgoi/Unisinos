package labii.aula14;

import labii.aula14.pilhas_filhas_encadeadas.EmptyStackException;
import labii.aula14.pilhas_filhas_encadeadas.NodeStack;

public class ArrayStackTest {
	public static void main(String[] args) {
		NodeStack<Integer> s = new NodeStack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		try {
			while (!s.isEmpty()) {
				System.out.println(s.pop());
			}
		} catch (EmptyStackException e) {
			System.out.println(e);
		}
	}
}