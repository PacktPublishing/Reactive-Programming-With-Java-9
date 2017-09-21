

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Predicate;

public class WelcomeProcessor<T> extends SubmissionPublisher<T> implements Processor<T, T> {
	private Predicate<? super T> filter;

	public WelcomeProcessor(Predicate<? super T> filter) {
		this.filter = filter;
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		// Request an unbounded number of items
		subscription.request(Long.MAX_VALUE);
		// Long.MAX_VALUE is considered as unbounded 
	}

	@Override
	public void onNext(T item) {
		// If the item passes the filter publish it. Otherwise, no action is
		// needed.
		System.out.println("Processor received: " + item);
		if (filter.test(item)) {
			this.submit(item);
		}
	}

	@Override
	public void onError(Throwable t) {
		// Pass the onError message to all subscribers asynchronously
		this.getExecutor().execute(() -> this.getSubscribers().forEach(s -> s.onError(t)));
	}

	@Override
	public void onComplete() {
		System.out.println("Processor is complete.");
		this.close();
	}
}
