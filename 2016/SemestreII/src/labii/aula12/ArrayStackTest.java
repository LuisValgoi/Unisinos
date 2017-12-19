package labii.aula12;

import java.util.EmptyStackException;
import labii.aula12.stack.ArrayStack;
import labii.aula12.stack.FullStackException;

public class ArrayStackTest {
	
	public static void main(String[] args) {
		ArrayStack<Integer> s = new ArrayStack<Integer>(10);
		try{
			s.push(1);
			s.push(2);
			s.push(3);
			s.push(4);
			s.push(5);
		} catch(FullStackException e) {
			System.out.println(e);
		}
		try{
			while(!s.isEmpty())
				System.out.println(s.pop());			
		}
		catch(EmptyStackException e){
			System.out.println(e);
		}
	}

}
