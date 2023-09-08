import java.util.LinkedHashMap;

public class Algo03_선형구조_05_LinkedHashMap {

	public static void main(String[] args) {

		//LinkedHashMap 생성 => 저장 순서 유지O (with predictable iteration order.)
		
		LinkedHashMap<String, String> m = new LinkedHashMap<String, String>();
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
