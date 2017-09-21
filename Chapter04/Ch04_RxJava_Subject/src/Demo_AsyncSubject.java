import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.AsyncSubject;

public class Demo_AsyncSubject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AsyncSubject<Long> asyncSubject=AsyncSubject.create();
		asyncSubject.subscribe(new Observer<Long>() {

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
		});
		asyncSubject.onNext(1L);
		asyncSubject.onNext(2L);
		asyncSubject.onNext(10L);

		asyncSubject.onComplete();

	}

}
