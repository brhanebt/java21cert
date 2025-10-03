package features.nine;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Map;

interface IO{
	private void print() {
		System.out.println("This is from a private interface method!");
	}
}
public class CommonFeaturesJava9 {
	
	public static void main(String[] args) {
		//Factory methods for simplified creation of immutable collections
		List<Integer> intList = List.of(9,3,7,1,8);
		Set<Integer> intSet = Set.of(9,3,7,1,8);
		Map<Integer, Integer> intMap = Map.of(1,9,2,3,3,7,4,1,5,8);
		
		//Before Java 9
		intList = Collections.unmodifiableList(Arrays.asList(9,3,7,1,8));
		
		//private methods in interfaces to reuse code and reduce duplication
		
		//stream api improvements
		
		intList.stream().takeWhile(i->i%2!=0).forEach(System.out::println);

	}

}
