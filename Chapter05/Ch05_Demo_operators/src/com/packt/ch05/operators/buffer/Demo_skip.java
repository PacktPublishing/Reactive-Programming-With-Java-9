package com.packt.ch05.operators.buffer;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class Demo_skip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruits = { "mango", "pineapple", "apple", "mango", "papaya" };
		Observable.fromArray(fruits).skip(3).subscribe(System.out::println);
	}

}
