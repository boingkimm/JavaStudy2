package exam02;

import java.util.function.BinaryOperator;
import java.util.function.Function;

class  Calculator3{
	//static 메서드
	public static int methodA(int x, int y) {
		return x+y;
	}
}


public class MethodReferenceTest3 {

	public static void main(String[] args) {

		//메서드 참조(method reference)

		
		//3. static 메서드 호출  method reference
		
		//가. 파라미터 있고 리턴타입 있음  => Function, Operator(파라미터타입=리턴타입)
		//가-1
		//익명클래스
		BinaryOperator<Integer> x = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return Calculator3.methodA(t, u);
			}
		};
		
		//람다표현식
		BinaryOperator<Integer> x2 = (t,u)-> Calculator3.methodA(t, u);
		
		//method reference
		BinaryOperator<Integer> x3 = Calculator3::methodA;  //클래스명::메서드명
		
		int result = x3.apply(100, 200);
		System.out.println(result);
		
		
		////////////////////////////////////////////////////
		
		//가-2. API클래스: static 메서드(Integer.parseInt***)를 사용하는 경우 ***
		
		//int xxx = Integer.parseInt("10") ===> Function
		
		//익명클래스
		Function<String, Integer> y = new Function<String, Integer>() {
			
			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t);
			}
		};
		
		//람다표현식
		Function<String, Integer> y2 = t -> Integer.parseInt(t);
		
		//method reference *** 
		Function<String, Integer> y3 = Integer::parseInt; //클래스명::메서드명 ***
		
		int result2 = y3.apply("10");
		System.out.println(result2);
		
		
		
		
	}

}
