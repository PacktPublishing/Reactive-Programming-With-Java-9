package com.packt.ch03.backpressure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Future;

public class NumberSubscriber implements Subscriber<Long> {
	private Subscription subscription;
	int count;

	int buffSize;

	public NumberSubscriber(int count) {
		// TODO Auto-generated constructor stub
		this.count = count;
		buffSize = 3;

	}

	@Override
	public void onSubscribe(Subscription subscription) {
		(this.subscription = subscription).request(1);
	}

	@Override
	public void onNext(Long item) {
		System.out.println("counter:-" + count);
		if (count-- >= 0) {
			synchronized (this) {
				System.out.println(count + Thread.currentThread().getName() + "  item:-" + item);
				try {
						final BufferedReader reader = new BufferedReader(new FileReader("EAadhaar_518716747893_01102016191126_620507.pdf"));
						reader.lines().forEach(System.out::print);
				} catch (FileNotFoundException e) {
					// // TODO Auto-generated catch block
					e.printStackTrace();
				} 
				subscription.request(1);
			}
		} else {
			System.out.println(Thread.currentThread().getName() + "cancelling");
			subscription.cancel();
		}

	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.println("Done");
	}

}
