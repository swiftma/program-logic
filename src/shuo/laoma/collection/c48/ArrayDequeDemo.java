package shuo.laoma.collection.c48;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class ArrayDequeDemo {

	public static void basic(){
		Queue<String> queue = new ArrayDeque<>();

		queue.offer("a");
		queue.offer("b");
		queue.offer("c");

		while(queue.peek()!=null){
		    System.out.print(queue.poll() +" ");    
		}

	}
	
	public static void stack(){
		Deque<String> stack = new ArrayDeque<>();

		stack.push("a");
		stack.push("b");
		stack.push("c");

		while(stack.peek()!=null){
		    System.out.print(stack.pop()+" ");    
		}
	}
	
	public static void deque(){
		Deque<String> deque = new ArrayDeque<>();

		deque.addFirst("a");
		deque.offerLast("b");
		deque.addLast("c");
		deque.addFirst("d");

		System.out.println(deque.getFirst()); //d
		System.out.println(deque.peekLast()); //c
		System.out.println(deque.removeFirst()); //d
		System.out.println(deque.pollLast()); //c 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
