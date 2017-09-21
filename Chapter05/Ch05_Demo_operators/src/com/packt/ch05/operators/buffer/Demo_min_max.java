package com.packt.ch05.operators.buffer;

import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.Flowable;

public class Demo_min_max {

	public static void main(String[] args) {
		MathFlowable.min(Flowable.range(10, 9))
				.subscribe(item -> System.out.println("minimum number from the sequence is:-" + item));
		MathFlowable.max(Flowable.range(10,9))
				.subscribe(item -> System.out.println("maximum number from the sequence is:- " + item));

	}
}
