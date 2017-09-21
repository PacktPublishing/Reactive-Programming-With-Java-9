package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;

public class Demo_takeWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable source1 = Observable.range(3, 5);
		source1.takeWhile(new Predicate<Integer>() {

			@Override
			public boolean test(Integer value) throws Exception {
				// TODO Auto-generated method stub
				if (value > 5)
					return false;
				return true;
			}
		}).subscribe(new Observer<Integer>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("successfully completed the filteration");

			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				System.out.println(throwable.getMessage());

			}

			@Override
			public void onNext(Integer value) {
				// TODO Auto-generated method stub
				System.out.println("after checking emitted:-" + value);

			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub
				System.out.println(disposable.isDisposed());
			}
		});

	}

}
