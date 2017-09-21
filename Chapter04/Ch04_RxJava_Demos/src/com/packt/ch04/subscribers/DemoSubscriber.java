package com.packt.ch04.subscribers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;

public class DemoSubscriber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subscriber< Long> subscriber=new Subscriber<Long>() {
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
				System.out.println("onNext() value :-"+value_long);
				
			}

			@Override
			public void onSubscribe(Subscription subscription) {
				// TODO Auto-generated method stub
				System.out.println("onSubscribe invoked");
				subscription.request(Long.MAX_VALUE);
			}
		};
		Flowable.rangeLong(5, 4).subscribe(subscriber);
	}
}
