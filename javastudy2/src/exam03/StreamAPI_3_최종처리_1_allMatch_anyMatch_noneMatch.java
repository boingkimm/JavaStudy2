package exam03;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class StreamAPI_3_최종처리_1_allMatch_anyMatch_noneMatch {

	public static void main(String[] args) {
		
		//최종처리
				
		/*
		 * 최종처리 단계에서 요소들이 특정 조건에 만족여부 확인
		 * 
		 * 가. allMatch(Predicate) : 모든 요소들이 Predicate 조건에 일치하는지 확인
		 * 나. anyMatch(Predicate) : 일부 요소들이 Predicate 조건에 일치하는지 확인
		 * 다. noneMatch(Predicate) : 모든 요소들이 Predicate 조건에 일치하지 않는지 확인
		 * 
		 * => 최종 결과는 boolean값으로 반환
		 * 
		 */

		int [] arr = {1,2,3,4,5};
		
		//가. allMatch(Predicate)
		
		//익명클래스
		IntPredicate predicate = new IntPredicate() {
			@Override
			public boolean test(int t) {
				return t<10;
			}
		};
		boolean result = Arrays.stream(arr).allMatch(predicate);
		System.out.println("모든 요소가 10보다 작은가: " + result);
		
		//람다표현식
		result = Arrays.stream(arr).allMatch(t-> t<10);
		System.out.println("모든 요소가 10보다 작은가: " + result);
		
		
		
		//나. anyMatch(Predicate)
		
		boolean result2 = Arrays.stream(arr).anyMatch(t->t%3==0);
		System.out.println("요소 중에 3의 배수가 있는가: " + result2);
		
		
		
		//다. noneMatch(Predicate)	
		
		boolean result3 = Arrays.stream(arr).noneMatch(t->t%3==0);
		System.out.println("모든 요소 중에 3의 배수가 없는가: " + result3);
		
	}

}
