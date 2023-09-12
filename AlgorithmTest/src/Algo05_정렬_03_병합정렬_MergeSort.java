import java.util.Arrays;

/*
 * 병합 정렬 ( merge sort )
 * 분할정복 알고리즘 (divide and conquer)
	1. 주어진 배열을 절반으로 분할하여 부분 배열로 나눈다. ( divide: 분할 )
	2. 해당 부분 배열의 길이가 1이 될 때까지 반복한다.
	3. 인접한 부분배열끼리 정렬하여 합친다. ( conquer: 정복 )
 */

public class Algo05_정렬_03_병합정렬_MergeSort {

	//분할 작업
	public static void merge_sort(int [] arr, int left, int right) {
		
		//개수가 1인 경우 : 더 이상 분할 불가, 중단
		if (left == right) return;
		
		int mid = (left+right)/2;
System.out.println(Arrays.toString(Arrays.copyOfRange(arr, left, mid+1))+" "
									+Arrays.toString(Arrays.copyOfRange(arr, mid+1, right+1)));
		merge_sort(arr, left, mid);    //왼쪽 서브 배열 분할 8,2,6,4
		merge_sort(arr, mid+1, right); //오른쪽 서브 배열 분할 7,3,9,5
		
		/*
		[8, 2, 6, 4] [7, 3, 9, 5]
		[8, 2] [6, 4]
		[8] [2]
		[6] [4]
		[7, 3] [9, 5]
		[7] [3]
		[9] [5]
		 */
	
		//병합 작업
		merge(arr, left, mid, right);
		
	}//end merge_sort
	
	
	
	//정렬하면서 병합할 때 필요한 임시 배열
	static int [] sorted = null;

	//병합 메서드
	public static void merge(int [] arr, int left, int mid, int right) {
		
		sorted = new int[arr.length]; //기존 배열과 길이 같음
		
		//변수에 저장
		int l = left;		 //왼쪽 부분 배열의 시작점
		int r = mid + 1; //오른쪽 부분 배열의 시작점
		int idx = left;	 //sorted 배열에 저장하기 위한 배열의 인덱스
		
		while (l <= mid && r <= right) {
			//왼쪽 배열과 오른쪽 배열 비교해서 작은 값을 sorted에 먼저 저장
			if (arr[l] <= arr[r]) {  
				sorted[idx] = arr[l];
				idx++;
				l++;
			}else {
				sorted[idx] = arr[r];
				idx++;
				r++;
			}
			
		}//end while
		
		if (l > mid) { //왼쪽 배열이 모두 sorted 배열에 채워진 경우 (l > mid)
			//오른쪽 배열이 남아있는 경우
			while (r <= right) {
				sorted[idx] = arr[r];
				idx++;
				r++;
			}
		}else {				//오른쪽 배열이 모두 sorted 배열에 채워진 경우 (r > right)
			//왼쪽 배열이 남아있는 경우
			while (l <= mid) {
				sorted[idx] = arr[l];
				idx++;
				l++;
			}
		}	
		
		//임시 배열값을 원본 배열에 복사하기
		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
		
	}//end merge
	
	
	//정렬할 데이터 저장
	static int [] arr = {8,2,6,4,7,3,9,5};
	
	public static void main(String[] args) {

		merge_sort(arr, 0, arr.length-1);
		
		//정렬된 값 출력
		for (int x : arr) {
			System.out.print(x + " ");  //2 3 4 5 6 7 8 9 
		}
	}
}
