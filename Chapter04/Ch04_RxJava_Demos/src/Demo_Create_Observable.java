import io.reactivex.Observable;

public class Demo_Create_Observable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable observable=Observable.just("Welcome to RxJava");
		observable.subscribe(s->System.out.println(s));
	}
}
