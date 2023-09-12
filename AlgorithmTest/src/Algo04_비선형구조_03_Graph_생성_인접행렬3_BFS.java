import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
 * BFS 순회 : Queue 자료구조 이용 
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

public class Algo04_비선형구조_03_Graph_생성_인접행렬3_BFS {
	
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
		
		//BFS (너비 우선 탐색)

		StringBuilder sb = new StringBuilder();	//방문 순서 저장용
		
		Queue<Integer> q = new LinkedList<>();
		boolean [] visited = new boolean[9]; //방문여부 확인 (기본값: false)
		
		q.offer(1); //시작 정점 저장
		visited[1] = true; //시작 노드 방문 처리
		
		while (!q.isEmpty()) {
			
			int idx = q.poll();
			
			sb.append(idx+" -> ");  //방문 순서 저장용

			//꺼낸(poll) 정점과 인접한 노드를 찾아서 offer
			for (int linkedNode : graph[idx]) {  //==>linkedNode에 2, 3 반환됨
				//방문하지 않았을 경우에만 offer
				if (!visited[linkedNode]) {  //linkedNode(=2) 방문하지 않았으면
					q.offer(linkedNode); 			 //Queue에 offer
					visited[linkedNode]=true;  //방문여부를 true
				}
			}
			
		}//end while
		//1 제거하고  1에 연결된 노드들 중에서 큐에  저장 경험이 없는 노드를 저장한다.
		
		System.out.println("BFS 순회: " + sb.toString());
		//BFS 순회: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 
		//pdf_p.51
	}
}
