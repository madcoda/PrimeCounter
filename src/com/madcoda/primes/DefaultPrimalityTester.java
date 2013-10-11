package com.madcoda.primes;

import java.util.concurrent.ExecutorService;

public class DefaultPrimalityTester implements PrimalityTester {

	@Override
	public boolean isPrime(int number) {
		if(number <= 1)
			return false;
		if(number == 2) return true;
		
		int limit = (int) Math.round(Math.ceil(Math.sqrt(number)));
		for(int i=2;i<=limit;i++){
			if(number%i == 0){
				return false;
			}
		}
		return true;
	}

	@Override
	public void setThreadPool(ExecutorService threadpool) {
		//Do nothing, this implementation is not concurrent
	}

}
