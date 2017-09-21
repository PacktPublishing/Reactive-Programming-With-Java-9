import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface DisplayData {
	String write(String item, Object... arguments);
}

public class DemoMethodRef {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("apple", "mango", "Lichi", "Strawberry");
		display(fruits, String::format);
		display(fruits, (fmt, arg) -> String.format(fmt, arg));
		
//		DemoMethodRef demo=new DemoMethodRef();

	}

	public static void display(List<String> fruits, DisplayData displayData) {
		for (String item : fruits)
			System.out.println(displayData.write("data:-"+item, item));
		System.out.println();
	}
	
	

}
