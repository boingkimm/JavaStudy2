import java.util.Arrays;

//Stack : LIFO => top/push/pop
//직접 생성

class MyStack{
	
	int top;  //스택의 최상단 값
	int size;
	int[] stack;  //stack을 배열로 직접 생성 => size 변경 X
	
	public MyStack(int size) {
		this.size = size;
		stack = new int[size];  //stack의 size를 배열로.
		top = -1;  //top의 기본값: 0보다 밑에(배열 밖에) 있음 => 증가시 0
	}
	
	//저장: top 증가하고 값 저장
	public void push(int n) {
		++top;  //증가
		stack[top] = n; //저장
		//stack[++top] = n;  //top을 증가하고 -> 값을 저장(n)
		System.out.println(stack[top]+" push~");
	}
	
	//삭제: top 감소하고 값 삭제
	public void pop() {
		if(top>=0)
			System.out.println(stack[top]+" pop~");
		stack[top--] = 0; //값 제거(0)하고 -> top을 감소
	}
	
	//현재 top에 있는 값 반환 (스택의 최상단)
	public int peek() {
		return stack[top];
	}
	
}//end class



public class Algo03_선형구조_07_Stack {
	
	public static void main(String[] args) {
		
		MyStack x = new MyStack(5);  //배열크기 5
		x.push(5);
		x.push(4);
		x.push(3);
		x.push(2);
		x.push(1);
		
		/*
		5 push~
		4 push~
		3 push~
		2 push~
		1 push~
		*/
		
		System.out.println(Arrays.toString(x.stack));  //[5, 4, 3, 2, 1]
		System.out.println(x.peek());  //1

		for (int i = 0; i < x.size; i++) {
			x.pop();
		}
		
		/*
		1 pop~
		2 pop~
		3 pop~
		4 pop~
		5 pop~ 
		 */
	}

}
