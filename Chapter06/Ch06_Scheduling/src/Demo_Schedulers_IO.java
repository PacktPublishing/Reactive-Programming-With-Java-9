import java.util.Scanner;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Demo_Schedulers_IO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable.create(new ObservableOnSubscribe<Integer>() {

			@Override
			public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Thread:-"+Thread.currentThread().getName());
				emitter.onNext(getNum());
				emitter.onComplete();
			}
		}).subscribeOn(Schedulers.io()).subscribe(new Consumer<Integer>() {

			@Override
			public void accept(Integer value) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("Thread for subscription:-"+Thread.currentThread().getName());
				System.out.println(value);
				
			}
			
		});
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end of main:-"+Thread.currentThread().getName());
	}
	
	public static int getNum()
	{
		System.out.println("Thread for reading data:-"+Thread.currentThread().getName());
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter a num");
		int num=scanner.nextInt();;
		return num;
	}

	
}
