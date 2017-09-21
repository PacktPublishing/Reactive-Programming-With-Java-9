package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class Demo_flatMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Observable.range(1, 5).flatMap(item -> Observable.range(item, 3))
				.subscribe(value -> System.out.print(value + "->"));
		System.out.println();
//		Observable.range(1, 5).concatMap(item -> Observable.range(item, 3))
//				.subscribe(value -> System.out.print(value + "->"));
	}

}
