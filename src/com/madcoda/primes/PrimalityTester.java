package com.madcoda.primes;

import java.util.concurrent.ExecutorService;

public interface PrimalityTester {
	
	
	/**
	 * Tester can use the threadpool to run concurrently
	 * @param threadpool
	 */
	public void setThreadPool(ExecutorService threadpool);
	
	
	/**
	 * Just answer a question : is the number prime?
	 * @param number
	 * @return
	 */
	public boolean isPrime(int number);

	
}
