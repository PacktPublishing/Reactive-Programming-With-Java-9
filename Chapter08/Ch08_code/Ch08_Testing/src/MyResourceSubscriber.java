import java.util.ArrayList;
import java.util.List;

import io.reactivex.subscribers.ResourceSubscriber;

public class MyResourceSubscriber extends ResourceSubscriber<Long> {
	List<Long> values = new ArrayList<Long>();

	List<Throwable> errors = new ArrayList<Throwable>();
	int complete;

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	public void onNext(Long value) {
		values.add(value);
		request(Long.MAX_VALUE);
	}

	@Override
	public void onError(Throwable e) {
		errors.add(e);
	}

	@Override
	public void onComplete() {
		dispose();
	}

}
