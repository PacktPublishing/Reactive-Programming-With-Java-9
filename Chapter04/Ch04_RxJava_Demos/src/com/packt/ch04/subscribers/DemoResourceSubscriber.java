package com.packt.ch04.subscribers;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.ResourceSubscriber;

public class DemoResourceSubscriber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ResourceSubscriber<Long> resourceSubscriber = new ResourceSubscriber<Long>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("Its Done!!!");
				dispose();
			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();
				dispose();
			}

			@Override
			public void onNext(Long value_long) {
				// TODO Auto-generated method stub
				if(value_long==7)
					dispose();
				System.out.println("value :-"+value_long);
			}
			
			@Override
			protected void onStart() {
				// TODO Auto-generated method stub
				request(Long.MAX_VALUE);
			}
		};
		
		Flowable.rangeLong(5, 4).subscribe(resourceSubscriber);
		resourceSubscriber.dispose();
		
	}
	
}
