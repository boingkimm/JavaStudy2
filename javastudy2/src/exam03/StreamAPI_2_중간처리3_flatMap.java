package exam03;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI_2_중간처리3_flatMap {

	public static void main(String[] args) {
		
		//중간처리 - 가공처리
		//flatMap(Function<T,Stream>)
		//요소를 가공하여 복수개의 요소들로 구성된 새로운 스트림을 반환
		
		List<String> list = Arrays.asList("hello world", "happy virus");
		
		//실습1: 공백문자 기준으로 분리
		Function<String, Stream<? extends String>> mapper
		= new Function<String, Stream<? extends String>>() {

			@Override
			public Stream<? extends String> apply(String t) {
				String [] names = t.split(" ");
				return Arrays.stream(names);
			}

		};
		
		list.stream()
				.flatMap(mapper)   //new 해서 생성 후 잘라내서 위에 변수 작성
				.forEach(System.out::println);
		
		System.out.println();
		
		
		//람다표현식
		list.stream()
				.flatMap(t->Arrays.stream(t.split(" ")))
				.forEach(System.out::println);
		
		System.out.println();
		
		
		
		//실습2: 쉼표 기준으로 분리 + 정수값으로 출력
		List<String> list2 = Arrays.asList("10,20,30", "40,50,60");
		
		//익명클래스
		Function<String, IntStream> mapper2 = new Function<String, IntStream>() {
			@Override
			public IntStream apply(String t) {
				String [] arr = t.split(",");
				//String [] --> int [] ***자주 사용됨 (문자열배열을 숫자배열로)
				int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
				return Arrays.stream(nums);
			}
		};
		
		list2.stream()
				.flatMapToInt(mapper2)
				.forEach(System.out::println);
		
		System.out.println();
		
		
		//람다표현식
		list2.stream()
				.flatMapToInt(t->Arrays.stream(Arrays.stream(t.split(",")).mapToInt(Integer::parseInt).toArray()))
				.forEach(System.out::println);
		
		
		
		
	}

}
