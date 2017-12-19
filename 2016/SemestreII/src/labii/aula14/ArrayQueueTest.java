package labii.aula14;

import labii.aula14.pilhas_filhas_encadeadas.EmptyQueueException;
import labii.aula14.pilhas_filhas_encadeadas.NodeQueue;

public class ArrayQueueTest {
	public static void main(String[] args) {
		NodeQueue<Integer> q = new NodeQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		System.out.println(q.toString());
		try{
			while (!q.isEmpty()){
				System.out.println(q.dequeue());
			}
		}
		catch(EmptyQueueException e) {
			System.out.println(e);
		}
	}
}