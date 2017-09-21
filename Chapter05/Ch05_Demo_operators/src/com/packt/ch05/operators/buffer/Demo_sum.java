package com.packt.ch05.operators.buffer;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.Flowable;

public class Demo_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MathFlowable.sumInt(Flowable.range(10, 9)).subscribe(new 
			      Subscriber<Integer>() {

						@Override
						public void onComplete() {
							// TODO Auto-generated method stub
							System.out.println("completed successfully");
							
						}

						@Override
						public void onError(Throwable throwable) {
							// TODO Auto-generated method stub
							throwable.printStackTrace();
							
						}

						@Override
						public void onNext(Integer value) {
							// TODO Auto-generated method stub
							System.out.println(value);
						}

						@Override
						public void onSubscribe(Subscription subscription) {
							// TODO Auto-generated method stub
							subscription.request(1);
						}
					});


	}

}
