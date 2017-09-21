package com.packt.ch04.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.subscribers.DisposableSubscriber;

public class DemoDisposableSubscriber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisposableSubscriber<Long> disposableSubscriber = new DisposableSubscriber<Long>() {

			
			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("Its Done!!!");

			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();

			}

			@Override
			public void onNext(Long value_long) {
				// TODO Auto-generated method stub
				if(value_long==7)
					dispose();
				System.out.println("value :-" + value_long);
			}

			@Override
			protected void onStart() {
				// TODO Auto-generated method stub
				request(Long.MAX_VALUE);
			}
		};

		Flowable.rangeLong(5, 4).subscribe(disposableSubscriber);
		disposableSubscriber.dispose();

	}

}
