package exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class StreamAPI_4_Optional {

	public static void main(String[] args) {
		
		/*
		 * OptionalInt, OptionalDouble, OptionalLong
		 * 
		 * 컬렉션에 값이 없을 경우 집계 메서드를 사용 시 예외 발생
		 * => Optional : 예외 발생 방지 + 기본값 설정
		 * 
		 */
		
		//1. 컬렉션에 값이 존재하는 경우
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(25);
		
		OptionalDouble avg = list.stream()
														 .mapToDouble(a->a) //리턴타입 더블(10,25을 더블로)
														 .average();
		
		System.out.println(avg);							  //OptionalDouble[17.5]
		System.out.println(avg.getAsDouble());	//17.5
		System.out.println(avg.orElse(0.0));		//값 있으면 반환, 없으면 예외 발생 대신 기본값(0.0) => 17.5
		
		
		//2. 컬렉션에 값이 없는 경우
		List<Integer> list2 = new ArrayList<Integer>();
		//값이 없음
		
		OptionalDouble avg2 = list2.stream()
															 .mapToDouble(a->a)
															 .average();
		
		System.out.println(avg2);							  //OptionalDouble.empty
//	System.out.println(avg2.getAsDouble());	//예외 발생 (No value present)
		System.out.println(avg2.orElse(0.0));		//값 있으면 반환, 없으면 예외 발생 대신 기본값(0.0) => 0.0
		

	}

}
