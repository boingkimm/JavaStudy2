package exam02;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.omg.CORBA.portable.ValueBase;

public class PredicateTest {

	public static void main(String[] args) {

		//마. Predicate 인터페이스 ****
		// 파라미터O 리턴값O
		// 리턴값 무조건 boolean



		// 1. 파라미터 1개
		
		Predicate<String> p = new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				return t.length()==5;
			}
		};
		boolean result = p.test("hello");
		System.out.println("결과: " + result);
		
		//람다표현식
		Predicate<String> p2 = t -> t.length()==5;
		boolean result2 = p2.test("hellooo");
		System.out.println("결과: " + result2);
		
		
		////////////////////////////////////
		//IntPredicate 
		IntPredicate pp = new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				return value>10;
			}
		};
		boolean result3 = pp.test(5);
		System.out.println("결과: " + result3);
		
		//람다표현식
		IntPredicate pp2 = value -> value>10;
		boolean result4 = pp2.test(15);
		System.out.println("결과: " + result4);
		
		
		////////////////////////////////////
		//2. 파라미터 2개
		
		BiPredicate<String, Integer> a = new BiPredicate<String, Integer>() {
			
			@Override
			public boolean test(String t, Integer u) {
				return t.length()==u;
			}
		};
		boolean result5 = a.test("hello", 5);
		System.out.println("결과: " + result5);
		
		//람다표현식
		BiPredicate<String, Integer> aa = (t,u)->t.length()==u;
		boolean result6 = aa.test("helloooo", 5);
		System.out.println("결과: " + result6);
		
	}

}
