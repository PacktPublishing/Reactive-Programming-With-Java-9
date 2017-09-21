import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class Demo_Scheduler_computation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("current thread in main is:-" + Thread.currentThread().getName());
		Observable.range(10, 5).map(item -> item - 5).doOnNext(new Consumer<Integer>() {

			@Override
			public void accept(Integer value) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName() + " emitted " + value);

			}
		}).observeOn(Schedulers.computation()).filter(item -> {
			if (item%2 != 0)
				return false;
			return true;
		}).subscribe(new Observer<Integer>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("sequence completed successfully");
			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				System.out.println(throwable.getMessage());
			}

			@Override
			public void onNext(Integer item) {
				// TODO Auto-generated method stub
				System.out.println("Subscriber thread is:-" + Thread.currentThread().getName());
				System.out.println("emitted:-" + item);
			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub
			}
		});

		
	}

}
