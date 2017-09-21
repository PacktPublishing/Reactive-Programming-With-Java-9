import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Demo_Cold_Observable {

	public static void main(String[] args) {

		Observable observable = Observable.create(observer -> {
			observer.onNext("I am Hot Observable " + Math.random()*100);
			observer.onComplete();
		});

		observable.subscribe(consumer -> System.out.println("message:-" + consumer));
		observable.subscribe(consumer -> System.out.println("message:-" + consumer));
	}

}
