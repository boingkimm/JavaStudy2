package exam03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamAPI_1_스트림생성 {

	public static void main(String[] args) {
		
		//1. 컬렉션에서 stream 생성
		
		List<String> list = Arrays.asList("홍길동", "이순신", "유관순");
		Stream<String> s = list.stream();  //스트림 생성
		System.out.println("스트림 요소 개수: " + s.count());
		
		
		//1-1
		Consumer<String> c = new Consumer<String>() {
			
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		
		//s.forEach(c);  ==> 에러! stream has already been operated ( count에서 stream 다 사용함 )
		list.stream().forEach(c);  //다시 얻어와야 함 ==> //홍길동 //이순신 //유관순

		
		//1-2 람다표현식
		list.stream().forEach(t->System.out.println(t));
		
		//1-3 method reference (사용 권장)
		list.stream().forEach(System.out::println);
		
		
		System.out.println("###############");
		
		
		//2. 배열에서 stream 생성
		String [] names = {"고양이", "강아지", "병아리"};
		
		Stream<String> x = Stream.of(names);  //names를 스트림으로 생성
		x.forEach(System.out::println);
		
		Stream<String> x2 = Arrays.stream(names);
		x2.forEach(System.out::println);
		
		
		System.out.println("###############");

		
		//3. 리터럴에서 stream 생성
		Stream<String> y = Stream.of("고양이", "강아지", "병아리");
		y.forEach(System.out::println);
		
		Stream<Integer> y2 = Stream.of(10,20,30);
		y2.forEach(System.out::println);
		
		
		
		
	}

}
