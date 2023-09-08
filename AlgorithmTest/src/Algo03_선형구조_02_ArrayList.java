import java.util.ArrayList;
import java.util.List;

public class Algo03_선형구조_02_ArrayList {

	public static void main(String[] args) {

		//ArrayList 생성
		
		List<Integer> x = new ArrayList<Integer>();
		x.add(3);
		x.add(23);
		x.add(33);
		
		System.out.println(x);  //[3, 23, 33]
		
		List<Integer> x2 = new ArrayList<Integer>();
		x2.add(7);
		x2.add(6);
		x2.add(4);
		
		//ArrayList에 ArrayList 저장 (x에 x2를 저장)
		
		x.addAll(x2);
		System.out.println(x); //[3, 23, 33, 7, 6, 4]
		
		
	}

}
