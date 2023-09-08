import java.util.LinkedList;

public class Algo03_선형구조_03_LinkedList {

	public static void main(String[] args) {

		//LinkedList (순서O) : ArrayList보다 삽입,삭제 용이
		
		LinkedList<String> list = new LinkedList<>();
		list.add("A1");
		list.add("A2");
		list.add("A3");

		list.add(0, "B");
		list.addFirst("C");
		list.addLast("D");
		System.out.println(list); //[C, B, A1, A2, A3, D]

		
		//삭제
		String str = list.removeFirst();		  //[B, A1, A2, A3, D]
		str = list.removeLast(); 							//[B, A1, A2, A3]
		boolean b = list.remove("A1");				//[B, A2, A3]
		list.removeIf(x->x.startsWith("A"));  //[B]
		
		System.out.println(list);
		
		
		//Iterate : ArrayList와 동일

		
	}

}
