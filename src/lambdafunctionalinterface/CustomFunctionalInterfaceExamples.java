package lambdafunctionalinterface;


@FunctionalInterface
interface TriFunction<T,U,V,R>{
	R apply(T t, U u, V v);
}

@FunctionalInterface
interface QuadFunction<T,U,V,W,R>{
	R concat(T t, U u, V v, W w);
}

public class CustomFunctionalInterfaceExamples {
	public static void main(String[] args) {
		TriFunction<String, String, String, String> concatThreeStrings = (s1,s2,s3)->s1+";"+s2+";"+s3;
		System.out.println(concatThreeStrings.apply("Hello", "World", "!!!"));
		System.out.println(concatThreeStrings.apply("Java", "Programming", "Language"));
		
		
		QuadFunction<String, String, String, String, String> concatFourStrings = (s1,s2,s3,s4)->s1+ " " + s2+ " " + s3 + " " + s4;
		System.out.println(concatFourStrings.concat("Concat", "Four", "Different", "Strings"));
		System.out.println(concatFourStrings.concat("Java", "is", "awsome", "programming language"));
	}

}
