import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;

public class Demo_BehaviorSubject {

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
		BehaviorSubject<Long> behaviorSubject=BehaviorSubject.create();
		behaviorSubject.onNext(1L);
		behaviorSubject.onNext(2L);
		behaviorSubject.onNext(10L);

		behaviorSubject.onError(new Exception("You got an Exception"));
		behaviorSubject.subscribe(observer);
		behaviorSubject.onComplete();

	}

}
