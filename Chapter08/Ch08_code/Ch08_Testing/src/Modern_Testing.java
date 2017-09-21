import static org.junit.Assert.assertTrue;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import io.reactivex.subscribers.TestSubscriber;

public class Modern_Testing {
	@Test
	public void test_just_new() {
		Observable<Integer> observable = Observable.just(12, 34, 6);
		TestObserver<Integer> testObserver = new TestObserver<>();

		observable.subscribe(testObserver);

		List<Integer> list = new ArrayList();
		testObserver.assertComplete();
		testObserver.assertResult(12, 34, 6);
		testObserver.assertValueCount(3);
		testObserver.assertNoErrors();
		testObserver.assertValueAt(2, (value) -> {
			// TODO Auto-generated method stub
			return value == 34;
		});

	}

	@Test
	public void test_skip() {
		String[] fruits = { "mango", "pineapple", "apple", "mango", "papaya" };
		Observable<String> observable = Observable.fromArray(fruits).skip(3);
		TestObserver<String> testObserver = new TestObserver<>();
		observable.subscribe(testObserver);

		testObserver.assertComplete();
		testObserver.assertValueCount(2);
		testObserver.assertNoErrors();
		testObserver.assertValues("mango", "papaya");
	}

	@Test
	public void test_never() {
		Observable<String> observable = Observable.never();
		TestObserver<String> testObserver = new TestObserver<>();
		observable.subscribe(testObserver);

		testObserver.assertNoValues();
		testObserver.assertTerminated();
		// testObserver.assertComplete();
	}

	@Test
	public void test_just_Flowable() {

		Flowable<String> observable = Flowable.just("mango", "papaya", "guava");
		TestSubscriber<String> testSubscriber = new TestSubscriber<>();

		observable.subscribe(testSubscriber);

		List<String> items = testSubscriber.values();
		testSubscriber.assertComplete();
		testSubscriber.assertSubscribed();
		testSubscriber.assertNoErrors();
		testSubscriber.assertValueCount(3);
		testSubscriber.assertValues("mango", "papaya", "guava");

	}

	@Test
	public void test_Single() {
		Single<String> single = Single.just("FRUITS");
		TestObserver<String> testObserver = new TestObserver<>();

		single.subscribe(testObserver);

		testObserver.assertComplete();
		testObserver.assertValueCount(1);
		testObserver.assertNoErrors();
		testObserver.assertValues("FRUITS");
	}

	@Test
	public void test_error() {
		Observable<String> observable = Observable.error(new Exception("We got an Exception"));
		TestObserver<String> testObserver = new TestObserver<>();

		observable.subscribe(testObserver);

		testObserver.assertError(Exception.class);
		testObserver.assertNotComplete();
		testObserver.assertErrorMessage("We got an Exception");
		testObserver.assertFailure(exception -> {
			return exception instanceof Exception;
		});

		testObserver.assertFailureAndMessage(Exception.class, "We got an Exception");
	}
	
	@Test
	public void test_interval()
	{
		TestScheduler testScheduler=new TestScheduler();
		Observable<Long>observable=Observable.interval(1, TimeUnit.SECONDS,testScheduler).take(5);
		TestObserver<Long> testObserver=new TestObserver<>();

		
		observable.subscribeOn(testScheduler).subscribe(testObserver);
		
		testObserver.assertNoValues();
		testObserver.assertNotComplete();
		testObserver.assertNoErrors();
		
		testScheduler.advanceTimeBy(1, TimeUnit.SECONDS);
		testObserver.assertValueCount(1);
		testObserver.assertValues(0l);
		
		testScheduler.advanceTimeTo(6, TimeUnit.SECONDS);
		testObserver.assertValueCount(5);
		testObserver.assertValues(0l,1l,2l,3l,4l);
	}


}
