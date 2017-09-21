import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import io.reactivex.Observable;
public class DemoCreate {
	public static void main(String[] args) {
		String[] monthArray = { "Jan", "Feb", "Mar", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov", "Dec" };
		List<String> months = Arrays.asList(monthArray);

		Observable.create(subscriber -> {
			try {
				
				for(String data:months )
				{
					subscriber.onNext(data);
				}
				subscriber.onComplete();
			}catch (Exception e) {
				// TODO: handle exception
				subscriber.onError(e);
			}
		}).subscribe(item->System.out.println(item),
                error->System.out.println(error),()->System.out.println("Emission completed"));
		


	}

}
