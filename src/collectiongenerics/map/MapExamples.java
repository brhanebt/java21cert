package collectiongenerics.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {
	
	public static void main(String[] args) {
		iteratingMapExample();
		treeMapExample();		
	}

	private static void treeMapExample() {
		//TreeMap is sorted by keys
		Map<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("Banana", 1);
		treeMap.put("Apple", 2);
		treeMap.put("Orange", 3);
		treeMap.put("Grapes", 4);
		treeMap.put("Mango", 5);
		
		System.out.println("\nTreeMap (sorted by keys):");
		treeMap.forEach((k,v)->System.out.print(k+" -> "+v+" | "));
		
		System.out.println();
		
		treeMap.entrySet().stream().forEach(entry->System.out.print(entry.getKey()+" -> "+entry.getValue()+" | "));
		
		System.out.println("\nTreeMap with custom comparator (reverse order):");
		
		treeMap = new TreeMap<>((a,b)->b.compareTo(a));
		treeMap.put("Banana", 1);
		treeMap.put("Apple", 2);
		treeMap.put("Orange", 3);
		treeMap.put("Grapes", 4);
		treeMap.put("Mango", 5);
		
		treeMap.forEach((k,v)->System.out.print(k+" -> "+v+" | "));
		
		
	}

	private static void iteratingMapExample() {
		Map<String, Integer> map = new HashMap<>();
		map.put("One", 1);
		map.put("Two", 2);
		map.put("Three", 3);
		map.put("Four", 4);
		
		System.out.println("Iterating using forEach and lambda:");
		map.forEach((k,v)->System.out.println(k+" -> "+v));
		
		System.out.println("Iterating using entrySet and for-each:");
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.print(entry.getKey()+" -> "+entry.getValue()+" | ");
		}
		
		System.out.println("\nIterating using keySet and for-each:");
		for(String key : map.keySet()) {
			System.out.print(key+" -> "+map.get(key)+" | ");
		}
		
		System.out.println("\nIterating using values and for-each:");
		for(Integer value : map.values()) {
			System.out.print(value+" | ");
		}
		
		System.out.println("\nIterating using entrySet and stream:");
		map.entrySet().stream().forEach(entry->System.out.print(entry.getKey()+" -> "+entry.getValue()+" | "));
		
		System.out.println("\nIterating using keySet and stream:");
		map.keySet().stream().forEach(key->System.out.print(key+" -> "+map.get(key)+" | "));
	
		
	}

}
