import io.reactivex.Observable;

public class DemoObservable_error {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<String> observable = Observable.error(new Exception("We got an Exception"));
		observable.subscribe(item -> System.out.println("we got" + item), 
				error -> System.out.print(error));
	}

}
