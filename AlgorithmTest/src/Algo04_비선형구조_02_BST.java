import java.util.Scanner;

/*
 * < 이진 탐색 트리 (Binary Search Tree: BST ) >
 *  : 루트보다 큰 값 / 작은 값
 *  
 *				 35
 *	      /  \ 
 *	     18   68
 *	   /    \   \
 * 	  7     26   99
 * 	 / \   /  \ 
 * 	3  12 22  30 
 * 
 *  입력:
		10
		35 18 68
		18  7 26
		68 -1 99
		7   3 12
		26 22 30
		99 -1 -1
		3  -1 -1
		12 -1 -1
		22 -1 -1
		30 -1 -1
 */

public class Algo04_비선형구조_02_BST {
	
	//// Node 충돌나니까 중첩클래스로 로컬로 만들어줌 ***
	//가. 각 노드를 저장하는 클래스를 생성
	static class Node{
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
	/////
	
	//다. Node 생성 메서드
	private static Node root;
	public static void createNode(int data, int leftData, int rightData) {
		
		//초기상태 여부 확인
		if (root == null) { //초기상태
			root = new Node(data); //트리 생성
			
			if (leftData != -1) { //왼쪽 자식이 있으면
				root.left = new Node(leftData); //왼쪽 자식 노드 생성
			}
			if (leftData != -1) {
				root.right = new Node(rightData); //오른쪽 자식 노드 생성 
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
		
		//마. BST 검색 : 30 - 탐색성공: 4
		Node searchNode = bstSearch(root, 30);
		if (searchNode != null) {
			System.out.println("탐색성공: " + num + "번");
		}else {
			System.out.println("탐색실패");
		}
			
		/*
			Node [data=35, left=Node [data=18, left=Node [data=7, left=Node [data=3, left=null, right=null], right=Node [data=12, left=null, right=null]], right=Node [data=26, left=Node [data=22, left=null, right=null], right=Node [data=30, left=null, right=null]]], right=Node [data=68, left=null, right=Node [data=99, left=null, right=null]]]
			==> 계속 중첩
			탐색성공: 4번
		 */
		
	}//end main

	//마. BST 트리용 검색 메서드
	static int num = 0; //검색 횟수
	private static Node bstSearch(Node node, int key) {
		num++;
		if (node == null) {
			return null;
		}
		if (node.data == key) {
			return node;
		}else if (node.data < key) { //현재 노드보다 찾을 값이 더 크면 오른쪽 탐색
			return bstSearch(node.right, key);
		}else {
			return bstSearch(node.left, key);
		}
	}
}
