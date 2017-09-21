import io.reactivex.Observable;

public class DemoObservable_empty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<String> observable = Observable.empty();
		observable.subscribe(item -> System.out.println("we got" + item), 
				error -> System.out.print(error),
				()->System.out.print("I am Done!! Completed normally"));
	}
}
