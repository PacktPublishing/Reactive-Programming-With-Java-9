package com.packt.ch04.subscribers;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;

public class DemoCompositeDisposable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CompositeDisposable disposable = new CompositeDisposable();
		disposable.add(Flowable.rangeLong(10, 5).subscribe(System.out::println));
		disposable.add(Flowable.rangeLong(1, 5).subscribe(item -> System.out.println("two" + item)));

		disposable.add(Observable.create(new ObservableOnSubscribe<String>() {

			@Override
			public void subscribe(ObservableEmitter<String> emitter) throws Exception {
				// TODO Auto-generated method stub

				try {
					String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct",
							"Nov", "Dec" };

					List<String> months = Arrays.asList(monthArray);

					for (String month : months) {
						emitter.onNext(month);
					}
					emitter.onComplete();
				} catch (Exception e) {
					// TODO: handle exception
					emitter.onError(e);
				}
			}
		}).subscribe(s -> System.out.println(s)));

		disposable.dispose();
	
		
	}

}
