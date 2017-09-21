package com.packt.ch05.operators.buffer;

import org.reactivestreams.Subscription;

import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;

public class Demo_average {

	public static void main(String[] args) {
		MathFlowable.averageDouble(Flowable.range(10, 9)).subscribe(new FlowableSubscriber() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("completed successfully");
			}

			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNext(Object value) {
				// TODO Auto-generated method stub
				System.out.println("average:-" + value);
			}

			@Override
			public void onSubscribe(Subscription subscription) {
				// TODO Auto-generated method stub
				subscription.request(1);
			}
		});
	}

}
