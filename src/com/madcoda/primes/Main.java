package com.madcoda.primes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	
	int limit;
	int threads;
	
	int result;
	
	long startTime;
	long endTime;
	
	public Main(int limit, int threads){
		if(threads < 1){
			throw new IllegalArgumentException("You need at least 1 threads");
		}
		if(limit < 0){
			throw new IllegalArgumentException("N must be positive");	
		}
		this.limit = limit;
		this.threads = threads;
	}
	
	
	public void run(){
		
		ExecutorService threadpool = Executors.newFixedThreadPool(this.threads);
		
		PrimalityTester primeTester = new DefaultPrimalityTester();
		primeTester.setThreadPool(threadpool);
		
		PrimeCounter counter = new DefaultPrimeCounter();
		counter.setThreadPool(threadpool);
		counter.setPrimalityTester(primeTester);
		
		start();
		this.result = counter.count(0, limit, threads);
		stop();
		threadpool.shutdown();
	}
	
	public void start(){
		this.startTime = System.currentTimeMillis();
	}
	
	public void stop(){
		this.endTime = System.currentTimeMillis();
	}
	
	public int getResult() {
		return result;
	}


	public long getRunningTime(){
		return endTime - startTime;
	}
	
	
	public static void main(String[] args){
		
		if(args.length < 2){
			System.err.println("Usage : PrimeCounter.jar [N] [num_threads]");
			return;
		}
		
		int number = Integer.parseInt(args[0], 10);
		int numThreads = Integer.parseInt(args[1], 10);
		
		try{

			Main instance = new Main(number, numThreads);
			instance.run();
			
			System.out.println("No. of primes within " + number +" is " + instance.getResult());
			System.out.println("Calculation finished in " + instance.getRunningTime() + "ms with " + numThreads + " threads");

		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
	}

}
