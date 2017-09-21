import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class DemoObservable_numbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums = { 1, 23, 34, 21, 33, 4, 54 };
		List<Integer> numList = Arrays.asList(nums);

		 Observable.just(numList).subscribe(item -> System.out.println(item));

	}

}
