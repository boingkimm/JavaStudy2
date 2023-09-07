package exam03;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamAPI_2_중간처리5_boxed_asXXXstream {

	public static void main(String[] args) {
		
		//중간처리
				
		/*
		 * boxed() : 기본형 -> 참조형
		 * 
		 * asDoubleStream() : IntStream -> DoubleStream
		 * 										LongStream -> DoubleStream
		 * (Double -> X )
		 * 
		 */

		int [] arr = {1,2,3,4,5};
		
		//가. boxed() : int --> Integer
		IntStream s = Arrays.stream(arr);
		s.boxed()
		 .forEach(System.out::println); //Integer로 출력됨
		
		//나. asDoubleStream() : 정수 --> 실수
		Arrays.stream(arr)
					.asDoubleStream()
					.forEach(System.out::println);
		
	}

}
