import java.util.Arrays;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class DemoFlowable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flowable<String> month_maybe = Flowable.create(emitter -> {
			try {
				String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov",
						"Dec" };

				List<String> months = Arrays.asList(monthArray);
				for (String month : months) {
					emitter.onNext(month);
				}
				emitter.onComplete();

			} catch (Exception e) {
				emitter.onError(e);
			}
		},BackpressureStrategy.MISSING);
		month_maybe.subscribe(s -> System.out.println(s));

	}

}
