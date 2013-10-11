## Prime Counter

This piece of code compute the number of primes within N.  i.e. [0 ... N]. This code is multi-threaded. It uses the most basic Divide-and-conquer technique to split the task with equal portion of range of numbers for each worker thread to compute.

Well...this code is not the most elegant nor efficient code, I think it might be useful for beginners to learn how to make use of multi-core CPU, and increase performance of computation. You can also use this code for benchmarking multi-core computers. 

### Usage

Download the PrimeCounter.jar

    java -jar PrimeCounter.jar [N] [num of threads]

e.g.

    java -jar PrimeCounter.jar 999999 4
    java -jar PrimeCounter.jar 9999999 16

### Building
Using Ant, you can build the project by running "ant"

    > ant
    Buildfile: /home/jason/git/primecounter/build.xml

	init:
	    [mkdir] Created dir: /home/jason/git/primecounter/bin

	compile:
	    [javac] Compiling 2 source files to /home/jason/git/primecounter/bin

	dist:
	    [mkdir] Created dir: /home/jason/git/primecounter/dist/lib
	      [jar] Building jar: /home/jason/git/primecounter/dist/lib/PrimeCounter.jar

	BUILD SUCCESSFUL
	Total time: 0 seconds


### Observations
On a multi-core computer, increasing the number of threads does shorten the time of computation. If you keep adding more threads, to a certain point it won't get any faster. It is because the CPU can only run limited num of threads concurrently. For example, a Intel i5 processor has 4 cores, with Hyper-threading technology, it can run 8 threads concurrently. (Interestingly, if you increase the number of threads to 16 or higher, you still get some performance increase even though your CPU won't be able to run all of them at once, I still don't know why)
