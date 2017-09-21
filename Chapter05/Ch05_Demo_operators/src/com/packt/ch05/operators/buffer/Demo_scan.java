package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Demo_scan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] prices = { 100, 20, 40, 10, 15 };
		Observable.fromArray(prices).scan((item1, item2) -> item1 + item2)
				.subscribe(new Observer<Integer>() {

					@Override
					public void onComplete() {
						// TODO Auto-generated method stub
						System.out.println("completed the sequence successfully");
					}

					@Override
					public void onError(Throwable throwable) {
						// TODO Auto-generated method stub
						throwable.printStackTrace();
						
					}

					@Override
					public void onNext(Integer item) {
						// TODO Auto-generated method stub
						System.out.println("amount:" + item);
						
					}

					@Override
					public void onSubscribe(Disposable arg0) {
						// TODO Auto-generated method stub
						
					}
				});
	}

}
