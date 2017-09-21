import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DemoTimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Long> observable=Observable.timer(1,TimeUnit.SECONDS,Schedulers.computation()).flatMap(i->Observable.just(12l,13l,300l,400l));
		observable.subscribe(new Observer<Long>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub00
				System.out.println("completed");
				
			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();
			}

			@Override
			public void onNext(Long value) {
				// TODO Auto-generated method stub
				System.out.println(value);
				
			}

			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub
				System.out.println("subscribe");
				
			}
		});

		try {
			Thread.sleep(80000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
