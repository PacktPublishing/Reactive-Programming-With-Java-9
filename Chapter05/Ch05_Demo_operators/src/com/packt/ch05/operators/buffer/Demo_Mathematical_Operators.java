package com.packt.ch05.operators.buffer;

import java.util.concurrent.TimeUnit;

import hu.akarnokd.rxjava2.math.MathFlowable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import rx.observables.*;

public class Demo_Mathematical_Operators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MathFlowable.averageDouble(Flowable.range(10, 9)).subscribe(item->System.out.println("average is:-"+item));
		MathFlowable.sumInt(Flowable.range(10,9)).subscribe(item->System.out.println("sum is:-"+item));
		MathFlowable.min(Flowable.range(10,9)).subscribe(item->System.out.println("minimum number from the sequence is:-"+item));
		MathFlowable.max(Flowable.range(10,9)).subscribe(item->System.out.println("maximum number from the sequence is:-"+item));
		
		
		
	}

}