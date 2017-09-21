package com.packt.ch03.backpressure;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.SubmissionPublisher;

public class Main_NumberPublisher {
	public static void main(String[] args) {

		long start_range=10, stop_range=22;
		Publisher<Long> publisher = new NumberPublisher(start_range,stop_range);

		// Register Subscriber
		int count=5;
		NumberSubscriber subscriber = new NumberSubscriber(count);
		publisher.subscribe(subscriber);
		
		

	}

}
