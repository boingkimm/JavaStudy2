import java.util.Scanner;

/*
 * <이진 트리 (binary tree) - 연결리스트>
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

//가. 각 노드를 저장하는 클래스를 생성
class Node{
	int data;   //노드 값
	Node left;  //왼쪽 자식 노드를 참조
	Node right; //오른쪽 자식 노드를 참조
	
	public Node(int data) {
		//노드 값 초기화
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
		
}//end Node


public class Algo04_비선형구조_01_Tree2_연결리스트1_생성 {

	//다. Node 생성 메서드
	private static Node root;
	public static void createNode(int data, int leftData, int rightData) {
		
		//초기상태 여부 확인
		if (root == null) { //초기상태 = 0 1 2
			root = new Node(data); //트리 생성
			
			if (leftData != -1) { //왼쪽 자식이 있으면
				root.left = new Node(leftData); //왼쪽 자식 노드 생성 = 1
			}
			if (leftData != -1) {
				root.right = new Node(rightData); //오른쪽 자식 노드 생성 = 2
			}
		}else {
			//1 3 4
			//루트 노드 생성 이후에 만들어진 노드 중 어떤 것인지를 찾아야 함
			searchNode(root, data, leftData, rightData);
		}
	}//end createNode
	
	
	//라. 루트 노드 생성 이후에 만들어진 노드 중 어떤 것인지 찾아주는 메서드 : 재귀 함수
	public static void searchNode(Node node, int data, int leftData, int rightData) {
		
		if (node == null) { //찾을 노드가 없는 경우 메서드 종료
			return;
			
		}else if (node.data == data) { //위치를 찾은 경우 노드에 넘겨줌
			if (leftData != -1) {
				node.left = new Node(leftData);
			}
			if (rightData != -1) {
				node.right = new Node(rightData);
			}
			
		}else{ //위치를 찾지 못한 경우 계속 찾기
			//왼쪽 탐색
			searchNode(node.left, data, leftData, rightData);
			//오른쪽 탐색
			searchNode(node.right, data, leftData, rightData);
		}
	}
	
	
	//나.
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  //스캐너로 읽기
		//노드 개수 입력
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			//0 1 2
			int x = sc.nextInt(); //0
			int l_child = sc.nextInt(); //1
			int r_child = sc.nextInt(); //2
			
			createNode(x, l_child, r_child); //createNode에 세 값을 넘겨줌
		}
		
		//생성된 연결리스트 출력
		System.out.println(root);
		
		/*
		 * Node [data=0, left=Node [data=1, left=Node [data=3, left=null, right=null], right=Node [data=4, left=null, right=null]], right=Node [data=2, left=null, right=Node [data=5, left=null, right=null]]]
			 ==> 계속 중첩
		 */
	}//end main

}
