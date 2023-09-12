import java.util.Arrays;

/*
 * 선택정렬  ( selection sort )
 * 제일 작은 원소의 위치를 찾아서 맨 처음 위치와 바꾼다. ==> 데이터 9개 : round8까지 반복
	1. 주어진 리스트에서 최소값을 찾는다.
	2. 최소값을 맨 앞 자리의 값과 교환한다.
	3. 맨 앞 자리를 제외한 나머지 값들 중 최소값을 찾아 위 방법으로 반복한다. 
 */

public class Algo05_정렬_01_선택정렬_SelectionSort {
	
	//교환 메서드 - swap 함수
	public static void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
		}
	
	//정렬할 메서드
	public static void selection_sort(int [] arr, int size) {
		
		for (int i = 0; i < size-1; i++) { //마지막 회차는 반복할 필요 없음
System.out.printf("%d 라운드 - ", i+1);
			int minIdx = i;
			//최소값 찾기
			for (int j = i+1; j < size; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
System.out.printf("교환 위치:" + i + " 값:" + arr[i]);
System.out.println(" 최소값:" + arr[minIdx]);
			//i번째 값과 찾은 최소값(minIdx)을 서로 교환
			swap(arr, i, minIdx);
System.out.println(Arrays.toString(arr));
		}
	}//end selection_sort
	
	//정렬할 데이터 저장
	static int [] arr = {7,3,2,8,9,4,6,1,5};
	
	public static void main(String[] args) {

		int size = arr.length;
		selection_sort(arr, size);
		
		//정렬된 값 출력
		for (int x : arr) {
			System.out.print(x + " ");  //1 2 3 4 5 6 7 8 9 
		}
	}
}
