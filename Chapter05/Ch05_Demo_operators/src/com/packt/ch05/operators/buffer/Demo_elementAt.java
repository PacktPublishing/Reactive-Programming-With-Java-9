package com.packt.ch05.operators.buffer;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class Demo_elementAt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruits = { "mango", "pineapple", "apple", "mango", "papaya", "pineapple", "apple", "apple" };
		Observable.fromArray(fruits).elementAt(3).count()
				.subscribe(item -> System.out.println("we got: " + item + " items from the Observable"));
		Observable.fromArray(fruits).elementAt(10).subscribe(new MaybeObserver<String>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("successfully completed");

			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				System.out.println(throwable.getMessage());

			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(String value) {
				// TODO Auto-generated method stub
				System.out.println("value at specified position is:-"+value);

			}
		});
	}

}
