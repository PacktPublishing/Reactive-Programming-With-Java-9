
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.packt.ch02.pojo.Student;

public class DemoStreamAPI {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students=new ArrayList<Student>();
		students.add(new Student("A",1,89));
		students.add(new Student("B",12,80));
		students.add(new Student("A1",10,67));
		students.add(new Student("C",7,56));
		students.add(new Student("A",5,90));
		
		Stream<Student> stream=students.stream();
		Consumer<Student> consumer=System.out::println;
		stream.forEach(consumer);
		
		System.out.println("******NAMES STARTING WITH A");
		Predicate<Student> predicate=student->student.getName().startsWith("A");
		students.stream().filter(predicate).forEach(consumer);
		
		System.out.println("******NAMES in  Lower cases");
		Function<Student,String>fun_to_lower=student->student.getName().toLowerCase();
		students.stream().map(fun_to_lower).forEach(System.out::println);

		
		System.out.println("******NAMES in  Lower cases");
		students.stream().map(Student::getName).filter(name->name.startsWith("A")).forEach(System.out::println);
		
	}
}
