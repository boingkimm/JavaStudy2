package exam02;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

public class ConsumerTest2 {

	public static void main(String[] args) {

		//가. Consumer<T> 인터페이스
		// 파라미터O 리턴값X
		// accept(T) 메서드 처리
		
		//파라미터가 2개인 경우

		//익명클래스
		BiConsumer<String, Integer> x = new BiConsumer<String, Integer>() {
			
			@Override
			public void accept(String t, Integer u) {
				System.out.println("BiConsumer: " + t +"\t"+ u);
			}
		};
		x.accept("홍길동", 10);
		
		//람다표현식
		BiConsumer<String, Integer> x2 = (t, u)-> {
			System.out.println("람다표현식 BiConsumer: " + t +"\t"+ u);
		};
		x2.accept("유관순", 20);
		
		
		///////////////////////////////////////
		//ObjIntConsumer<T>
		
		//익명클래스
		ObjIntConsumer<String> y = new ObjIntConsumer<String>() {
			
			@Override
			public void accept(String t, int value) {
				System.out.println("ObjIntConsumer: " + t +"\t"+ value);
			}
		};
		y.accept("홍길동", 10);
		
		//람다표현식
		ObjIntConsumer<String> y2 = (t, value) -> {
			System.out.println("람다표현식 ObjIntConsumer: " + t +"\t"+ value);
		};
		y2.accept("유관순", 20);

		
		///////////////////////////////////////
		//ObjDoubleConsumer<T>
		//ObjLongConsumer<T>
		
	}

}
