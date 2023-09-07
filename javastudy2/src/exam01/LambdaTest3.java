package exam01;

//인터페이스
@FunctionalInterface  //람다
interface Flyer3{
	//나. 파라미터O 리턴값X
	public void fly(int n, int n2);
}

public class LambdaTest3 {

	public static void main(String[] args) {

		Flyer3 f = new Flyer3() {
			
			@Override
			public void fly(int n, int n2) {
				System.out.println("Flyer3 fly(int n, int n2) "+n);
			}
		};
		f.fly(10,20);
		
		
		//람다 표현식 => 클래스 없이 추상 메서드만 표현
		Flyer3 f2 =(int n, int n2)->{
			System.out.println("람다 표현식 Flyer3 fly(int n, int n2) "+n);
		};
		f2.fly(20,20);
		
		//데이터타입 생략
		Flyer3 f3 =(n, n2)->{
			System.out.println("람다 표현식 Flyer3 fly(int n, int n2) "+n);
		};
		f3.fly(30,40);

		//매개변수가 하나면 () 생략
		
		
	}

}
