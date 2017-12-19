package progii.exercicioFila;

public class Exe02 {
	
	public static void main(String[] args) {
		Queue<Integer> q = new ArrayQueue<Integer>(4);
		Queue<Integer> q2 = new ArrayQueue<Integer>(4);
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		// 1
		// 1,2
		// 1,2,3
		// 1,2,3,4
		System.out.println(q);
		
		q2.enqueue(5);
		q2.enqueue(6);
		q2.enqueue(7);
		q2.enqueue(8);
		// 5
		// 5,6
		// 5,6,7
		// 5,6,7,8
		System.out.println(q2);
		
		prependQueue(q, q2);
		System.out.println(q);
	}

	// q1 = {1,2,3,4}, q2 = {5,6,7,8}
	public static void prependQueue(Queue<Integer> q1, Queue<Integer> q2){
		Queue<Integer> aux = new ArrayQueue<Integer>(q1.size() + q2.size());

		while(!q2.isEmpty())
			aux.enqueue(q2.dequeue());
		// 5,6,7,8

		while(!q1.isEmpty())
			aux.enqueue(q1.dequeue());	
		// 5,6,7,8,1,2,3,4
		
		q1 = aux;
	}
	
}
