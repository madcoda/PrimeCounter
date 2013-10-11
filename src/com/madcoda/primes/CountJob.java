package com.madcoda.primes;

import java.util.concurrent.Callable;

/**
 * A worker that count the number of primes from start to end
 */
public class CountJob implements Callable<Integer> {
	
	int start;
	int end;
	PrimalityTester primeTest;
	
	public CountJob(int start, int end, PrimalityTester primeTest) {
		super();
		this.start = start;
		this.end = end;
		this.primeTest = primeTest;
	}

	@Override
	public Integer call() throws Exception {
		int result = 0;
		for(int i=start;i<=end;i++){
			if(primeTest.isPrime(i)){
				result++;
				//System.out.println(i + " ");
			}
		}
		return result;
	}

}
