package com.packt.ch05.operators.buffer;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class Demo_sequenceEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Observable names1 = Observable.fromArray(new String[] { "name1", "abc", "xyz", "lmn" });
		Observable names2 = Observable.fromArray(new String[] { "name1", "abc", "xyz", "lmn" });
		Observable.sequenceEqual(names1, names2).subscribe(new SingleObserver<Boolean>() {

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				System.out.println(throwable.getMessage());

			}

			@Override
			public void onSubscribe(Disposable disposable) {
				// TODO Auto-generated method stub
				System.out.println("is disposed:-" + disposable.isDisposed());

			}

			@Override
			public void onSuccess(Boolean value) {
				// TODO Auto-generated method stub
				if (value) {
					System.out
							.println("successfully finished comparision of two sequence and both sequences are equal");
				}
				else
				System.out.println("successfully finished comparision of two sequence and both sequences are NOT equal");
			}
		});
	}

}
