import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DemoConsumer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer<Integer> consumer=num-> System.out.println("num:-"+num);
		List<Integer> data=Arrays.asList(144,256,4,55);
		printNumber(data,consumer);
		
	}

public static void  printNumber(List<Integer> data, Consumer<Integer> consumer) {
		// TODO Auto-generated method stub
		for(Integer num:data)
		consumer.accept(num);
	}


}
