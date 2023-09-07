package exam02;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

class  Calculator2{
	//인스턴스 메서드
	public int methodA(int x, int y) {
		return x+y;
	}
}


public class MethodReferenceTest2 {

	public static void main(String[] args) {

		//메서드 참조(method reference)

		
		//2. 인스턴스 메서드 호출 method reference
		
		//가. 파라미터 있고 리턴타입 있음  => Function, Operator(파라미터타입=리턴타입)
		//가-1
		//익명클래스
		Calculator2 c = new Calculator2();
		BinaryOperator<Integer> x = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return c.methodA(t,u);
			}
		};
		
		//람다표현식
		BinaryOperator<Integer> x2 = (t,u)-> c.methodA(t,u);
		
		//method reference
		BinaryOperator<Integer> x3 = c::methodA;  //변수명::메서드명
		
		int result = x3.apply(100, 200);
		System.out.println(result);
		
		
		////////////////////////////////////////////////////
		
		//가-2. API클래스: String 클래스의 인스턴스 메서드(toUpperCase)를 사용하는 경우 ***
		//익명클래스
		UnaryOperator<String> y = new UnaryOperator<String>() {
			
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		};
		
		//람다표현식
		UnaryOperator<String> y2 = t -> t.toUpperCase();
		
		//method reference
		UnaryOperator<String> y3 = String::toUpperCase; //String 객체생성X, 클래스명::메서드명
		
		String result2 = y3.apply("hello");
		System.out.println(result2);
		
		
		
		
	}

}
