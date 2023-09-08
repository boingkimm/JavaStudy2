import java.util.PriorityQueue;

public class Algo03_선형구조_09_PriorityQueue {
	
	public static void main(String[] args) {
		
		//PriorityQueue => 랜덤 정렬, 삭제 시 작은 값부터 삭제됨 (자동 오름차순 정렬)
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(20);
		q.add(10);
		q.add(40);
		q.add(50);
		q.add(6);
	
		System.out.println(q);  //랜덤하게 저장됨 [6, 10, 40, 50, 20]

		//삭제 시 정렬되어 작은 값부터 삭제됨
		for(int i=0; i<5; i++) {
			System.out.println(q.poll());
		}
		
		/*
			6
			10
			20
			40
			50
		 */
		
	}

}
