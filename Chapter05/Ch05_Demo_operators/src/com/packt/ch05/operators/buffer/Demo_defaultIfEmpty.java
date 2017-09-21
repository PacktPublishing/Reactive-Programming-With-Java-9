package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Demo_defaultIfEmpty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable.empty().defaultIfEmpty(100).
        subscribe(new Observer() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("the sequence got completed");
			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();
			}
			@Override
			public void onNext(Object value) {
				// TODO Auto-generated method stub
				System.out.println("emitted:-"+value);
				
			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub
				System.out.println(disposable.isDisposed());
				
			}
});


	}

}
