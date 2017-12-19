package labii.aula12;

import labii.aula12.queue.ArrayQueue;
import labii.aula12.queue.EmptyQueueException;
import labii.aula12.queue.FullQueueException;

public class ArrayQueueTest {
	
	public static void main(String[] args) {
		ArrayQueue<Integer> q = new ArrayQueue<Integer>(5);
		try{
			/*
			q.enqueue(1);
			q.enqueue(2);
			q.enqueue(3);
			q.enqueue(4);
			q.enqueue(5);
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

			// 25,90,8
			// printa - 25,90,8
			// 90, 8
			// 90, 8, 15
			// 8, 15
			// 8, 15, 25
			// printa - 8, 15, 25
			// printa 8 e atualizo pra 15, 25
			// printa 15 e atualizo pra 25
			// printa 25 e atualizo pra []
			// printo []
			// nao insiro 10 pois 'ta cheia pois nao eh circular' e throw excecao
			
		}catch(FullQueueException e) {
			System.out.println(e);
		}
		try{
			while(!q.isEmpty()){
				System.out.println(q.dequeue());
			}
		}
		catch(EmptyQueueException e) {
			System.out.println(e);
		}
	}
	
}