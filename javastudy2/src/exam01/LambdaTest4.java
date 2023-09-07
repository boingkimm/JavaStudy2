package exam01;

//인터페이스
@FunctionalInterface  //람다
interface Flyer4{
	//라. 파라미터O 리턴값O
	public int fly(int n, int n2);
}

public class LambdaTest4 {

	public static void main(String[] args) {

		Flyer4 f = new Flyer4() {
			
			@Override
			public int fly(int n, int n2) {
				return n+n2;
			}
		};
		int result = f.fly(10, 20);
		System.out.println("result: " + result);
		
		
		//람다 표현식 => 클래스 없이 추상 메서드만 표현
		Flyer4 f2 =(int n, int n2)->{
			return n+n2;
		};
		
		//데이터타입 생략
		Flyer4 f3 =(n, n2)->{
			return n+n2;
		};

		//매개변수가 하나면 () 생략
		
		//return 문장만 있으면 {}와 return 키워드 생략
		Flyer4 f4 =(n, n2) -> n+n2;
		
		int result4 = f.fly(20, 20);
		System.out.println("result4: " + result4);
	}

}
