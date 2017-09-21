

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class WelcomeSubscriber implements Subscriber<Long> {
	private Subscription subscription;
	private final long maxCount;
	private long counter;

	public WelcomeSubscriber(long maxCount) {
		this.maxCount =maxCount;
		}

	
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		System.out.printf(Thread.currentThread().getName()+" subscribed with max count %d\n", maxCount);
		subscription.request(maxCount);
	}

	@Override
	public void onNext(Long item) {
		counter++;
		System.out.println(Thread.currentThread().getName()+" received :"+  item);
		if (counter >= maxCount) {
			System.out.println("Cancelling  Processed item count:"+counter);
			// Cancel the subscription
			subscription.cancel();
		}
	}

	@Override
	public void onError(Throwable t) {
		t.printStackTrace();
	}

	@Override
	public void onComplete() {
		System.out.printf(Thread.currentThread().getName()+" got completed");
	}
}
