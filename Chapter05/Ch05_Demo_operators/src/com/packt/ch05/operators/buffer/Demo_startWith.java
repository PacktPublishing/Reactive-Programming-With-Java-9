package com.packt.ch05.operators.buffer;

import java.util.Arrays;

import io.reactivex.Observable;

public class Demo_startWith {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruits = { "mango", "pineapple", "apple", "mango" };
		String [] newFruits= {"new Fruit1","new Fruit2"};
		Observable.fromArray(fruits).startWith(Arrays.asList(newFruits))
				.subscribe(System.out::println);
	

	}

}
