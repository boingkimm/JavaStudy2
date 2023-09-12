import java.util.Scanner;
import java.util.Stack;

/*
 * DFS 순회 : Stack 자료구조 이용
 * 
						 1
           2   3
         4  5    6    
        7         8 
         
      인접배열
      
        1 2 3 4 5 6 7 8
      1 0 1 1 0 0 0 0 0 
      2 1 0 0 1 1 0 0 0
      3 1 0 0 0 0 1 0 0 
      4 0 1 0 0 0 0 1 0
      5 0 1 0 0 0 0 0 0  
      6 0 0 1 0 0 0 0 1
      7 0 0 0 1 0 0 0 0
      8 0 0 0 0 0 1 0 0

 */

public class Algo04_비선형구조_03_Graph_생성_인접행렬2_DFS {
	
	public static void main(String[] args) {
		
		//2차원 배열 생성 - 9개 (0~8번 인덱스)
		//인덱스 값을 각각의 노드값으로 처리, 이웃을 지정
		int [][] graph = {{},			//0번 인덱스(0번 노드)가 없음
											{2,3},  //1번 인덱스(1번 노드)의 이웃 지정
											{4,5},  //2번 인덱스(2번 노드)의 이웃 지정
											{6},
											{7},
											{},			//5번 인덱스(5번 노드)의 이웃 없음
											{8},
											{},
											{}};
		
		//DFS (깊이 우선 탐색)
		//알고리즘 순서
		//1. 스택 생성, boolean 배열로 정점 방문여부 확인
		//2. 스택 시작노드 저장(push 1 저장), boolean값을 true
		//3. pop 1
		//4. pop한 1과 연결된 정점을 push (2, 3)
		
		
		StringBuilder sb = new StringBuilder();	//방문 순서 저장용
		
		Stack<Integer> stack = new Stack<Integer>();
		boolean [] visited = new boolean[9]; //방문 여부 확인
		
		stack.push(1); 		 //시작 정점 저장
		visited[1] = true; //시작 노드 방문처리 : 방문여부가 true - 앞으로 1 접근 안함
		
		//스택이 비어있을 때까지 반복 (스택에 값이 없으면 중단)
		while (!stack.isEmpty()) {
			
			int idx = stack.pop();  //==> idx=1
			
			sb.append(idx+" -> ");  //방문 순서 저장용
			
			//꺼낸(pop) 정점과 인접한 노드를 찾아서 push ==> {2,3}
			for (int linkedNode : graph[idx]) {  //==>linkedNode에 2, 3 반환됨
				//방문하지 않았을 경우에만 push
				if (!visited[linkedNode]) {  //linkedNode(=2) 방문하지 않았으면
					stack.push(linkedNode); 	 //스택에 push
					visited[linkedNode]=true;  //방문여부를 true
				}
			}
			
		}//end while
		
		System.out.println("DFS 순회: " + sb.toString());
		//DFS 순회: 1 -> 3 -> 6 -> 8 -> 2 -> 5 -> 4 -> 7 -> 
		//DFS 순회: 1 -> 2 -> 4 -> 7 -> 5 -> 3 -> 6 -> 8 -> (배열 순서 변경시)
		//pdf_p.49
	}
}
