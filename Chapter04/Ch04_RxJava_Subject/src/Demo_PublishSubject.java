import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

public class Demo_PublishSubject {

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

		PublishSubject< Long> publishSubject=PublishSubject.create();
		publishSubject.onNext(1L);
		publishSubject.onNext(2l);
		publishSubject.subscribe(observer);
		publishSubject.onNext(10l);
		publishSubject.onNext(20l);
		publishSubject.onComplete();
	}

}
