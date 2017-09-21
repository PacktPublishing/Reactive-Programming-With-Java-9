package com.packt.ch04.subscribers;

import org.reactivestreams.Subscriber;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.subscribers.DefaultSubscriber;

public class DemoDefaultSubscriber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Flowable< Long> flowable=Flowable.rangeLong(2, 12);
		flowable.subscribe(new DefaultSubscriber<Long>() {

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
			public void onNext(Long value) {
				// TODO Auto-generated method stub
				if(value==4)
					cancel();
				System.out.println("value:-" + value);

			}

			@Override
			protected void onStart() {
				// TODO Auto-generated method stub
				request(5);
			}

		});

	}
	

}
