import io.reactivex.Observable;

public class DemoRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable<Integer> observable=Observable.range(10, 5);
		observable.subscribe(number->System.out.println(number));
	}
}
