package com.packt.ch05.operators.buffer;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class DemoBuffer_count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable.range(10,9).buffer(2).subscribe(new Consumer<List<Integer>>() {
			
			@Override
			public void accept(List<Integer> items) throws Exception {
				// TODO Auto-generated method stub
				
				System.out.println(items);	
			}
		});
	}

}
