import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DemoPredicate {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Predicate<Integer> predicate=num->num%2==0;
	List<Integer> data=Arrays.asList(144,256,4,55);
	for(Integer num:data)
	{
		if(predicate.test(num))
		{
			System.out.println(num);
		}
	}

}
}
