package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class Demo_switchIfEmpty {
	public static void main(String[] args) {
		Observable source2 = Observable.empty();
		source2.switchIfEmpty(Observable.just(10)).subscribe(
		    new Consumer<Integer>() {

					@Override
					public void accept(Integer value) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("value emitted:"+value);
					}
		});

	}

}
