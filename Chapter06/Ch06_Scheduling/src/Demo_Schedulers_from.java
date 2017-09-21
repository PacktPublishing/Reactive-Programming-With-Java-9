import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class Demo_Schedulers_from {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService executor = Executors.newFixedThreadPool(2);
		// Observable.interval(100, TimeUnit.MILLISECONDS,
		// Schedulers.from(executor))
		// .take(10).forEach(item->System.out.println(Thread.currentThread().getName()+"
		// EMITTED "+item));

		Observable.interval(100, TimeUnit.MILLISECONDS, Schedulers.from(executor)).take(10)
				.blockingSubscribe(item -> System.out.println(Thread.currentThread().getName() + " EMITTED " + item));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		executor.shutdown();


	}

}
