import java.util.Arrays;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Single;

public class DemoSingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Single<List<String>> month_maybe = Single.create(emitter -> {
			try {
				String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov",
						"Dec" };

				List<String> months = Arrays.asList(monthArray);
				if (months != null && !months.isEmpty()) {
					emitter.onSuccess(months);
				} 
			} catch (Exception e) {
				emitter.onError(e);
			}
		});
		month_maybe.subscribe(s->System.out.println(s));


	}

}
