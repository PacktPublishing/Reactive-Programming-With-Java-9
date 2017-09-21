package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Demo_combineLatest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruits = { "mango", "pineapple", "apple", "mango" };
		Observable.combineLatest(Observable.range(1, 3), Observable.fromArray(fruits), (item1, item2) -> item1 + item2)
				.subscribe(new Observer<String>() {

					@Override
					public void onComplete() {
						// TODO Auto-generated method stub
						System.out.println("latest items combined successfully");
						
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
					public void onSubscribe(Disposable arg0) {
						// TODO Auto-generated method stub
						
					}});
	}

}
