import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class DemoJust {

	public static void main(String[] args) {
		String [] monthArray= {"Jan","Feb","Mar","Apl","May","Jun","July","Aug","Sept","Oct","Nov","Dec"};
		List<String>months= Arrays.asList(monthArray);
		
		Observable.just(months).subscribe(item->System.out.println(item),
				                           error->System.out.println(error),()->System.out.println("Emission completed"));
		
	}

}
