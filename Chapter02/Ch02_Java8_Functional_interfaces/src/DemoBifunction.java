import java.util.function.BiFunction;

public class DemoBifunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BiFunction<Integer,Integer,String> bifunction=(no1,no2)->{
			return "addition:-"+(no1+no2);
		};
		System.out.println(bifunction.apply(10,20));
	}

}
