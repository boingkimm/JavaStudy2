package exam02;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;

public class FunctionTest {

	public static void main(String[] args) {

		//다. Function<T,R> 인터페이스 ****
		// 파라미터O 리턴값O
		// R apply(T t)

		// 1. 파라미터 1개
		//익명클래스
		Function<String, Integer> f = new Function<String, Integer>() {

			@Override
			public Integer apply(String t) {
				return t.length();
			}
		};
		int n = f.apply("홍길동");
		System.out.println("문자열 길이: " + n);
		
		//람다표현식
		Function<String, Integer> f2 = t -> t.length();
		int n2 = f2.apply("세종");
		System.out.println("람다표현식 문자열 길이: " + n2);
		
		
		//////////////////////////////////////////////////////
		//IntFunction<R> - R apply(int value)
		
		IntFunction<Integer> x = new IntFunction<Integer>() {

			@Override
			public Integer apply(int value) {
				return value*2;
			}
		};
		int n3 = x.apply(100);
		System.out.println("값: " + n3);
		
		//람다표현식
		IntFunction<Integer> x2 = value -> value*2;
		int n4 = x2.apply(150);
		System.out.println("람다표현식 값: " + n4);
		
		
		
		
		//////////////////////////////////////////////////////
		// 2. 파라미터 2개  : <파라미터1, 파라미터2, 리턴값>
		BiFunction<String, Integer, String> k = new BiFunction<String, Integer, String>() {
			
			@Override
			public String apply(String t, Integer u) {
				return t.substring(0, u);
			}
		};
		String sub = k.apply("HelloWorld", 5);
		System.out.println("부분열: " + sub);
		
		//람다표현식
		BiFunction<String, Integer, String> k2 = (t, u)-> t.substring(0, u);
		String sub2 = k2.apply("HelloWorld", 6);
		System.out.println("람다표현식 부분열: " + sub2);
	}

}
