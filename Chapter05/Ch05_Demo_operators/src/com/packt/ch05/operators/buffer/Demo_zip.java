package com.packt.ch05.operators.buffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

public class Demo_zip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] numbers = { 1, 2, 13, 34, 12, 10 };
		String[] fruits = { "mango", "pineapple", "apple", "mango", "papaya" };

		Observable<Integer> source1 = Observable.fromArray(numbers);
		Observable<String> source2 = Observable.fromArray(fruits);
		Observable<Integer> source3 = Observable.range(30, 3);
		Observable.zip(source1, source2, source3, (value1, value2, value3) -> {

			return value1 + ":" + value2 + "*" + value3;
		}).subscribe(new Observer<String>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("zipping completed successfully");

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

			}
		});
	}

}
