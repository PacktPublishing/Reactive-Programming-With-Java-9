package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class Demo_switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable.range(1,5).switchOnNext(new ObservableSource<Observable<Integer>>() {

			@Override
			public void subscribe(Observer<? super Observable<Integer>> valu) {
				// TODO Auto-generated method stub
				System.out.println("subscribe");
				valu.onNext(Observable.range(10, 5));
				valu.onComplete();
				

			}
		}).subscribe(new Observer<Integer>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("complete");
				
			}

			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNext(Integer arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0);
				
			}

			@Override
			public void onSubscribe(Disposable arg0) {
				// TODO Auto-generated method stub
				
			}
		});

	}

}
