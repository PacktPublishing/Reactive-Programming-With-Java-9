package com.packt.ch05.operators.buffer;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Demo_interval {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Observable.interval(1000, TimeUnit.MILLISECONDS).take(5)
		.subscribe(System.out::println);
		Thread.sleep(10000);

	}

}
