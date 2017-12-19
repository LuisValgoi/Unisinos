package labii.aula12;

import labii.aula12.queue.ArrayCircularQueue;
import labii.aula12.queue.EmptyQueueException;
import labii.aula12.queue.FullQueueException;

public class ArrayCircularQueueTest {
	
	public static void main(String[] args) {
		ArrayCircularQueue<Integer> q = new ArrayCircularQueue<Integer>(5);
		try{
			/*
			q.enqueue(1);
			q.enqueue(2);
			q.enqueue(3);
			q.enqueue(4);
			q.dequeue();
			q.dequeue();
			q.enqueue(5);
			q.enqueue(6);
			q.enqueue(7);
			*/
			
			q.enqueue(25);
			q.enqueue(90);
			q.enqueue(8);
			System.out.println(q);
			q.dequeue();
			q.enqueue(15);
			q.dequeue();
			q.enqueue(25);
			System.out.println(q);
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			System.out.println(q.dequeue());
			System.out.println(q);
			q.enqueue(10);
			System.out.println(q);
			
		} catch(FullQueueException e) {
			System.out.println(e);
		}
		catch(EmptyQueueException e) {
			System.out.println(e);
		}
	}

}