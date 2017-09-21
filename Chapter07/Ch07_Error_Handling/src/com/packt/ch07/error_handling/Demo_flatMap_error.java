package com.packt.ch07.error_handling;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class Demo_flatMap_error {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable.range(1, 10)
		.flatMap(v -> {
		    if (v < 5) {
		        return Observable.just(2* v);
		    }
		    if(v==6)
		    {
			return Observable.error(new Throwable("You Got An Exception"));
		    }
		    
		    	return Observable.just( v);
		    
		},true).doOnError(error->System.out.println("on doOnError:-"+error.getMessage())).subscribe(new Observer<Integer>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("sequence completed");

			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				throwable.printStackTrace();
			}

			@Override
			public void onNext(Integer value) {
				// TODO Auto-generated method stub
				System.out.println("got:-" + value);

			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub

			}
		});


	}

}
