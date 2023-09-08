
public class Algo01_factorial {

	//팩토리얼 점화식 : f(n) = n * f(n-1)
	
	private static int factorial(int n) {
		System.out.println(n+" ");
		if(n==1) {  //f(1)=1
			return 1;
		}else {
			return n * factorial(n-1);
		}
	}

	
	public static void main(String[] args) {

		int x = factorial(5);
		System.out.println(x);
		//5! = 120
	}

}
