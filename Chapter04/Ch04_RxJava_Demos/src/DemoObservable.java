import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class DemoObservable {

	public static void main(String[] args) {
	 Observable<String> month_observable = Observable.create(new 
       ObservableOnSubscribe<String>() {
			@Override
			public void subscribe(ObservableEmitter<String> emitter)    
            throws Exception {
				// TODO Auto-generated method stub
				try {
					String[] monthArray = { "Jan", "Feb", "Mar",    
                        "Apl", "May", "Jun", "July", "Aug",  
                        "Sept", "Oct","Nov", "Dec" };

					List<String> months = Arrays.asList(monthArray);

					for (String month : months) {
						emitter.onNext(month);
					}
					emitter.onComplete();
				} catch (Exception e) {
					// TODO: handle exception
					emitter.onError(e);
				}
			}
		});
		 month_observable.subscribe(s -> System.out.println(s));
	}
}
