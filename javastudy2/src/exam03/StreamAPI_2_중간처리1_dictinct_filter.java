package exam03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPI_2_중간처리1_dictinct_filter {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("홍길동", "이순신", "유관순", "이순신", "이야호");

		//중간처리
		//1. distinct : 중복 제거
		list.stream().distinct()   //스트림에서 중복 제거됨 (Set에 저장하지 않고도 중복 제거할 수 있게 됨)
			.forEach(System.out::println);
		
		System.out.println();
		
		
		//2. filter : 필터링
		//익명함수
		Predicate<String> predicate = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.startsWith("이");
			}
		};
		
		list.stream().filter(predicate)   // 나오는거 보고 익명함수 작성하면 됨!!
			.forEach(System.out::println);
		
		System.out.println();
		
		//람다표현식
		list.stream().filter(t->t.startsWith("이"))
			.forEach(System.out::println);

		System.out.println();
		
		
		//3. distinct + filter 혼합  (순서 상관 X)
		list.stream()
				.distinct()
				.filter(t->t.startsWith("이"))
				.forEach(System.out::println);

		
		
	}

}
