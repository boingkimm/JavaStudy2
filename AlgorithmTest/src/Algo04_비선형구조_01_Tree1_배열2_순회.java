import java.util.Scanner;

/*
 * <이진 트리 (binary tree) - 배열 > 순회
 * 
 		전위 순회 pre-order: root-left-right
		중위 순회 in-order: left-root-right
		후위 순회 post-order: left-right-root
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

public class Algo04_비선형구조_01_Tree1_배열2_순회 {

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
		
		
		//순회 : 재귀함수 이용
		order(0); //루트노드(0)
		
		
	}//end main

	//순회
	private static void order(int x) {
		//자식 여부 확인
		if (tree[x][0]== -1 && tree[x][1]== -1) { //자식이 없는 경우
			System.out.print(x+ " ");
			
		}else { //자식이 있는 경우
//			System.out.print("전위: " + x + " ");  //전위: 0 전위: 1 3 4 전위: 2 5 
			if (tree[x][0]!= -1) { //왼쪽 자식이 있는 경우
				order(tree[x][0]); //재귀. order함수 호출해서 order함수 안에서 또 order함수 호출. 왼쪽 자식을 계속
			}
//			System.out.print(x + " "); //중위 - 3 1 4 0 2 5 
			if (tree[x][1]!= -1) { //오른쪽 자식이 있는 경우
				order(tree[x][1]);
			}
			System.out.print(x + " "); //후위 - 3 4 1 5 2 0 
		}
		
	}
}
