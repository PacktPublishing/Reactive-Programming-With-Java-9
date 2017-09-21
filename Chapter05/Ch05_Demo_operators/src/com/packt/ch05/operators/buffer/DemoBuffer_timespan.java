package com.packt.ch05.operators.buffer;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class DemoBuffer_timespan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// not working
//		Observable.interval(1, TimeUnit.SECONDS).take(10)
//		.buffer(1, TimeUnit.SECONDS)
//		.subscribe(item->System.out.println(item));
		
		Observable.interval(1, TimeUnit.SECONDS).take(10)
		.buffer(Observable.interval(2, TimeUnit.SECONDS))
		.subscribe(System.out::println);
		

	}

}
