package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public class Demo_distinctUntilChanged {
	public static void main(String[] args) {

		String[] fruits = { "mango", "pineapple", "apple", "mango", "papaya", "pineapple", "apple", "apple" };
		Single<Long> sing = Observable.fromArray(fruits).distinctUntilChanged().count();
		sing.subscribe(System.out::println);

		Observable.fromArray(fruits).distinctUntilChanged().subscribe(new Observer<String>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("collected all  items successfully");

			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();
			}

			@Override
			public void onNext(String value) {
				// TODO Auto-generated method stub
				System.out.println("collected item: " + value);

			}

			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

}
