

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.LongStream;

public class Main_WelcomeSubscriber {
	public static void main(String[] args) throws InterruptedException {

		SubmissionPublisher<Long> publisher = new SubmissionPublisher();

		int count = 5;
		WelcomeSubscriber subscriber = new WelcomeSubscriber(count);
		publisher.subscribe(subscriber);
		LongStream.range(10, 20).forEach(publisher::submit);
		Thread.sleep(1000);

	}
}
