package exam01;

//인터페이스
@FunctionalInterface  //람다
interface Flyer{
	//가. 파라미터X 리턴값X
	public void fly();
//	public void fly2();  //람다는 추상메서드 하나만 존재 가능 (@FunctionalInterface이 강제함)
}

public class LambdaTest {

	public static void main(String[] args) {

		//익명클래스
		/*
		 * 인터페이스명 변수명 = new 인터페이스명(){
		 * 	//추상 메서드 재정의
		 * };
		*/
		
		Flyer f = new Flyer() {;
			
			@Override
			public void fly() {
				System.out.println("Flyer fly()");
			}
		};
		f.fly();
		
		
		//람다 표현식 => 클래스 없이 추상 메서드만 표현
		
		Flyer f2 = () -> {System.out.println("람다 표현식 Flyer fly()");};
		f2.fly();
		
	}

}
