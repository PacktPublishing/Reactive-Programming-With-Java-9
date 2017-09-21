package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;

public class Demo_groupBy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] monthArray = { "January", "Feb", "March", "Apl", "May", "Jun", "July", "Aug", "Sept", "Oct", "Nov",
				"Dec" };

		Observable.fromArray(monthArray).groupBy((item) -> {
			if (item.length() <= 3)
				return "THREE";
			else if (item.length() >= 4 && item.length()<6 )
				return ">4";
			return "DEFAULT";
		}).subscribe(observable -> { // System.out.println(observable.getKey());
			observable.subscribe(item -> System.out.println(item + ":" + observable.getKey()));
		});

	}

}
