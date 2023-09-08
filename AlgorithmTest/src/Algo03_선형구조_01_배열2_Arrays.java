import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Algo03_선형구조_01_배열2_Arrays {

	public static void main(String[] args) {

		//Arrays 클래스
		
		//1. 리스트 생성
		List<String> list = Arrays.asList("A","B");
		
		//2. 임의값으로 채우기
		String [] name = {"A", "B", "C"};
		Arrays.fill(name, "x");
		System.out.println("2. 임의값으로 채우기: " + Arrays.toString(name));  //[x, x, x]

		//일부분 (0부터 2 전까지)
		Arrays.fill(name, 0, 2, "a");
		System.out.println("2. 일부분 임의값으로 채우기: " + Arrays.toString(name));  //[a, a, x]
		
		//3. 배열값 비교
		int [] n = {1,2,3};
		int [] n2 = {1,2,3};
		System.out.println("3. 배열값 비교: " + Arrays.equals(n, n2));  //true
		
		//4. 정렬
		int [] n3 = {6,2,7,98,24};
		Arrays.sort(n3);  //기본은 오름차순
		System.out.println("4. 오름차순 정렬: " + Arrays.toString(n3));  // [2, 6, 7, 24, 98]

		Integer [] n33 = {6,2,7,98,24};  //Comparator.reverseOrder 사용하기 위해서는 클래스타입이어야 함.
		Arrays.sort(n33, Comparator.reverseOrder());  //내림차순
		System.out.println("4. 내림차순 정렬: " + Arrays.toString(n33));  // [98, 24, 7, 6, 2]
		
		//5. 특정값의 위치 검색
		int [] n4 = {6,2,7,98,24};
		int idx = Arrays.binarySearch(n4, 98);
		System.out.println("5. 특정값의 위치 검색: " + idx);  //3
		
		//6. 배열 크기 변경 => 기본값 추가
		int [] n5 = {1,2,3};
		n5 = Arrays.copyOf(n5, 5);
		System.out.println("6. 배열 크기 변경: " + Arrays.toString(n5));  //[1, 2, 3, 0, 0]
		
		//7. 배열에서 스트림 생성
		int [] n6 = {1,2,3};
		Arrays.stream(n6).forEach(System.out::println);
		
		
		
	}
	

}
