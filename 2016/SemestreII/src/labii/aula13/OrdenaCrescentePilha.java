package labii.aula13;

import labii.aula12.stack.ArrayStack;
import labii.aula12.stack.Stack;

public class OrdenaCrescentePilha {

	public static void main(String[] args) {
		Stack<Integer> q1 = new ArrayStack<Integer>(4);
		q1.push(6);
		q1.push(4);
		q1.push(3);
		q1.push(1);
		Stack<Integer> q2 = new ArrayStack<Integer>(2);
		q2.push(5);
		q2.push(2);
		Stack<Integer> q3 = ordenaCrescentePilha(q1, q2);
		System.out.println(q3);
	}
	
	private static Stack<Integer> ordenaCrescentePilha(Stack<Integer> q1, Stack<Integer> q2){
		Stack<Integer> nova = new ArrayStack<Integer>(q1.size() + q2.size());
		
		while (!q1.isEmpty() && !q2.isEmpty()) {
			Integer value = q1.top();
			Integer value2 = q2.top();
			
			if(value < value2)
				nova.push(q1.pop());
			else
				nova.push(q2.pop());
		}
		
		while (!q1.isEmpty())	
			nova.push(q1.pop());		
		
		while (!q2.isEmpty())
			nova.push(q2.pop());		
		
		return nova;
	}
	
}
