package exam03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Stu{
	
	String username;
	int grade;
	boolean isMale;
	int age;
	
	public Stu() {
	}

	public Stu(String username, int grade, boolean isMale, int age) {
		this.username = username;
		this.grade = grade;
		this.isMale = isMale;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Stu [username=" + username + ", grade=" + grade + ", isMale=" + isMale + ", age=" + age + "]";
	}

}



public class StreamAPI_3_최종처리_3_collect {

	public static void main(String[] args) {
		
		//최종처리
				
		/*
		 * collect(Collector<? super T,A,R> collector)
		 * 
		 * - 파라미터인 Collector 인터페이스 대신에 Collectors 클래스를 사용한다
		 * - Collectors 클래스의 메서드는 static메서드이므로 Collectors.메서드 형식으로 사용한다
		 * 
		 */

		Stu [] stuArr = {new Stu("홍길동", 3, true, 25),
										 new Stu("이순신", 1, true, 55),
										 new Stu("유관순", 2, false, 18),
										 new Stu("안중근", 3, true, 31),
										 new Stu("홍범도", 1, true, 58),
										 new Stu("강감찬", 3, true, 44)};
		
		//1. 이름만 출력
		Arrays.stream(stuArr)
					.map(Stu::getUsername)
					.forEach(System.out::println);
		System.out.println();

		
		//2. 이름만 List에 저장
		List<String> list =	Stream.of(stuArr)
															.map(Stu::getUsername)
															.collect(Collectors.toList());
		System.out.println("이름만 List에 저장: " + list);
		System.out.println();
		
		
		//3. Map으로 저장 ( Map<이름, Stu> )
		Function<Stu, String> keyMapper = new Function<Stu, String>() {
			@Override
			public String apply(Stu t) {
				return t.getUsername();
			}
		};
		
		Function<Stu, Stu> valueMapper = new Function<Stu, Stu>() {
			@Override
			public Stu apply(Stu t) {
				return t;
			}
		};
		
		Map<String, Stu> m = Stream.of(stuArr).collect(Collectors.toMap(keyMapper, valueMapper));
		Set<String> keys = m.keySet();
		for (String key : keys) {
			System.out.println(key + "=" + m.get(key));
		}
		
		System.out.println();
		
		//람다표현식
		Map<String, Stu> m2 = Stream.of(stuArr)
//			.collect(Collectors.toMap(t->t.getUsername(), t->t));
				.collect(Collectors.toMap(Stu::getUsername, t->t));
		Set<String> keys2 = m.keySet();
		for (String key : keys2) {
			System.out.println(key + "=" + m.get(key));
		}
		
		System.out.println();
		
		
		//4. 개수
		long count = Stream.of(stuArr).collect(Collectors.counting());
		System.out.println("개수: " + count);
		
		
		//5. age 합계
		int sum = Stream.of(stuArr).collect(Collectors.summingInt(Stu::getAge));
		System.out.println("age 합계: " + sum);
		
		
		//6. age 최대값
		Optional<Stu> max = Stream.of(stuArr).collect(Collectors.maxBy(Comparator.comparing(Stu::getAge)));
		System.out.println("age 최대값: " + max);
		System.out.println("age 최대값: " + max.get());
		System.out.println("age 최대값: " + max.orElse(null));
		
		
		//7. age 최소값
		Stu min = Stream.of(stuArr).collect(Collectors.minBy(Comparator.comparing(Stu::getAge))).orElse(null);
		System.out.println("age 최소값: " + min);
		
		System.out.println();
		
		
		/*
		 * collect(Collectors.partitioningBy(Predicate))
		 *  => true값과 false값으로 나누어서 반환
		 *  
		 * collect(Collectors.groupingBy(Function))
		 *  => Function에서 리턴값으로 그룹핑해서 반환
		 */
		
		//8. 성별 분류 : partitioningBy
		//익명클래스
		Predicate<Stu> predicate = new Predicate<Stu>() {
			@Override
			public boolean test(Stu t) {
				return t.isMale();
			}
		};
		Map<Boolean, List<Stu>> xxx = 
				Stream.of(stuArr).collect(Collectors.partitioningBy(predicate));
		List<Stu> male = xxx.get(true);
		List<Stu> female = xxx.get(false);
		
		System.out.println("male: " + male);
		System.out.println("female: " + female);
		
		//람다표현식
		Map<Boolean, List<Stu>> xxx2 = 
				Stream.of(stuArr)
//						.collect(Collectors.partitioningBy(t->t.isMale()));
							.collect(Collectors.partitioningBy(Stu::isMale));  //method reference
		List<Stu> male2 = xxx2.get(true);
		List<Stu> female2 = xxx2.get(false);
		
		System.out.println("male: " + male2);
		System.out.println("female: " + female2);

		System.out.println();
		
		
		//9. grade 그룹핑 : groupingBy(Function)
		Function<Stu, Integer> classifier = new Function<Stu, Integer>() {
			@Override
			public Integer apply(Stu t) {
				return t.getGrade();
			}
		};
		Map<Integer, List<Stu>> yyy = 
				Stream.of(stuArr).collect(Collectors.groupingBy(classifier));
		Set<Integer> keys3 = yyy.keySet();
		for (Integer key : keys3) {
			System.out.println(key+"="+yyy.get(key));
		}
		
		// grade 그룹핑 개수 : groupingBy(Function, Collector)
		Map<Integer, Long> yyy2 = 
				Stream.of(stuArr).collect(Collectors.groupingBy(classifier, Collectors.counting()));
		Set<Integer> keys4 = yyy.keySet();
		for (Integer key : keys4) {
			System.out.println(key+"="+yyy2.get(key));
		}
		
		
	
	}

}
