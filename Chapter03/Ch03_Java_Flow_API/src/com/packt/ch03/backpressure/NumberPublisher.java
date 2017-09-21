package com.packt.ch03.backpressure;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.Future;
import java.util.stream.LongStream;

public class NumberPublisher implements Publisher<Long> {

	private final ExecutorService executor = Executors.newFixedThreadPool(12);;
	long start_range,stop_range;
	
	public NumberPublisher(long start_range,long stop_range)
	{
		this.start_range=start_range;
		this.stop_range=stop_range;
	}
	
	@Override
	public void subscribe(Subscriber<? super Long> subscriber) {
		// TODO Auto-generated method stub
		subscriber.onSubscribe(new NumberSubscription(executor,subscriber,start_range,stop_range));

	}

	class NumberSubscription implements Subscription {
		private final ExecutorService executor;
		Subscriber<? super Long> subscriber;
		long start_range,stop_range;
		Future<?> future;
		public NumberSubscription(ExecutorService executor,Subscriber<? super Long> subscriber,long start_range,long stop_range) {
			// TODO Auto-generated constructor stub
			this.executor = executor;
			this.subscriber=subscriber;
			this.start_range=start_range;
			this.stop_range=stop_range;
		}

		@Override
		public void cancel() {
			// TODO Auto-generated method stub
			executor.shutdown();
			System.out.println("shutting down");
			future.cancel(true);

		}

		@Override
		public void request(long item) {
			// TODO Auto-generated method stub
			System.out.println("requesting :"+item);
			
			future=	executor.submit(() -> {
					LongStream stream=LongStream.range(start_range,stop_range);
					stream.forEach(subscriber::onNext);
//					subscriber.onNext(item);
				});
				subscriber.onComplete();
		}

	}
}
