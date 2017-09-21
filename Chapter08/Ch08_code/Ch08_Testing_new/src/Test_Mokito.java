import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;
import io.reactivex.subscribers.TestSubscriber;

public class Test_Mokito {

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Mock
	MyOpeartor myOperator;

	@Test
	public void test_single() {

		Mockito.when(myOperator.getSingleValue()).thenReturn(Single.just("MyValue"));
		TestObserver<String> testObserver = myOperator.getSingleValue().test();
		testObserver.awaitTerminalEvent();
		testObserver.assertValue("MyValue");

	}

	@Test
	public void test_fromArray() {
		int[] arr = { 12, 34, 54, 6, 7 };
		Mockito.when(myOperator.createObservable()).thenReturn(Observable.fromArray(arr));
		TestObserver<int[]> testObserver = myOperator.createObservable().test();
		testObserver.awaitTerminalEvent();
		testObserver.assertValue(arr);

	}

}
