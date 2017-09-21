import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class Demo_MultipleSubscribers {
	public static void main(String[] args) {
		String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May"};
		List<String> months = Arrays.asList(monthArray);

		Observable<Object> observable = Observable.create(subscriber -> {
			try {
				System.out.println("creating ");
				for (String data : months) {
					subscriber.onNext(data);
				}
				subscriber.onComplete();
			} catch (Exception e) {
				// TODO: handle exception
				subscriber.onError(e);
			}
		});
		observable.subscribe(item -> System.out.println("month:-" + item));
		observable.subscribe(item -> System.out.println("month:-" + item));

	}

}
