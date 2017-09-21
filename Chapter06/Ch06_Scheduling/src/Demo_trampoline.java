import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class Demo_trampoline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scheduler scheduler=Schedulers.trampoline();
		Scheduler.Worker worker=scheduler.createWorker();
		System.out.println("in begininng of the main method thread is:"+Thread.currentThread().getName());
		worker.schedule(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub

				System.out.println(" in outer run Thread:-"+Thread.currentThread().getName());
				worker.schedule(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Observable.just(10).subscribe(item->System.out.println(" in inner run Thread:-"+Thread.currentThread().getName()+item));
						
					}
				});
				
				Observable.just(100,200).subscribe(new Observer<Integer>() {

					@Override
					public void onComplete() {
						// TODO Auto-generated method stub
						System.out.println(" in complete Thread:-"+Thread.currentThread().getName());
						
					}

					@Override
					public void onError(Throwable arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onNext(Integer value) {
						// TODO Auto-generated method stub
						System.out.println("thread:-"+Thread.currentThread().getName() + " got "+value);
						
					}

					@Override
					public void onSubscribe(Disposable arg0) {
						// TODO Auto-generated method stub
						
					}
				});;
				System.out.println(" in outer run Thread:-"+Thread.currentThread().getName()+" completed");
			}
		});
		worker.dispose();

	}

}
