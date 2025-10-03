package collectiongenerics.queue;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class QueueExamples {
	
	public static void main(String[] args) {
		priorityQueueExample();
		arrayDequeExample();
		arrayDequeAsStackExample();
		
	}
	
	private static void arrayDequeAsStackExample() {
		System.out.println("\nArray Deque as Stack of Fruits:");
		ArrayDeque<String> stack = new ArrayDeque<>();
		stack.push("Mango");
		stack.push("Grapes");
		stack.push("Banana");
		stack.push("Apple");
		stack.push("Orange");
		stack.forEach(f->System.out.print(f+" "));
		
		System.out.println("\nArray Deque as Stack of Fruits using pop:");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
		System.out.println();
		
	}

	private static void arrayDequeExample() {
		System.out.println("\nArray Deque of Fruits:");
		ArrayDeque<String> adq = new ArrayDeque<>();
		adq.add("Mango");
		adq.add("Grapes");
		adq.add("Banana");
		adq.add("Apple");
		adq.add("Orange");
		adq.forEach(f->System.out.print(f+" "));
		
		System.out.println("\nArray Deque of Fruits using offer:");
		ArrayDeque<String> adq2 = new ArrayDeque<>();
		adq2.offer("Mango");
		adq2.offer("Grapes");
		adq2.offer("Banana");
		adq2.offer("Apple");
		adq2.offer("Orange");
		adq2.forEach(f->System.out.print(f+" "));
		
		System.out.println("\nArray Deque of Fruits using poll:");
		while(!adq2.isEmpty()) {
			System.out.print(adq2.poll()+" ");
		}
		
		System.out.println("\nArray Deque of Fruits using pop:");
		while(!adq.isEmpty()) {
			System.out.print(adq.pop()+" ");
		}
		
		System.out.println();
		
	}

	static void priorityQueueExample() {
		System.out.println("Priority Queue of Fruits default:");
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("Mango");
		pq.add("Grapes");
		pq.add("Banana");
		pq.add("Apple");
		pq.add("Orange");
		pq.forEach(f->System.out.print(f+" "));
		
		
		System.out.println("\nPriority Queue of Fruits reverse order:");
		PriorityQueue<String> pqRev = new PriorityQueue<>((s1,s2)->s2.compareTo(s1));
		pqRev.add("Mango");
		pqRev.add("Grapes");
		pqRev.add("Banana");
		pqRev.add("Apple");
		pqRev.add("Orange");
		pqRev.forEach(f->System.out.print(f+" "));
	}

}
