import java.util.ArrayList;
import java.util.List;

public class Algo03_선형구조_02_ArrayList2_삭제 {

	public static void main(String[] args) {

		//ArrayList 삭제 - 순서를 정해서 나가는 것을 결정하는 것이 일반적
		
		List<String> x = new  ArrayList<String>();
		x.add("C");
		x.add("C++");
		x.add("Java");
		x.add("Kotlin");
		x.add("Python");
		x.add("SQL");

		
		String str = x.remove(5);  //idx 이용해서삭제
		System.out.println(str);   //삭제한 값: SQL
		
		boolean b = x.remove("Kotlin");  //value 이용해서 삭제
		System.out.println(b); 					 //true
		
		//조건으로 삭제 : removeIf
		x.removeIf(s->s.startsWith("C")); //C로 시작하는 값 삭제
		System.out.println(x);						//[Java, Python]
		
		//삭제할 값을 List에 저장하고 이 List값을 이용해서 삭제
		List<String> x2 = new ArrayList<String>();
		x2.add("Java");
		x.removeAll(x2);
		System.out.println(x); 			//[Python]
		
		
	}

}
