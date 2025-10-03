package features.eight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@FunctionalInterface
interface I<T>{
	T concatAdd(T a, T b, T c, T d, T e);
}

interface IO{
	public static void println(String str) {
		System.out.println(str);
	}
	public default void println(Integer i) {
		System.out.println(i);
	}
}

class IOImpl implements IO{
	public Scanner input;
	IOImpl() {
		input= new Scanner(System.in);
	}
}

public class CommonFeaturesJava8 {
	public static void main(String[] args) {
		IOImpl io= new IOImpl();
		System.out.println("A text input?: ");
		String str=io.input.nextLine();
		IO.println(str);
		System.out.println("An integer input?: ");
		Integer i= io.input.nextInt();
		io.println(i);
		
		//functionalInterface
		I<Integer> addIntegers = (Integer a, Integer b,Integer c, Integer d,Integer e)->{int x = a+b+c+d+e; System.out.println("output:"+x);return x;};
		addIntegers.concatAdd(1, 2, 3, 4, 5);
		I<String> concatStrings = (String a, String b,String c, String d,String e)->{String x = a+b+c+d+e; System.out.println("output:"+x);return x;};
		concatStrings.concatAdd("Hello ", " java", " programming", " world", "!");
		
		//Method references
		List.of(1,2,3,4).forEach(System.out::println);
		Supplier<List<Integer>> supplyList = ArrayList::new;
		List<Integer> lists = supplyList.get();
		
		//Lambda expression
		
		List.of("Apple", "Mango", "Banana").forEach(a->System.out.println(a.charAt(a.length()/2)));
		
		//streaming api
		System.out.println(List.of(List.of("Apple", "Mango", "Banana"),List.of("Orange", "Mango", "Tomato"))
		.stream().flatMap(List::stream).collect(Collectors.joining(", ")));
		
		System.out.println(List.of("Apple", "Mango", "Banana").stream()
		.flatMap(word->word.chars().mapToObj(c->(char) c +" "))
		.toList());
		
		int[][] arr ={{2,5},{1,4},{6,9}};
		Arrays.stream(arr).flatMapToInt(Arrays::stream).boxed().toList();
		
		
		System.out.println(List.of("Apple", "Mango", "Banana","Orange", "Mango", "Tomato")
				.stream().collect(Collectors.groupingBy(fruit->fruit.length()))
				);
		
		//Optional
		
		Optional<String> str2 = Optional.ofNullable(null);
		str2.ifPresent(st->System.out.println(str));
		str2.map(sr->sr.length()).orElse(0);
		
		//intuitive and immutable alternatives to Date and Time
		
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		LocalDateTime ldt = LocalDateTime.now();
	}

}
