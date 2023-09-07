package exam03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


class Person{
	String username;
	int score;

	public Person() {
	}

	public Person(String username, int score) {
		this.username = username;
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [username=" + username + ", score=" + score + "]";
	}
	
}//end class


public class StreamAPI_2_중간처리4_sorted_skip_limit {

	public static void main(String[] args) {
		
		//중간처리
				
		//1. sorted : 정렬
		List<Person> list = Arrays.asList(new Person("홍길동1",100),
																			new Person("홍길동2",80),
																			new Person("홍길동3",85),
																			new Person("홍길동4",90),
																			new Person("홍길동5",70));
		
		System.out.println("오름차순");
		
		//기본 : 오름차순 (Person클래스의 score값 기준)
		list.stream()
//			.sorted(Comparator.comparing(Person::getScore))
				.sorted(Comparator.comparingInt(Person::getScore))
				.forEach(System.out::println);
		
		System.out.println("내림차순");
		
		//내림차순 
		list.stream()
				.sorted(Comparator.comparing(Person::getScore, Comparator.reverseOrder()))
				.forEach(System.out::println);
		
		System.out.println("오름차순 정렬 후 2개 skip");
		
		
		//2. skip(n) : n개 skip
		list.stream()
		.sorted(Comparator.comparingInt(Person::getScore))
		.skip(2)
		.forEach(System.out::println);
		
		System.out.println("오름차순 정렬 후 2개 얻기");
		
		
		//3. limit(n) : n개 얻기
		list.stream()
		.sorted(Comparator.comparingInt(Person::getScore))
		.limit(2)
		.forEach(System.out::println);
		
	}

}
