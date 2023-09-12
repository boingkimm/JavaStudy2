import java.util.Scanner;

/*
 * <이진 트리 (binary tree) - 배열 >
 * 
 *      0
 *     / \ 
 *    1   2
 *   / \   \
 *  3   4   5
 *  
 *  입력:
		6
		0  1  2
		1  3  4
		2 -1  5
		3 -1 -1
		4 -1 -1
		5 -1 -1
 * (자식 없음: -1)
 */

public class Algo04_비선형구조_01_Tree1_배열1_생성 {

	static int n; //노드 개수
	static int [][] tree; //노드 저장 위한 2차원 배열
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  //스캐너로 입력받기
		//1. 노드 개수 입력 = 6
		//2. 노드 값 + 자식 노드 값 입력 = 0 1 2 / ... 
		n = sc.nextInt();
		
		//2차원 배열 생성
		tree = new int[n][2]; //행 6개(데이터 개수), 열 2개(이진 트리. 0왼쪽 자식, 1오른쪽 자식)
		//n번 반복해서 읽어 들이기
		for (int i = 0; i < n; i++) {
			//0 1 2
			int x = sc.nextInt(); //0
			int l_child = sc.nextInt(); //1
			int r_child = sc.nextInt(); //2
			//트리에 저장
			tree[x][0]=l_child;
			tree[x][1]=r_child;
			
		}
		
		//2차원 배열 출력
		for (int i = 0; i < tree.length; i++) {
			for (int j = 0; j < tree[i].length; j++) {
				System.out.println(i+"값의 자식: " + tree[i][j]);
			}
		}
		
		
		/*
		 * 입력:
		 *  6
		 *  0  1  2
		 *  1  3  4
		 *  2 -1  5
		 *  3 -1 -1
		 *  4 -1 -1
		 *  5 -1 -1
		 *  
		 *  출력:
		 *  0값의 자식: 1
		 *  0값의 자식: 2
		 *  1값의 자식: 3
		 *  1값의 자식: 4
		 *  2값의 자식: -1
		 *  2값의 자식: 5
		 *  3값의 자식: -1
		 *  3값의 자식: -1
		 *  4값의 자식: -1
		 *  4값의 자식: -1
		 *  5값의 자식: -1
		 *  5값의 자식: -1
		 */
	}

}
