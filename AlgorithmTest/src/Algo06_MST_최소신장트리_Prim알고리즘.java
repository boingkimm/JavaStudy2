import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * 최소 신장 트리 ( Minimum Spanning Tree: MST)
 *  - 프림 ( Prim ) 알고리즘
			1. 임의의 정점을 선택한다.
			2. 선택한 정점으로부터 가장 낮은 가중치를 갖는 정점을 선택한다.
			3. 모든 정점에 대하여 2번의 과정을 반복한다
 */


public class Algo06_MST_최소신장트리_Prim알고리즘 {
	
	/////////////////////
	static class Node{
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	
		//정렬 목적
		public int getWeight() {
			return weight;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + "]";
		}

	}//end Node
	/////////////////////

	
	static int cnt = 7; //정점 개수
	static int total;   //MST의 가중치의 합
	static ArrayList<ArrayList<Node>> nodeList = new ArrayList<ArrayList<Node>>(); //중첩리스트에 graph 값 저장
	static boolean [] visited = new boolean[cnt+1]; //방문여부 
	static StringBuilder sb = new StringBuilder();  //정점 순서 저장용 
	
	
	public static void main(String[] args) {
		
		//가중치 그래프 p.70
		int [][] graph = {
				 {1,2,29},
				 {1,5,75},
				 {2,3,35},
				 {2,6,34},
				 {3,4,7},
				 {4,6,23},
				 {4,7,13},
				 {5,6,53},
				 {6,7,25}
				 };
		
		//중첩 ArrayList 생성 (안)
		for (int i = 0; i <= cnt; i++) {
			nodeList.add(new ArrayList<Node>());
		}
		
		//nodeList에 graph 값 저장
		for (int i = 0; i < graph.length; i++) {
			int v1 = graph[i][0];	//1
			int v2 = graph[i][1];	//2
			int weight = graph[i][2];	//29
			
			//무방향그래프이므로 양방향 작성
			nodeList.get(v1).add(new Node(v2, weight));
			nodeList.get(v2).add(new Node(v1, weight));
		}
		
		//nodeList 값 출력
		for (int i = 0; i < nodeList.size(); i++) {
			System.out.println(i +"->" + nodeList.get(i));
		}
		
		/*
			0->[]
			1->[Node [to=2, weight=29], Node [to=5, weight=75]]
			2->[Node [to=1, weight=29], Node [to=3, weight=35], Node [to=6, weight=34]]
			3->[Node [to=2, weight=35], Node [to=4, weight=7]]
			4->[Node [to=3, weight=7], Node [to=6, weight=23], Node [to=7, weight=13]]
			5->[Node [to=1, weight=75], Node [to=6, weight=53]]
			6->[Node [to=2, weight=34], Node [to=4, weight=23], Node [to=5, weight=53], Node [to=7, weight=25]]
			7->[Node [to=4, weight=13], Node [to=6, weight=25]]
		 */
		
		//1부터 시작
		prim(1);
		System.out.println("탐색순서: " + sb.toString());
		System.out.println("MST의 총 weight: " + total);
		
		/*
			탐색순서: 1 -> 2 -> 6 -> 4 -> 3 -> 7 -> 5 -> 
			MST의 총 weight: 159		
		*/
		
	}//end main
	
	
	
	//prim 알고리즘 구현한 메서드
	private static void prim(int start) {
		
		//가장 작은 weight값을 가진 Node 얻기
		Queue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
		
		//시작값 저장
		q.add(new Node(start, 0)); //Node(to, weight)
		
		//비어있을 때까지 반복
		while (!q.isEmpty()) {
			Node p = q.poll();
			int to = p.to;
			int weight = p.weight;
			//현재 정점이 처리된 적이 있으면 무시
			if(visited[to]) continue;
			
			visited[to] = true;
			sb.append(to + " -> "); //방문순서 저장용
			total += weight;				//가중치 누적

			//현재 노드와 이웃하면서 방문한 적 없는 노드를 Queue에 추가 ==> 자동으로 weight값으로 정렬됨 
			for (Node next : nodeList.get(to)) {
				if(!visited[next.to]) {
					q.add(next);
				}
			}
			
		}//end while
	}//end prim
	
}
