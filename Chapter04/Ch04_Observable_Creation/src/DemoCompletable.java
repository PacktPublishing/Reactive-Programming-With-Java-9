import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

public class DemoCompletable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Completable completable = Completable.fromAction(() -> System.out.println("Welcome to Completable"));
		completable.subscribe();

		
	}

}
