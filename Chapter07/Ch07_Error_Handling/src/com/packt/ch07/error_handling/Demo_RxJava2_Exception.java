package com.packt.ch07.error_handling;

import java.io.IOException;
import java.net.SocketException;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

public class Demo_RxJava2_Exception {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RxJavaPlugins.setErrorHandler(e -> {
			if (e instanceof UndeliverableException) {
				//undeliverable exception
				e = e.getCause();
			}
			if (e instanceof IOException) {
				// problems realted to IO
				System.out.println(e.getMessage());
			}
			if (e instanceof SocketException) {
				// network problem or API that throws on cancellation
				System.out.println("its socket exception"+e.getMessage());
				return;
			}
			if (e instanceof InterruptedException) {
				// blocking code was interruption
				return;
			}
			if (e instanceof NullPointerException){
				//  a bug in the application
				Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
				return;
			}
			if(e instanceof IllegalArgumentException)
			{
				return;
			}
			if (e instanceof RuntimeException) {
				Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
				return;
			}
			if (e instanceof IllegalStateException) {
				// that's a bug in operator
				Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
				return;
			}
		});

		Observable<Integer> observable = Observable.just(12, 30, 5, 50, 89);
		observable.filter(item -> {
			try {
				return check(item);
			} catch (IOException e) {
				// TODO: handle exception
				throw new RuntimeException("re throwing exception"+e.getMessage());
			}
		}).subscribe(new Observer<Integer>() {

			@Override
			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("sequence completed");

			}

			@Override
			public void onError(Throwable throwable) {
				// TODO Auto-generated method stub
				// throwable.printStackTrace();
				RxJavaPlugins.onError(throwable);
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

	public static boolean check(int item) throws IOException {
		boolean result = false;
		if (item > 10)
			result = true;
		else
			throw new IOException("***got an exception****");
		return result;

	}

}
