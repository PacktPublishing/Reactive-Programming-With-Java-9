import java.util.function.Supplier;

public class DemoLazyFunction {

	public static boolean evaluateMe(String data){
		System.out.println("evaluation");
		return data.length()>5;
	}

	public static String matchMe(boolean result1, boolean result2){	
		return result1&&result2?" both values are equal" : "values are different";	
	}

	public static void main(String[] args) {
//		String output= matchMe(evaluateMe("one"),evaluateMe("three"));
//		System.out.println(output);
		
		System.out.println(matchMeLazy(()->evaluateMe("abcd"),
				 ()->evaluateMe("a")));

	}
	
	public static String matchMeLazy(Supplier<Boolean>length1, Supplier<Boolean>length2){
		return length1.get() &&length2.get()?" both values are equal" : "values are different";
	}

	
	
}






