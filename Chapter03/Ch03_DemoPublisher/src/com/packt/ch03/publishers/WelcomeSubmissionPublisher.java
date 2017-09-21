package com.packt.ch03.publishers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

public class WelcomeSubmissionPublisher {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		publish();
	}
	public static void publish()throws InterruptedException, ExecutionException 
	{
		CompletableFuture future = null;
		try (SubmissionPublisher publisher = new SubmissionPublisher<Long>()) {
			System.out.println("Subscriber Buffer Size: " + publisher.getMaxBufferCapacity());
			future=publisher.consume(System.out::println);
			LongStream.range(10, 20).forEach(publisher::submit);
		} finally {
			future.get();
		}
	}
}
