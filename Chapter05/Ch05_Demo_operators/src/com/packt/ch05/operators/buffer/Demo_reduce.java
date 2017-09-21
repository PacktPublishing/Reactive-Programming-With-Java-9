package com.packt.ch05.operators.buffer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Demo_reduce {
	public static void main(String[] args) {
		Integer[] numbers = { 1, 2, 13, 34, 12, 10 };
		Observable<Integer> source1 = Observable.fromArray(numbers);

		source1.reduce(new BiFunction<Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer value1, Integer value2) throws Exception {
				// TODO Auto-generated method stub
				// 1, 2, 13, 34, 12, 10
				int sum = 0;
				return value1 + value2;
			}
		}).subscribe(new MaybeObserver<Integer>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("completed2");

			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				System.out.println(throwable.getMessage());

			}

			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(Integer value) {
				// TODO Auto-generated method stub
				System.out.println(value);

			}
		});

		
                
	}

}
