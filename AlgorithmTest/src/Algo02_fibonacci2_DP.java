
public class Algo02_fibonacci2_DP {

	//피보나치 점화식 : f(n) = f(n-1) + f(n-2)
	//f(1)=f(2)=1
	
	//DP (Dynamic Programming, 동적계획법)
	// : 메모이제이션(memoization)을 활용하여 동일한 계산이 반복될 때 재사용하여 프로그램의 성능을 향상
	//   동일한 함수 또 호출하지 않고 리턴만 함


	//단순재귀 (동일 함수 여러번 중복 호출됨)
	static int num=0; //호출 횟수
	private static int fibonacci2(int n) {
		num++;
		if(n<=1) {
			return n;
		}else {
			return fibonacci2(n-1) + fibonacci2(n-2);
		}
	}

	//DP로 구현
	static int [] dp;	 //저장할(메모이제이션 할) 배열 선언
	private static int fibonacci(int n) {
		num++;
		if(n<=1) {
			return n;
		}else {
			if(dp[0]!=0)return dp[n];
			dp[n] = fibonacci(n-1) + fibonacci(n-2);
			return dp[n];
		}
	}
	
	
	public static void main(String[] args) {

		dp = new int[11];
		for (int i = 1; i <= 10; i++) {
			System.out.println(fibonacci2(i)+"");
		}
		System.out.println("호출 횟수 : " + num);
		//재귀:452,  DP:
		
	}

}
