import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.ReplaySubject;

public class Demo_ReplaySubject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observer<Long> observer=new Observer<Long>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("It's Done");
				
			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();
				
			}

			@Override
			public void onNext(Long value) {
				// TODO Auto-generated method stub
				System.out.println(":"+value);
			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub
				System.out.println("onSubscribe");
				
			}
		};
		
		ReplaySubject<Long> replaySubject=ReplaySubject.create();
		replaySubject.onNext(1l);
		replaySubject.onNext(2l);
		replaySubject.subscribe(observer);
		replaySubject.onNext(10l);
		replaySubject.onComplete();
		

	}

}
