import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DemoCreate_Observables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		demoCreate();
	}

	public static void demoJust() {
		String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
		List<String> months = Arrays.asList(monthArray);

		Observable.just(months).subscribe(item -> System.out.println(item), error -> System.out.println(error),
				() -> System.out.println("Emission completed"));

	}

	public static void demoCreate() {
		String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
		List<String> months = Arrays.asList(monthArray);

		Observable.create(subscriber -> {
			try {

				for (String data : months) {
					subscriber.onNext(data);
				}
				subscriber.onComplete();
			} catch (Exception e) {
				// TODO: handle exception
				subscriber.onError(e);
			}
		}).subscribe(item -> System.out.println(item), error -> System.out.println(error),
				() -> System.out.println("Emission completed"));

	}

	public static void demoFromArray() {
		String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
		Observable.fromArray(monthArray).subscribe(item -> System.out.println(item), error -> System.out.println(error),
				() -> System.out.println("Emission completed"));

	}

	public static void demoFromList() {
		String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
		List<String> months = Arrays.asList(monthArray);

		Observable.fromIterable(months).subscribe(item -> System.out.println(item), error -> System.out.println(error),
				() -> System.out.println("Emission completed"));

	}

	public static void demoInterval() {

		Observable<Long> myObservable = Observable.interval(2, TimeUnit.SECONDS);
		Observer<Long> myObserver = new Observer<Long>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("emission completed");

			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				System.out.println("sorry you got an error");

			}

			@Override
			public void onNext(Long item) {
				// TODO Auto-generated method stub
				System.out.println("item" + item);

			}

			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub

			}
		};
		myObservable.subscribe(myObserver);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void demoDefer() {
		String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
		List<String> months = Arrays.asList(monthArray);

	Observable o=	Observable.defer(() -> Observable.just(monthArray)).create(subscriber -> {
			try {

				for (String data : months) {
					subscriber.onNext(data);
				}
				subscriber.onComplete();
			} catch (Exception e) {
				// TODO: handle exception
				subscriber.onError(e);
			}
		});//.subscribe(item -> System.out.println(item), error -> System.out.println(error),
//				() -> System.out.println("Emission completed"));
		
	Observer<String > observer=new Observer<String>() {
		
		@Override
		public void onSubscribe(Disposable arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onNext(String data) {
			// TODO Auto-generated method stub
			System.out.println(data);
		}
		
		@Override
		public void onError(Throwable arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onComplete() {
			// TODO Auto-generated method stub
			
		}
	};
	o.subscribe(observer);
	o.subscribe(observer);
	}
}
