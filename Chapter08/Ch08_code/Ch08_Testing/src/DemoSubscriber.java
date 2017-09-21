
import java.util.ArrayList;
import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

class DemoSubscriber implements Subscriber<Long> {
	
	List<Long>items=new ArrayList();
	
	public List<Long> getItems() {
		return items;
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		System.out.println("Its Done!!!");
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		throwable.printStackTrace();
	}

	@Override
	public void onNext(Long value_long) {
		// TODO Auto-generated method stub
		System.out.println(value_long);
		items.add(value_long);
		
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		System.out.println("onSubscribe invoked");
		subscription.request(Long.MAX_VALUE);
	}
}

