package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

public class Demo_first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruits = { "mango", "pineapple", "apple", "mango", "papaya" };
		Observable.fromArray(fruits).first("hello").subscribe(new SingleObserver<String>() {

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();
			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String value) {
				// TODO Auto-generated method stub
				System.out.println("we got: "+value +" items from the Observable");
			}
		});

		Observable.empty().first("hello")
				.subscribe(item -> System.out.println("we got: " + item + " items from the Observable"));

		Observable.never().first("hello").subscribe(new BiConsumer() {
			@Override
			public void accept(Object value, Object throwable) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("value:-"+value);
			}
		});
	}

}
