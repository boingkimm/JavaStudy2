import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class Algo03_선형구조_02_ArrayList3_iterate {

	public static void main(String[] args) {

		//ArrayList 반복출력
		
		List<String> x = new  ArrayList<String>();
		x.add("C");
		x.add("C++");
		x.add("Java");
		x.add("Kotlin");
		x.add("Python");
		x.add("SQL");

		//1. forEach(Consumer)
		x.forEach(System.out::println);
		System.out.println();
		
		//2. Iterate
		Iterator<String> ite = x.iterator();
		while (ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		System.out.println("3.ListIterator");
		
		//3. ListIterator : 시작 위치를 지정 가능 => 역순으로 접근 가능(hasPrevious)
//	ListIterator<String> ite2 = x.listIterator(6);  //위치값! idx 아님!
		ListIterator<String> ite2 = x.listIterator(x.size());
		while (ite2.hasPrevious()) {
			System.out.println(ite2.previous());
		}
		System.out.println();
		
		//4. foreach문
		for (String s : x) {
			System.out.println(s);
		}
		System.out.println();

		//5. 일반 for문
		for (int i = 0; i < x.size(); i++) {
			System.out.println(x.get(i));
		}
		
		
		
		
	}

}
