import java.util.Stack;

//Stack : LIFO => top/push/pop
//API 이용

public class Algo03_선형구조_07_Stack2_API {
	
	public static void main(String[] args) {
		
		//API
		Stack<Integer> x = new Stack<>();
		x.push(5);
		x.push(4);
		x.push(3);
		x.push(2);
		x.push(1);
		
		System.out.println(x);  //[5, 4, 3, 2, 1]

		int n = x.pop();
		System.out.println(n + "삭제, " + x);  //1삭제, [5, 4, 3, 2]

		//peek : Looks at the object at the top of this stack 
		System.out.println("top값 " + x.peek()); //2
		
	}

}
