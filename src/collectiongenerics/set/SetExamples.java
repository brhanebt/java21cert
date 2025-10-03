package collectiongenerics.set;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

public class SetExamples {
	
	public static void main(String[] args) {
		hashSetExample();
		treeSetExample();
	}

	private static void treeSetExample() {
		Set<String> set = new TreeSet<>();
		set.add("Orange");
		set.add("Grapes");
		set.add("Apple");
		set.add("Banana");
		set.add("Mango");
		
		System.out.println("\nTreeSet elements (sorted order):");
		set.forEach(f->System.out.print(f+" "));
		
	}

	private static void hashSetExample() {
		Set<String> set = new HashSet<>();
		set.add("Orange");
		set.add("Grapes");
		set.add("Apple");
		set.add("Banana");
		set.add("Mango");
		
		System.out.println("HashSet elements (no particular order):");
		set.forEach(f->System.out.print(f+" "));
	}

}
