import io.reactivex.Observable;

public class DemoObservable_never {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<String> observable=Observable.never();
		observable.subscribe(item-> System.out.println("we got"+item));
	}
}
