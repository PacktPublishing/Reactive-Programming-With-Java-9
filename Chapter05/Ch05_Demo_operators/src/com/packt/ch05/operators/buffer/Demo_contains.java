package com.packt.ch05.operators.buffer;

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Demo_contains {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observable<Integer>observable=Observable.just(22, 70, 9);
		observable.contains(10).subscribe(new Consumer<Boolean>() {
			@Override
			public void accept(Boolean passed) throws Exception {
				System.out.println(passed);
			}
		});

	}

}
