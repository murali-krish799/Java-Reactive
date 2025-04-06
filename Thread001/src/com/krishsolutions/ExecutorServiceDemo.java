package com.krishsolutions;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		// normal threads synchronously take time
//		long startingTime = System.currentTimeMillis();
//		
//		String firstName = firstName();
//		String secondName = secondName();
//		System.out.println(firstName+secondName);
//
//		System.out.println("time calculation "+(System.currentTimeMillis()-startingTime));

		// this is executorService thread performance here..
		long startingTime = System.currentTimeMillis();

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Future<String> submit = executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return firstName();
			}
		});
		Future<String> submit2 = executorService.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				return secondName();
			}
		});

		
		System.out.println(submit.get() + submit2.get());

		System.out.println("time calculation " + (System.currentTimeMillis() - startingTime));

	}

	public static String firstName() throws InterruptedException {
		Thread.sleep(2000);
		return "omit";
	}

	public static String secondName() throws InterruptedException {
		Thread.sleep(4000);
		return "_krish";
	}
}
