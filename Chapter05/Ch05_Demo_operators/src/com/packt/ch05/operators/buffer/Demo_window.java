package com.packt.ch05.operators.buffer;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

public class Demo_window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Observable.range(10, 20).debounce(1, TimeUnit.SECONDS).subscribe(System.out::println);

		String[] items = {"one", "two", "three", "four", "five", "six"};
		Observable.fromArray(items)
		    .debounce(item -> item.equals("one")
		            ? Observable.empty()
		            : Observable.timer(1, TimeUnit.SECONDS)).serialize().subscribe(System.out::println);

			
	}

}
