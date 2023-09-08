import java.util.HashMap;
import java.util.Map;

public class Algo03_선형구조_04_HashMap {

	public static void main(String[] args) {

		//HashMap 생성 => 저장 순서 유지X
		
		Map<String, String> m = new HashMap<String, String>();
		m.put("A", "AAA");
		m.put("B", "BBB");
		m.put("C", "CCC");
		
		//Iterate
		//1. m.forEach(Consumer)
		m.forEach((key,value)->System.out.println(key+"="+value));
		
		//2. key값.forEach(Consumer)
		m.keySet().forEach(key->System.out.println(key+"="+m.get(key)));
		
	}

}
