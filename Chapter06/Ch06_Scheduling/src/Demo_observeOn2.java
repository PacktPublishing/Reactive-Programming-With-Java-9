import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class Demo_observeOn2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// new thread for operator
		Observable.fromCallable(new Callable() {

			@Override
			public Object call() throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Observable thread is:-" + Thread.currentThread().getName());
				return 5;
			}
		}).observeOn(Schedulers.newThread()).filter(new Predicate<Integer>() {

			@Override
			public boolean test(Integer value) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("operator thread is:-" + Thread.currentThread().getName());
				return value > 10;
			}
		}).defaultIfEmpty(1).observeOn(Schedulers.newThread()).subscribe(item -> {
			System.out.println("Subscriber thread is:-" + Thread.currentThread().getName());
			System.out.println("items emitted :-"+item);
		});

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
