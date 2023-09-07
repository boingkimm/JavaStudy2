package exam02;

import java.util.function.Consumer;

public class MethodReferenceTest4 {

	public static void main(String[] args) {

		//메서드 참조(method reference)

		
		//4. System.out.println 메서드 method reference
		
		//파라미터 있고 리턴타입 없음 (출력만 하면 끝) => Consumer
		
		//익명클래스
		Consumer<String> c = new Consumer<String>() {
			
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		
		//람다표현식
		Consumer<String> c2 = t -> System.out.println(t);
		
		//method reference
		Consumer<String> c3 = System.out::println;  //매우 중요 ***
		
		c2.accept("홍길동");

		
	}

}
