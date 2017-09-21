package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;

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
		    
		},true).subscribe(System.out::println, Throwable::printStackTrace);

	}

}
