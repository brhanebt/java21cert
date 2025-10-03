package collectiongenerics.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListExamples {
	
	public static void main(String[] args) {
		arrayListExample();
		linkedListExample();
		linkedListAsStackExample();
		linedListAsQueueExample();
	}
	
	private static void linedListAsQueueExample() {
		
		System.out.println("\nLinked List as Queue of Fruits:");
		LinkedList<String> queue = new LinkedList<>();
		queue.add("Mango");
		queue.add("Grapes");
		queue.add("Banana");
		queue.add("Apple");
		queue.add("Orange");
		queue.forEach(f->System.out.print(f+" "));
		
		System.out.println("\nLinked List as Queue of Fruits using poll:");
		while(!queue.isEmpty()) {
			System.out.print(queue.poll()+" ");
		}
		
		System.out.println();
		
	}

	private static void linkedListAsStackExample() {

		System.out.println("\nLinked List as Stack of Fruits:");
		LinkedList<String> stack = new LinkedList<>();
		stack.push("Mango");
		stack.push("Grapes");
		stack.push("Banana");
		stack.push("Apple");
		stack.push("Orange");
		stack.forEach(f->System.out.print(f+" "));
		
		System.out.println("\nLinked List as Stack of Fruits using pop:");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
		
		System.out.println();
		
	}

	private static void linkedListExample() {
		System.out.println("\nLinked List of Fruits:");
		List<String> list = new LinkedList<>();
		list.add("Mango");
		list.add("Grapes");
		list.add("Banana");
		list.add("Apple");
		list.add("Orange");
		list.forEach(f->System.out.print(f+" "));
		
		System.out.println("\nLinked List of Fruits using addFirst and addLast:");
		List<String> list2 = new LinkedList<>();
		list2.addFirst("Mango");
		list2.addFirst("Grapes");
		list2.addLast("Banana");
		list2.addLast("Apple");
		list2.addLast("Orange");
		list2.forEach(f->System.out.print(f+" "));
		
		System.out.println("\nLinked List of Fruits using removeFirst and removeLast:");
		while(!list2.isEmpty()) {
			System.out.print(list2.removeFirst()+" ");
		}
		
		System.out.println();
		
	}

	private static void arrayListExample() {
		System.out.println("Array List of Fruits:");
		List<String> list = new ArrayList<>();
		list.add("Mango");
		list.add("Grapes");
		list.add("Banana");
		list.add("Apple");
		list.add("Orange");
		list.forEach(f->System.out.print(f+" "));
		
		System.out.println("\nArray List of Fruits using index:");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		
		System.out.println();
		
	}

}
