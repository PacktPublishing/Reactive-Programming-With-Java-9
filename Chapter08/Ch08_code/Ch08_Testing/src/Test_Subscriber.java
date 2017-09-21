import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import io.reactivex.Flowable;

public class Test_Subscriber {
	@Test
	public void test_subscriber() {

		DemoSubscriber demoSubscriber = new DemoSubscriber();
		Flowable.rangeLong(5, 4).subscribe(demoSubscriber);

		List<Long> items = demoSubscriber.getItems();
		assertEquals(4, items.size());
		assertTrue(6 == items.get(1));
	}

	@Test
	public void test_resourceSubscriber() {
		MyResourceSubscriber resourceSubscriber = new MyResourceSubscriber();

		assertFalse(resourceSubscriber.isDisposed());
		assertTrue(resourceSubscriber.values.isEmpty());
		assertTrue(resourceSubscriber.errors.isEmpty());

		Flowable.just(10l).subscribe(resourceSubscriber);

		assertTrue(resourceSubscriber.isDisposed());
		assertEquals(10l, resourceSubscriber.values.get(0).intValue());
		assertTrue(resourceSubscriber.errors.isEmpty());
	}

}