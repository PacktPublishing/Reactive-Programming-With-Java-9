import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subscribers.TestSubscriber;

public class Test_test_operator {

	@Test
	public void testOperator() {
		TestSubscriber<Long> test_Subscriber = Flowable.rangeLong(10, 5).test();
		TestObserver<Integer> testObserver = Observable.just(12, 89, 67).test();
		TestObserver<String> testObserver2 = Single.just("hello").test();
		TestObserver<String> testObserver3 = Maybe.just("Mango").test();
	}

	@Test
	public void testOperator_range() {
		TestSubscriber<Long> test_Subscriber = Flowable.rangeLong(10, 5).test();
		test_Subscriber.assertResult(10L, 11L, 12L, 13L, 14L);
		test_Subscriber.assertValueAt(2, (item) -> {
			return item == 12L;
		});

	}

	@Test
	public void test_just() {
		Observable.just(12, 6, 33, 90).test().assertResult(12, 6, 33, 90);
	}

	@Test
	public void testOperator_test1() {
		TestSubscriber<Long> test_Subscriber = Flowable.rangeLong(10, 5).test(2);
		test_Subscriber.assertValues(10l, 11l);
		// test_Subscriber.requestMore(2);
		test_Subscriber.assertValues(10l, 11l, 12l, 13l);
		test_Subscriber.requestMore(1);
		test_Subscriber.assertValues(10l, 11l, 12l, 13l, 14l);
	}

	@Test
	public void test_PublishSubject() {
		PublishSubject<Long> publishSubject = PublishSubject.create();
		publishSubject.onNext(1L);
		publishSubject.onNext(2l);
		Assert.assertFalse(publishSubject.hasObservers());

		TestObserver<Long> testObserver = publishSubject.test(true);
		Assert.assertFalse(publishSubject.hasObservers());
	}

	@Test
	public void test_asyn() {

		Flowable.just(1).subscribeOn(Schedulers.trampoline()).test().awaitDone(5, TimeUnit.SECONDS).assertResult(1);
	
	}
}
