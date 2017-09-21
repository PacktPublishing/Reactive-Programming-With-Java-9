import java.util.Date;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.observables.ConnectableObservable;

public class Demo_Hot_Observable {

	public static void main(String[] args) {
		ConnectableObservable observable = Observable.create(observer -> {
			observer.onNext("I am Hot Observable "+Math.random()*100);
			observer.onComplete();
		}).publish();

		observable.subscribe(consumer -> System.out.println("message:-" + consumer));
		observable.subscribe(consumer -> System.out.println("message:-" + consumer));
		
		observable.connect();

		
	}

}
