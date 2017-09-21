package com.packt.ch05.operators.buffer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

public class Demo_all {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Single<Boolean> single = Observable.fromArray(Arrays.asList(new Integer[] { 2, 12, 5, 70, 110 })).
			all(item -> {
			boolean flag = false;
			for (int i : item) {
				if (i % 2 != 0) {

					return false;
				}
			}
			return true;
		});
		single.subscribe(new Consumer<Boolean>() {

			@Override
			public void accept(Boolean passed) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(passed);

			}
		});

//		Observable source1 = Observable.range(3, 5);
//		source1.takeWhile(new Predicate<Integer>() {
//
//			@Override
//			public boolean test(Integer arg0) throws Exception {
//				// TODO Auto-generated method stub
//				if (arg0 > 5)
//					return false;
//				return true;
//			}
//		}).subscribe(System.out::println);


		
		
	}

}
