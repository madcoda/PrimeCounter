package com.madcoda.primes;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * This implementation divide the range of numbers into even portion
 * (equal to the number of threads available)
 * 
 * @author Jason
 */
public class DefaultPrimeCounter implements PrimeCounter {
	
	PrimalityTester primeTester;
	ExecutorService threadpool;

	@Override
	public int count(int start, int end, int num_threads) {
		
		try{
			int result = 0;
			if(num_threads == 1){
				CountJob job = new CountJob(start, end, primeTester);
				result = job.call();
			}else{
				
				List<Future<Integer>> tasks = new ArrayList<Future<Integer>>(num_threads);
				
				int batchSize = (end-start)/num_threads;
				for(int i=1;i<=num_threads;i++){
					int currStart = batchSize *(i-1)+1;
					int currEnd = batchSize * i ;
					if(i == num_threads)
						currEnd = end;
					CountJob job = new CountJob(currStart, currEnd, primeTester);
					Future<Integer> future = threadpool.submit(job);
					tasks.add(future);
				}
				
				//collect
				for(Future<Integer> task : tasks){
					result += task.get();
				}
			}
			
			return result;
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void setPrimalityTester(PrimalityTester primeTester) {
		this.primeTester = primeTester;
	}

	@Override
	public void setThreadPool(ExecutorService threadpool) {
		this.threadpool = threadpool;
	}

}
