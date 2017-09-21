import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;

public class Traditional_Testing {
	@Test
	public void test_just() {
		Observable<Integer> observable = Observable.just(12, 34, 6);
		ArrayList<Integer> list = new ArrayList();
		observable.subscribe(item -> list.add(item));

		assertNotNull(list);
		assertEquals(3, list.size());
		assertEquals(6, list.get(2).intValue());
	}
	

	
}
