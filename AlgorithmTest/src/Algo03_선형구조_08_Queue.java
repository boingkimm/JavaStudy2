import java.util.LinkedList;
import java.util.Queue;

public class Algo03_선형구조_08_Queue {
	
	public static void main(String[] args) {
		
		/*
		 * Queue
		 * - FIFO
		 * 
		 * Insert(enqueue) ---------> Remove(dequeue)
		 * 			     rear(tail)     front(head)
		 * 
		 * 1. 삽입 관련 메서드
		 *  - add(값) : 저장 시 문제 발생 - 예외 발생
		 *  - offer(값) : 저장 시 문제 발생 - false 릴턴
		 *  
		 * 2. 삭제 관련 메서드
		 *  - remove() : 값이 없으면 - 예외 발생
		 *  - poll() : 값이 없으면 - null 리턴
		 * 
		 * 3. peek() : 가장 앞에 있는 front값 반환
		 */
		
		Queue<String> q = new LinkedList<String>();
		q.add("A");
		q.add("B");
		q.add("C");
		q.offer("D");
		q.offer("E");
	

		System.out.println(q);									  //[A, B, C, D, E]
		System.out.println("peek: " + q.peek());  //peek: A

		String str = q.remove();
		System.out.println(str + "삭제, "+ q); 			//A삭제, [B, C, D, E]
		
		str = q.poll();
		System.out.println(str + "삭제, "+ q);			//B삭제, [C, D, E]
		 
		
	}

}
