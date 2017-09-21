package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Demo_map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] monthArray = { "January", "Feb", "March", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov",
				"Dec" };

		Observable.fromArray(monthArray).map((item) -> {
			if (item.equals("January") || item.equals("March") || item.equals("May") || item.equals("July")
					|| item.equals("Aug") || item.equals("Oct") || item.equals("Dec"))
				return 31;
			else if (item.equals("Apl") || item.equals("Jun") || item.equals("Sept") || item.equals("Nov"))
				return 30;
			return 28;
		}).subscribe(new Observer<Integer>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
                System.out.println("sequence completed");
			}

			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNext(Integer no_of_days) {
				// TODO Auto-generated method stub
				System.out.println("number of days"+no_of_days);

			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
