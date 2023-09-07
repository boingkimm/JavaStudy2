package exam03;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class StreamAPI_3_최종처리_2_sum_average_max_min_count {

	public static void main(String[] args) {
		
		//최종처리
				
		/*
		 * 통계처리
		 * 
		 * IntStream, LongStream, DoubleStream의 집계 메서드
		 * 
		 */

		int [] arr = {1,2,3,4,5};
		
		//가. sum() : 합계
		int sum = Arrays.stream(arr)
										.sum();
		System.out.println("합계: " + sum);
		
		sum = Arrays.stream(arr)
								.filter(n->n%2==0)
								.sum();
		System.out.println("짝수의 합계: " + sum);
		
		
		//나. average() : 평균
		double avg = Arrays.stream(arr)
											 .average()
											 .orElse(0.0);
		System.out.println("평균: " + avg);
		
		avg = Arrays.stream(arr)
								.filter(n->n%2==0)
								.average()
								.orElse(0.0);
		System.out.println("짝수의 평균: " + avg);	
		
		
		//다. max() : 최대
		int max = Arrays.stream(arr)
										.max()
										.orElse(0);
		System.out.println("최대값: " + max);


		//라. min() : 최소
		int min = Arrays.stream(arr)
										.min()
										.orElse(0);
		System.out.println("최소값: " + min);


		//마. count() : 개수 
		long count= Arrays.stream(arr)
											.count();
		System.out.println("개수: " + count);


	}

}
