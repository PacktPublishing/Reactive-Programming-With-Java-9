package com.packt.ch05.operators.buffer;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Demo_merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable.merge(Observable.range(1, 5), Observable.range(100, 5)).subscribe(new Observer<Integer>() {

				@Override
				public void onComplete() {
					// TODO Auto-generated method stub
					System.out.println("items merged successfully");

				}

				@Override
				public void onError(Throwable throwable) {
					// TODO Auto-generated method stub
					throwable.printStackTrace();
				}

				@Override
				public void onNext(Integer value) {
					// TODO Auto-generated method stub
					System.out.println("collected item: " + value);

				}

				@Override
				public void onSubscribe(Disposable disposable) {
					// TODO Auto-generated method stub

				}
			});

	}

}
