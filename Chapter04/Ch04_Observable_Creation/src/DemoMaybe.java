import java.util.Arrays;
import java.util.List;

import io.reactivex.Maybe;

public class DemoMaybe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maybe<List<String>> month_maybe = Maybe.create(emitter -> {
			try {
				String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov",
						"Dec" };

				List<String> months = Arrays.asList(monthArray);
				if (months != null && !months.isEmpty()) {
					emitter.onSuccess(months);
				} else {
					emitter.onComplete();
				}
			} catch (Exception e) {
				emitter.onError(e);
			}
		});
		month_maybe.subscribe(s->System.out.println(s));
		
	}

}
