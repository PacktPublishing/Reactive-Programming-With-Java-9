import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Demo_serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Observable.just(12, 12, 13, 30, 45, 56, 67).serialize()
				.subscribe(new Observer<Integer>() {

					@Override
					public void onComplete() {
						// TODO Auto-generated method stub
						System.out.println(Thread.currentThread().getName() + " finished reading of items");

					}

					@Override
					public void onError(Throwable throwable) {
						// TODO Auto-generated method stub
						System.out.println(Thread.currentThread().getName() + " finished with exception");

					}

					@Override
					public void onNext(Integer value) {
						// TODO Auto-generated method stub
						System.out.println(Thread.currentThread().getName() + " read item:-" + value);

					}

					@Override
					public void onSubscribe(Disposable arg0) {
						// TODO Auto-generated method stub

					}
				});

	}

}
