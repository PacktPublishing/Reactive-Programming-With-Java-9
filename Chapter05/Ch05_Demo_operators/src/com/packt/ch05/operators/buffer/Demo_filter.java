package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Demo_filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruits = { "mango", "pineapple", "apple", "mango", "papaya" };
		Observable.fromArray(fruits).filter(item -> item.contains("le")).count()
				.subscribe(item -> System.out.println("we got: " + item + " items from the Observable"));
		Observable.fromArray(fruits).filter(item -> item.contains("le"))
				.subscribe(new Observer<String>() {

					@Override
					public void onComplete() {
						// TODO Auto-generated method stub
						System.out.println("filtering completed");
						
					}

					@Override
					public void onError(Throwable throwable) {
						// TODO Auto-generated method stub
						throwable.printStackTrace();
						
					}

					@Override
					public void onNext(String value) {
						// TODO Auto-generated method stub
						System.out.println(value);
						
					}

					@Override
					public void onSubscribe(Disposable disposable) {
						// TODO Auto-generated method stub
						
					}
				});

	}

}
