package labii.aula12;

import labii.aula12.deque.ArrayDeque;
import labii.aula12.deque.EmptyDequeException;
import labii.aula12.deque.FullDequeException;

public class ArrayDequeTest{
	public static void main(String[] args) {
		ArrayDeque<Integer> d = new ArrayDeque<Integer>();
		try{
			d.addLast(1);
			d.addFirst(2);
			d.addLast(3);
			d.addFirst(4);
			System.out.println(d.removeFirst());
			System.out.println(d.removeLast());
			System.out.println(d.removeFirst());
			System.out.println(d.removeLast());
		}catch(FullDequeException e) {
			System.out.println(e);
		}catch(EmptyDequeException e){
			System.out.println(e);
		}
	}
}