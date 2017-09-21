package com.packt.ch04.subscribers;

import java.util.Arrays;
import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MyObserver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Observable<Long>observable=Observable.rangeLong(1l,3l);
		Observer< Long> observer=new Observer<Long>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("on complete");
				
			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();
				
			}

			@Override
			public void onNext(Long value) {
				// TODO Auto-generated method stub
				System.out.println(""+value);
				
			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub
				System.out.println(disposable.isDisposed());
				disposable.dispose();
				
			}
		};
		observable.subscribe(observer);
		
	}

}
