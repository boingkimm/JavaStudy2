import java.util.Arrays;

/*
 * 삽입 정렬 ( insertion sort )
 * 인덱스 1(두번째)의 원소부터 앞 방향으로 들어갈 위치를 찾아 교환한다. ==> 데이터 9개 : round8까지 반복
	1. 현재 타겟이 되는 숫자와 이전 위치에 있는 원소들을 비교한다. (첫 번째 타겟은 두 번째 원소부터 시작)
	2. 타겟이 되는 숫자가 이전 위치에 있던 원소보다 작으면 위치를 서로 교환한다.
	3. 그 다음 타겟을 찾아 위 작업을 반복한다. 
 */

public class Algo05_정렬_02_삽입정렬_InsertionSort {
	
	//교환 메서드 - swap 함수
	public static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
		}
	
	//정렬할 메서드
	public static void insertion_sort(int [] arr, int size) {
		
		//2번째부터 시작
		for (int i = 0; i < size; i++) {
System.out.printf("%d 라운드 -", i);
			//이전 요소와 비교하므로 j 감소시킴
			for (int j = i; j > 0; j--) {
System.out.print(" 타겟값:" + arr[j]);
				if (arr[j-1] > arr[j]) {  //이전 요소값보다 작으면 교환
System.out.print(" 이전값:" + arr[j-1]);
					swap(arr, j-1, j);
				}
System.out.println(" 교환결과:" + Arrays.toString(arr));
			}
		}
	}//end insertion_sort
	
	//정렬할 데이터 저장
	static int [] arr = {7,3,2,8,9,4,6,1,5};
	
	public static void main(String[] args) {

		int size = arr.length;
		insertion_sort(arr, size);
		
		//정렬된 값 출력
		for (int x : arr) {
			System.out.print(x + " ");  //1 2 3 4 5 6 7 8 9 
		}
	}
}
