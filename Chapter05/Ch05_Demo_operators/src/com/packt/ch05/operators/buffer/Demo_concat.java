package com.packt.ch05.operators.buffer;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Demo_concat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable source1=	Observable.range(1,5);
		Observable source2=Observable.just(10,20,30);
		Observable.concat(source1,source2).subscribe(new Consumer<Integer>() {

			@Override
			public void accept(Integer value) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(value);
				
			}
		});

	}

}
