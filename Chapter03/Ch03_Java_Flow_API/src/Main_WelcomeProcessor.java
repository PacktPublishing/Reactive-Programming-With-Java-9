

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

public class Main_WelcomeProcessor {

	public static void main(String[] args) throws InterruptedException {

		SubmissionPublisher<Long> publisher = new SubmissionPublisher();

		int count = 5;
		WelcomeSubscriber subscriber = new WelcomeSubscriber(count);
		WelcomeProcessor<Long> processor = new WelcomeProcessor<>(n -> n % 5 == 0);
		publisher.subscribe(processor);
		processor.subscribe(subscriber);
		LongStream.range(10, 20).forEach(publisher::submit);
		Thread.sleep(1000);
	}
}
