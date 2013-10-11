package com.madcoda.primes;

import java.util.concurrent.ExecutorService;


/**
 * An interface to count prime numbers, you can swap with any algorithm 
 * @author Jason
 */
public interface PrimeCounter {

	
	/**
	 * Inject the Primality Testing algorithm
	 * @param primeTest
	 */
	public void setPrimalityTester(PrimalityTester primeTest);
	
	
	/**
	 * Inject the Thread-pool
	 * @param threadpool
	 */
	public void setThreadPool(ExecutorService threadpool);
	
	
	/**
	 * Just count the number of primes between start and end,
	 * with the number of threads required
	 *  
	 * @param start
	 * @param end
	 * @param num_threads
	 * @return
	 */
	public int count(int start, int end, int num_threads);

	
}
