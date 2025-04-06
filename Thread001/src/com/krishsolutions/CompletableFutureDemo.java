package com.krishsolutions;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

	public static void main(String[] args) {

		System.out.println("main thread :" + Thread.currentThread().getName());
long stsrtingTime=System.currentTimeMillis();
		CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> firstName());
		CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> secondName());

		String result = completableFuture1.thenCombine(completableFuture2, (first, second) -> first + second).join();
		
		System.out.println("final result is  :" + result);
		System.out.println(System.currentTimeMillis()-stsrtingTime);

	}

	public static String firstName() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "omit";
	}

	public static String secondName() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "_krish";
	}

}
