import java.time.LocalDateTime;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class DemoLatency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        long time_start=System.currentTimeMillis();
		Observable<Integer> observable = Observable.create(source -> {
			System.out.println("thread:-" + Thread.currentThread().getName());
			source.onNext(10);
			source.onNext(50);
			source.onNext(100);
			source.onComplete();
		});
		observable.map(item -> item / 5.0).subscribe(new Observer<Double>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("time taken"+ (System.currentTimeMillis()-time_start));
			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();

			}

			@Override
			public void onNext(Double value) {
				// TODO Auto-generated method stub
				System.out.println("item arrived:-" + value + "on thread:-" + Thread.currentThread().getName());

			}

			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub

			}
		});

		long time_start1=System.currentTimeMillis();
		observable.flatMap(item -> Observable.just(item/5.0)).subscribe(new Observer<Double>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("time taken"+ (System.currentTimeMillis()-time_start1));
			}

			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(Double value) {
				// TODO Auto-generated method stub
				System.out.println("item arrived:-" + value + "on thread:-" + Thread.currentThread().getName());
				
			}

			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
