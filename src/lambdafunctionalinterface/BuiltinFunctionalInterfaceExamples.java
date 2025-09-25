package lambdafunctionalinterface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class BuiltinFunctionalInterfaceExamples {
	public static void main(String[] args) {

		Supplier<Double> rndNumber = ()->Math.random()*1000;
		System.out.println("rndNumber: "+rndNumber.get());
		
		Consumer<String> strLen = (s)->System.out.println(s+": "+s.length());
		strLen.accept("null");
		BiConsumer<String,String> strConcat = (s1,s2)->System.out.println(s1+": "+s2);
		strConcat.accept("hello","world");
		
		
		
		Function<String, String> stringBrokenInTwo= (str)->str.substring(0,(str.length())/2)+";"+str.substring((str.length())/2);
		System.out.println(stringBrokenInTwo.apply("Hello"));
		System.out.println(stringBrokenInTwo.apply("Hi"));
		
		BiFunction<String,String,String> stringCombinedUsingDelimeter = (st1,st2)->st1+";"+st2;
		System.out.println(stringCombinedUsingDelimeter.apply("nu", "ll"));
		System.out.println(stringCombinedUsingDelimeter.apply("Hello", "World"));
		
		
		Predicate<String> stringOddLength = (str)->str.length()%2!=0;
		System.out.println(stringOddLength.test("hello"));
		System.out.println(stringOddLength.test("hi"));
		BiPredicate<String,String> bothStringOddLength = (st1,st2)->st1.length()%2!=0&&st2.length()%2!=0;
		System.out.println(bothStringOddLength.test("hello","world"));
		System.out.println(bothStringOddLength.test("hi","world"));
		
		
		UnaryOperator<String> strToLowercase = (str)->str.toLowerCase();
		System.out.println(strToLowercase.apply("HeLLO"));
		System.out.println(strToLowercase.apply("HI"));
		
		BinaryOperator<String> spacedWords = (st1, st2)->st1+" "+st2;
		System.out.println(spacedWords.apply("Hello", "World"));
		System.out.println(spacedWords.apply("Java", "Programming"));


		// Functional interface convenience methods
		
		
		Predicate<String> even = (s)->s.length()%2==0;
		Predicate<String> lenmorethan3 = (s)->s.length()>3;
		System.out.println(even.and(lenmorethan3).test("hello"));
		System.out.println(even.or(lenmorethan3).test("hi"));
		System.out.println(even.negate().test("hello"));
		System.out.println(even.and(lenmorethan3).negate().test("hello"));
		
		Consumer<String> toL = (s)->System.out.println(s.toLowerCase());
		Consumer<String> toU = (s)->System.out.println(s.toUpperCase());
		toL.andThen(toU).accept("Hello");
		
		Function<String, String> toLwc = (s)->s.toLowerCase();
		Function<String, String> cnct = (s)->s+"!!!";
		System.out.println(toLwc.andThen(cnct).apply("Hello"));
		System.out.println(toLwc.compose(cnct).apply("Hello"));
		
		BiFunction<String, String, String> bfTlwcs = (s1,s2)->s1.toLowerCase()+s2.toLowerCase();
		System.out.println(bfTlwcs.andThen(cnct).apply("Hello", "World"));
		
		// Functional interfaces for primitive types
		// IntFunction, IntConsumer, IntPredicate, IntSupplier, IntUnaryOperator, IntBinaryOperator
		// LongFunction, LongConsumer, LongPredicate, LongSupplier, LongUnaryOperator, LongBinaryOperator
		// DoubleFunction, DoubleConsumer, DoublePredicate, DoubleSupplier, DoubleUnaryOperator, DoubleBinaryOperator
		IntPredicate evenInt = (i)->i%2==0;
		System.out.println(evenInt.test(10));
		System.out.println(evenInt.test(11));
		
		IntConsumer printInt = (i)->System.out.println("Value: "+i);
		printInt.accept(100);
		
		DoubleSupplier randomDouble = ()->Math.random()*100;
		System.out.println("Random Double: "+randomDouble.getAsDouble());
		
		//ToIntFunction, ToLongFunction, ToDoubleFunction
		//ObjDoubleFunction, ObjIntFunction, ObjLongFunction
		//ToIntBiFunction, ToLongBiFunction, ToDoubleBiFunction
		//IntToDoubleFunction, IntToLongFunction, LongToIntFunction, LongToDoubleFunction, DoubleToIntFunction, DoubleToLongFunction
		//IntToObjFunction, LongToObjFunction, DoubleToObjFunction
		ToIntFunction<String> strLen2 = (s)->s.length();
		System.out.println(strLen2.applyAsInt("Hello"));
		ToIntFunction<String> strLen3 = String::length;
		System.out.println(strLen3.applyAsInt("Hello"));
		ToIntFunction<Double> doubleToInt = Double::intValue;
		System.out.println(doubleToInt.applyAsInt(99.99));
		

	}

}
