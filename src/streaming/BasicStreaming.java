package streaming;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BasicStreaming {
	public static void main(String[] args) {
		List<Integer> ints = List.of(45,4,67,1,96,30,18,59,96,67);
		List<String> features = List.of("Lambda Functions","Streaming Api", "Virtual Threads", "Gatherers", 
				"Optional","Static and default interface methods", "records", "sealed classes", "Http client");
		System.out.println("List of integers map(Object::toString).collect(Collectors.joining :");
		System.out.println(ints.parallelStream().map(a->a*10).map(Object::toString).collect(Collectors.joining(",")));
		
		System.out.println("\nList of integers .sorted()map(Object::toString).collect(Collectors.joining :");
		System.out.println(ints.stream().map(a->a*10).sorted().map(Object::toString).collect(Collectors.joining(",")));
		
		//flatMap example
		System.out.println("\nList of features .flatMap(s->s.chars().mapToObj(c->(char)c)):");
		System.out.println(features.stream()
				.flatMap(s->s.chars().mapToObj(c->(char)c))
				.collect(Collectors.toList()));
		
		System.out.println("\nList of features .flatMap(s->s.chars().mapToObj(c->(char)c).distinct()):");
		System.out.println(features.stream()
				.flatMap(s->s.chars().mapToObj(c->(char)c).distinct())
				.collect(Collectors.toList()));
		
		System.out.println("\n List of features words: ");
		System.out.println(features.stream()
				.flatMap(s->List.of(s.split(" ")).stream())
				.collect(Collectors.joining(",")));
		
		System.out.println("\n List of features words distinct: ");
		System.out.println(features.stream()
				.flatMap(s->List.of(s.split(" ")).stream())
				.distinct()
				.collect(Collectors.joining(",")));
		System.out.println("\n List of features words distinct sorted: ");
		System.out.println(features.stream()
				.flatMap(s->Arrays.stream(s.split(" ")))
				.distinct()
				.sorted()
				.collect(Collectors.joining(",")));
		
		//reduce examples
		System.out.println("\n List of integers .reduce((a,b)->a+b): ");
		System.out.println(ints.stream()
				.reduce((a,b)->a+b).orElse(0));
		
		System.out.println("\n List of integers .reduce(0,(a,b)->a+b): ");
		System.out.println(ints.stream()
				.reduce(0,(a,b)->a+b));
		
		System.out.println("\n List of integers .reduce(100,(a,b)->a+b): ");
		System.out.println(ints.stream()
				.reduce(100,(a,b)->a+b));
		
		System.out.println("\n List of integers .reduce(1,(a,b)->a*b): ");
		System.out.println(List.of(1,2,3,4,5,6).stream()
				.reduce(1,(a,b)->a*b));
		
		System.out.println("\n List of integers .reduce(100,(a,b)->a*b): ");
		System.out.println(List.of(1,2,3,4,5,6).stream()
				.reduce(100,(a,b)->a*b));
		
		System.out.println("\n List of integers .reduce(1,(a,b)->a*b,(a,b)->a+b): ");
		System.out.println(List.of(1,2,3,4,5,6).parallelStream()
				.reduce(1,(a,b)->{System.out.print(" "+a+"*"+b+"=> "+(a*b)); return a*b;},(a,b)->a+b));
		
		//filter
		System.out.println("\n\n List of integers .filter(i->i%2==0).collect(Collectors.toList()): ");
		System.out.println(ints.stream()
				.filter(i->i%2==0)
				.collect(Collectors.toList()));
		
		// allMatch, anyMatch, noneMatch
		System.out.println("\n List of integers .allMatch(i->i>10): ");
		System.out.println(ints.stream()
				.allMatch(i->i>10));
		
		System.out.println("\n List of integers .anyMatch(i->i>10): ");
		System.out.println(ints.stream()
				.anyMatch(i->i>10));
		
		System.out.println("\n List of integers .noneMatch(i->i>100): ");
		System.out.println(ints.stream()
				.noneMatch(i->i>100));
		
		//findFirst, findAny
		System.out.println("\n List of integers .filter(i->i>10).findFirst(): ");
		System.out.println(ints.stream()
				.filter(i->i>10)
				.findFirst().orElse(-1));
		
		System.out.println("\n List of integers .filter(i->i>10).findAny(): ");
		System.out.println(ints.stream()
				.filter(i->i>10)
				.findAny().orElse(-1));
		
		//count
		System.out.println("\n List of integers .filter(i->i>10).count(): ");
		System.out.println(ints.stream()
				.filter(i->i>10)
				.count());
		
		//max, min
		System.out.println("\n List of integers .max(): ");
		System.out.println(ints.stream()
				.max(Integer::compareTo).orElse(-1));
		
		System.out.println("\n List of integers .min(): ");
		System.out.println(ints.stream()
				.min(Integer::compareTo).orElse(0)
				);
		
		// collectors
		
		System.out.println("Collecting to map");
//		System.out.println(ints.stream()
//				.collect(Collectors.toMap(Function.identity(), Integer::intValue)));
		System.out.println(ints.stream()
				.collect(Collectors.toMap(Function.identity(), Integer::intValue, (existing,newV)->existing)));
		
		System.out.println(ints.stream()
				.collect(Collectors.toMap(Integer::intValue, Function.identity(), (existing,newV)->newV)));
		
		System.out.println(IntStream.range(0, ints.size()).boxed().collect(Collectors.toMap(i->i, ints::get)));
		
		// collectors grouping by
		ints.stream()
				.collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
				.entrySet().stream()
				.sorted(Map.Entry.comparingByValue()).forEach(System.out::print);
		
		
		
		
		
		
		
		
	}

}
