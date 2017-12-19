package progii.exercicioFila;

import labii.aula12.queue.ArrayCircularQueue;

public class Exe01 {

	public static void main(String[] args){
		ArrayCircularQueue<Integer> sasa = new ArrayCircularQueue<Integer>();
		sasa.enqueue(1);
		sasa.enqueue(2);
		sasa.enqueue(3);
		sasa.enqueue(4);

		System.out.println(sasa.moveToFront(55));
		
		Queue<Integer> f = new ArrayQueue<>(5);
		foobar(f);
	}

	public static void foobar(Queue<Integer> f){
		try {
			f.enqueue(1);
			f.enqueue(3);
			f.enqueue(5);
			f.enqueue(7);
			f.enqueue(9);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			f.dequeue();
			f.dequeue();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			f.enqueue(2);
			f.enqueue(4);
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			f.dequeue();
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			f.enqueue(3);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(f);
	}

}
