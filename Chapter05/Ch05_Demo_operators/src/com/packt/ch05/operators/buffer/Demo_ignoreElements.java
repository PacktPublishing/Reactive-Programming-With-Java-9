package com.packt.ch05.operators.buffer;

import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public class Demo_ignoreElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] fruits = { "mango", "pineapple", "apple", "mango", "papaya" };
		Observable.fromArray(fruits).ignoreElements().subscribe(
			new CompletableObserver() {
			long time=0;
			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub
				time=System.currentTimeMillis();
				System.out.println(disposable.isDisposed()+"\t"+time);
				
				
			}
			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();
			}
			
			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("completed");
				long time_to_complete=System.currentTimeMillis()-time;
				System.out.println("process completedin: "+time_to_complete+"ms");
				
			}
		});
				


	}

}
