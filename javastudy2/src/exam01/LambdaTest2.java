package exam01;

//인터페이스
@FunctionalInterface  //람다
interface Flyer2{
	//나. 파라미터O 리턴값X
	public void fly(int n);
}

public class LambdaTest2 {

	public static void main(String[] args) {

		Flyer2 f = new Flyer2() {
			
			@Override
			public void fly(int n) {
				System.out.println("Flyer2 fly(int n) "+n);
			}
		};
		f.fly(10);
		
		
		//람다 표현식 => 클래스 없이 추상 메서드만 표현
		Flyer2 f2 =(int n)->{
			System.out.println("람다 표현식 Flyer2 fly(int n) "+n);
		};
		f2.fly(20);
		
		//데이터타입 생략
		Flyer2 f3 =(n)->{
			System.out.println("람다 표현식 Flyer2 fly(int n) "+n);
		};
		f3.fly(30);

		//매개변수가 하나면 () 생략
		Flyer2 f4 =n->{
			System.out.println("람다 표현식 Flyer2 fly(int n) "+n);
		};
		f4.fly(40);
		
	}

}
