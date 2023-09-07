package exam02;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class OperatorTest {

	public static void main(String[] args) {

		//라. Operator 인터페이스
		// 파라미터O 리턴값O


		// 1. 파라미터 1개
		//익명클래스
		UnaryOperator<String> x = new UnaryOperator<String>() {
			
			@Override
			public String apply(String t) {
				return t+"~";
			}
		};
		String x2 = x.apply("hello");
		System.out.println("값: " + x2);
		
		//람다표현식
		UnaryOperator<String> y = t-> t+"~~~";
		String y2 = y.apply("world");
		System.out.println("값: " + y2);
		
		
		////////////////////////////////////
		//IntUnaryOperator 
		IntUnaryOperator k = new IntUnaryOperator() {
			
			@Override
			public int applyAsInt(int operand) {
				return operand*2;
			}
		};
		int k2 = k.applyAsInt(100);
		System.out.println("값: " + k2);

		//람다표현식
		IntUnaryOperator z = operand -> operand*2;
		int z2 = z.applyAsInt(200);
		System.out.println("값: " + z2);

		
		
		////////////////////////////////////
		//2. 파라미터 2개
		BinaryOperator<Integer> kkk = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return t+u;
			}
		};
		int kkk2 = kkk.apply(100, 200);
		System.out.println("값: " + kkk2);
		
		//람다표현식
		BinaryOperator<Integer> zzz = (t,u) -> t+u;
		int zzz2 = zzz.apply(100, 123);
		System.out.println("값: " + zzz2);

	}

}
